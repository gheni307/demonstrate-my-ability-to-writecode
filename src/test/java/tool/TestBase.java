package tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public static WebDriver driver;
    public static String browserName = "chrome";

    public TestBase() {
    }

    public TestBase(WebDriver driver) {
        this.driver = driver;
    }

    public static void initialization(){
        if (driver == null){
            if (browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","src/test/java/tool/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("http://cubecart.unitedcoderschool.com/ecommerce/admin_w4vqap.php");

            } else  if (browserName.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver","src/test/java/tool/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
    }

    public void waitForElementPresent(WebElement element, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
