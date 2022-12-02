
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class TestCases extends BaseTest{
    private static Logger logger = LogManager.getLogger(TestCases.class);
    public String loginUrl="https://www.e-bebek.com/login";
    WebDriverWait wait;

    @Test
    @Order(1)
    public void test_1_1_homePage(){
        driver.get("https://www.e-bebek.com");
        driver.manage().window().maximize();
        try {
            Assert.assertEquals("ebebek | Anne ve Bebek Ürünleri - Bebek Mağazaları",driver.getTitle());
        } catch (Exception e){
            logger.error("Hatalı başlık.");
        }
        logger.info("Anasayfaya giriş yapıldı.");

    }
    @Test()
    @Order(2)
    public void test_1_2_search() throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.id("txtSearchBox"));
        txtSearch.sendKeys("kaşık maması");
        txtSearch.sendKeys(Keys.ENTER);
        logger.info("Ürünler listelendi.");
        Thread.sleep(4000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1000);
        List<WebElement> buttons=driver.findElements(By.id("addToCartBtn"));
        int size=buttons.size();
        List<WebElement> products=driver.findElements(new By.ByCssSelector("span.description"));
        products.get(size-1).click();
        Thread.sleep(4000);

    }
    @Test
    @Order(3)
    public void test_1_3_addBasket()throws InterruptedException{
        driver.findElement(By.id("addToCartBtn")).click();
        Thread.sleep(4000);
        logger.info("Sepete eklendi.");
    }
    @Test
    @Order(4)
    public void test_1_4_showBasket() throws InterruptedException {
        Thread.sleep (3000L);
        driver.findElement(By.id("btnShowCart")).click();
        logger.info("Sepet görüntülendi.");

    }
    @Test
    @Order(5)
    public void test_1_5_complete() throws InterruptedException {
        Thread.sleep(4000);

        driver.findElement(By.id("btnGoToShippingAddress")).click();
        logger.info("Alışveriş tamamlandı.");

    }
    @Test
    public void test_1_7_control(){
        driver.get(loginUrl);
        driver.manage().window().maximize();
        try {
            Assert.assertEquals("Giriş Yap",driver.getTitle());
        } catch (Exception e){
            logger.error("Hatalı başlık.");
        }

    }


}
