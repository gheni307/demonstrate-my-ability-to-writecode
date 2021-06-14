package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tool.TestBase;
import tool.TestUtility;

public class DashboardPage extends TestBase {

    TestUtility utility;

    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(linkText = "Products")
    WebElement productsLink;
    @FindBy(linkText = "Categories")
    WebElement categoriesLink;
    @FindBy(css = "i.fa.fa-sign-out")
    WebElement logoutButton;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
        utility = new TestUtility();
    }

    public boolean verifyLogin(){
        utility.waitForElementPresent(logoutButton);
        return logoutButton.isDisplayed();
    }

    public void clickOnCustomerLink(){
        utility.waitForElementPresent(customerListLink);
        customerListLink.click();
    }

    public void clickOnProductsLink(){
        utility.waitForElementPresent(productsLink);
        productsLink.click();
    }

    public void clickOnCategoryLink(){
        utility.waitForElementPresent(categoriesLink);
        categoriesLink.click();
    }

    public void logout(){
        utility.waitForElementPresent(logoutButton);
        logoutButton.click();
    }

    public boolean verifyDashboardPage(){
        if (productsLink.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }



}
