package pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tool.TestBase;
import tool.TestUtility;

public class CustomerPage extends TestBase {

    TestUtility utility;

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

    public CustomerPage(){
        PageFactory.initElements(driver,this);
        utility = new TestUtility();
    }

    public void addCustomers(String addTitle, String addFirstName, String addLastName, String addEmail){
        utility.waitForElementPresent(addCustomerList);
        addCustomerList.click();

        utility.waitForElementPresent(title);
        title.sendKeys(addTitle);

        utility.waitForElementPresent(firstName);
        firstName.sendKeys(addFirstName);

        utility.waitForElementPresent(lastName);
        lastName.sendKeys(addLastName);

        utility.waitForElementPresent(email);
        email.sendKeys(addEmail);

        utility.waitForElementPresent(submit);
        submit.click();
    }

    public void deleteCustomer(){
        utility.waitForElementPresent(deleteButton);
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyAddNemCustomer(){
        utility.waitForElementPresent(successFullMessage);
        return successFullMessage.isDisplayed();
    }

    public boolean verifyDeletedCustomer(){
        utility.waitForElementPresent(deleteSuccessFullMassage);
        return deleteSuccessFullMassage.isDisplayed();
    }

}
