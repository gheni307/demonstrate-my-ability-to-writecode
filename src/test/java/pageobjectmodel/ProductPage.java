package pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tool.TestBase;
import tool.TestUtility;

public class ProductPage extends TestBase {

    TestUtility utility;

    @FindBy(linkText = "Add Product")
    WebElement addProductLink;
    @FindBy(xpath = "//img[@rel=\"#product_status\"]")
    WebElement productStatusCheckBox;
    @FindBy(id = "name")
    WebElement productNameField;
    @FindBy(id = "product_code")
    WebElement productCodeField;
    @FindBy(xpath = "//input[@value=\"Save\"]")
    WebElement saveButton;
    @FindBy(xpath = "//div[text()=\"Product successfully created.\"]")
    WebElement createdSuccessFullMessage;
    @FindBy(xpath = "//td[text()=\"3342xc\"]/following::td[6]/a[4]")
    WebElement deleteButton;
    @FindBy(xpath = "//div[text()=\"Product(s) successfully deleted.\"]")
    WebElement deletedSuccessFullMessage;

    public ProductPage(){
        PageFactory.initElements(driver, this);
        utility = new TestUtility();
    }

    public void addProduct(String productName, String productCode){
        utility.waitForElementPresent(addProductLink);
        addProductLink.click();

        utility.waitForElementPresent(productStatusCheckBox);
        productStatusCheckBox.click();

        utility.waitForElementPresent(productNameField);
        productNameField.sendKeys(productName);

        utility.waitForElementPresent(productCodeField);
        productCodeField.sendKeys(productCode);

        utility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyProduct(){
        utility.waitForElementPresent(createdSuccessFullMessage);
        return createdSuccessFullMessage.isDisplayed();
    }

    public void deleteProduct(){
        utility.waitForElementPresent(deleteButton);
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyDeletedProduct(){
        utility.waitForElementPresent(deletedSuccessFullMessage);
        return deletedSuccessFullMessage.isDisplayed();
    }


}
