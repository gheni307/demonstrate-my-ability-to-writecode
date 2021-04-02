package pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tool.TestBase;

public class CustomerPage {
    WebDriver driver;
    TestBase testBase;

    @FindBy(xpath = "//a[text()=\"Add Customer\"]")
    WebElement addCustomerList;
    @FindBy(css = "#cust-title")
    WebElement title;
    @FindBy(css = "#cust-firstname")
    WebElement firstName;
    @FindBy(css = "#cust-lastname")
    WebElement lastName;
    @FindBy(css = "#cust-email")
    WebElement email;
    @FindBy(css = "input[name=\"save\"]")
    WebElement submit;
    @FindBy(css = "div[class=\"success\"]")
    WebElement successFullMessage;
    @FindBy(xpath = "//a[text()=\"Mamut, Gheni\"]/following::td[4]/a[3]")
    WebElement deleteButton;
    @FindBy(xpath = "//div[text()=\"Customer successfully deleted.\"]")
    WebElement deleteSuccessFullMassage;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testBase = new TestBase(driver);
    }

    public void addCustomers(String addTitle, String addFirstName, String addLastName, String addEmail){
        testBase.waitForElementPresent(addCustomerList,10);
        addCustomerList.click();

        testBase.waitForElementPresent(title,10);
        title.sendKeys(addTitle);

        testBase.waitForElementPresent(firstName,10);
        firstName.sendKeys(addFirstName);

        testBase.waitForElementPresent(lastName,10);
        lastName.sendKeys(addLastName);

        testBase.waitForElementPresent(email,10);
        email.sendKeys(addEmail);

        testBase.waitForElementPresent(submit,10);
        submit.click();
    }

    public void deleteCustomer(){
        testBase.waitForElementPresent(deleteButton,10);
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyAddNemCustomer(){
        testBase.waitForElementPresent(successFullMessage,10);
        return successFullMessage.isDisplayed();
    }

    public boolean verifyDeletedCustomer(){
        testBase.waitForElementPresent(deleteSuccessFullMassage,10);
        return deleteSuccessFullMassage.isDisplayed();
    }

}
