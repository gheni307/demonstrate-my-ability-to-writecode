package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tool.TestBase;

public class DashboardPage {

    WebDriver driver;
    TestBase testBase;

    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(linkText = "Products")
    WebElement productsLink;
    @FindBy(linkText = "Categories")
    WebElement categoriesLink;
    @FindBy(css = "i.fa.fa-dign-out")
    WebElement logoutButton;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testBase = new TestBase(driver);
    }

    public boolean verifyLogin(){
        testBase.waitForElementPresent(logoutButton,10);
        return logoutButton.isDisplayed();
    }

    public void clickOnCustomerLink(){
        testBase.waitForElementPresent(customerListLink,10);
        customerListLink.click();
    }

    public void clickOnProductsLink(){
        testBase.waitForElementPresent(productsLink,10);
        productsLink.click();
    }

    public void clickOnCategoryLink(){
        testBase.waitForElementPresent(categoriesLink,10);
        categoriesLink.click();
    }

    public void logout(){
        testBase.waitForElementPresent(logoutButton,10);
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
