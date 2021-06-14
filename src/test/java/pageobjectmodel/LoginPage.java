package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tool.TestBase;
import tool.TestUtility;

public class LoginPage extends TestBase {

    TestUtility utility;

    @FindBy(id="username")
    WebElement usernameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="login")
    WebElement loginButton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
        utility = new TestUtility();
    }

    public void enterUserName(String userName){
        utility.waitForElementPresent(usernameField);
        usernameField.sendKeys(userName);
    }

    public void enterPassword(String password){
        utility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        utility.waitForElementPresent(loginButton);
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
