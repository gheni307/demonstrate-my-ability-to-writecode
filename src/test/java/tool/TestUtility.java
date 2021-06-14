package tool;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtility extends TestBase {
    private int timeout = Integer.parseInt(ApplicationConfig.readFromConfigProperties(configFile,"timeout"));

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForElementsPresent(List<WebElement> elementList){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOfAllElements());

    }

    public void waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void taleScreenshot(String fileName){
        DateTime dateTime = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd 'at' HH:mm:ss");

        String timeStamp = dateTime.toString(formatter);
        fileName = fileName+"_"+timeStamp;

        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);
        String folder = ApplicationConfig.readFromConfigProperties("screenShotFolder");
        File imageFile = new File(folder+File.separator+fileName+".png");
        try {
            FileUtils.copyFile(screenShotFile,imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitForAlertPresent(){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void alertAccept(){
        waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
    }

    public String getFromString(String string){
        String regEx = "[^0-9]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);
        return matcher.replaceAll("").trim();
    }

    public String getMM_dd(){
        DateFormat dateFormat = new SimpleDateFormat("MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
