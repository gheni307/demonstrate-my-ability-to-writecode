package tool;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;

public class TestBase {
    public static WebDriver driver;
    public static String configFile="config.properties";
    public static String sysName=System.getProperty("os.name");

    public static void initialization(String urlKey){
        if (driver==null){
            ChromeOptions options=new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            System.out.println(sysName);
            if (sysName.contains("Mac")){
                System.out.println("Running on Mac mode");
                System.setProperty("webdriver.chrome.driver","/Applications/chromedriver");
                driver=new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get(ApplicationConfig.readFromConfigProperties(urlKey));
            }
            else if (sysName.toLowerCase().contains("server")){
                System.out.println("Running on headless mode");
                System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
                driver=new ChromeDriver(options);
                options.addArguments(Arrays.asList("--headless","disable-gpu"));
                options.addArguments("window-size=1920,1080");
                driver.get(ApplicationConfig.readFromConfigProperties(urlKey));
            }
            else if (sysName.contains("Windows")){
                System.out.println("Running on Windows mode");
                System.setProperty("webdriver.chrome.driver","src/test/java/tool/chromedriver.exe");
                driver=new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get(ApplicationConfig.readFromConfigProperties(urlKey));
            }
        }
    }
    public static void closeBrowser(){
        driver.close();
        driver.quit();
        driver=null;
    }
}
