package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tool.TestBase;

public class LoginPage {

    WebDriver driver;
    TestBase testBase;

    @FindBy(id="username")
    WebElement usernameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="login")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testBase = new TestBase(driver);
    }

    public void enterUserName(String userName){
        testBase.waitForElementPresent(usernameField,10);
        usernameField.sendKeys(userName);
    }

    public void enterPassword(String password){
        testBase.waitForElementPresent(passwordField,10);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        testBase.waitForElementPresent(loginButton,10);
        loginButton.click();
    }

    public void login(){
        enterUserName("");
        enterPassword("");
        clickLoginButton();
    }

    public void loginUser(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }
}
