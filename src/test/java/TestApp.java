import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.xpath;

public class TestApp {
    protected WebDriver driver;
    public static String loginUrl = "https://www.e-bebek.com/login";
    @Before
    public void setUp() throws Exception{
        DesiredCapabilities capabilities=DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver=new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(1000, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }
    @Test
    public void login(){
    driver.get(loginUrl);
    driver.findElement(By.id("txtPhoneNumberMobile")).sendKeys("5380105466");
    driver.findElement(By.id("btnSubmitLogin")).click();
    driver.findElement(By.id("txtPassword")).sendKeys("ZvsXwvzzP.V7kv8");
    driver.findElement(By.id("btnSubmitPassword"));


    }
    @Test
    public void test(){
        driver.get("https://www.e-bebek.com/");
        WebElement txtSearch = driver.findElement(By.id("txtSearchBox"));
        txtSearch.sendKeys("kaşık maması");
        txtSearch.sendKeys(Keys.ENTER);
        List<WebElement> resultTitles =driver.findElements(By.className("product-item"));
    }
    @After
    public void tearDown() throws Exception {
      driver.quit();
    }
}
