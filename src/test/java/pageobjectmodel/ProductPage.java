package pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tool.TestBase;

public class ProductPage {

    WebDriver driver;
    TestBase testBase;

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

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testBase = new TestBase(driver);
    }

    public void addProduct(String productName, String productCode){
        testBase.waitForElementPresent(addProductLink,10);
        addProductLink.click();

        testBase.waitForElementPresent(productStatusCheckBox, 10);
        productStatusCheckBox.click();

        testBase.waitForElementPresent(productNameField, 10);
        productNameField.sendKeys(productName);

        testBase.waitForElementPresent(productCodeField,10);
        productCodeField.sendKeys(productCode);

        testBase.waitForElementPresent(saveButton, 10);
        saveButton.click();
    }

    public boolean verifyProduct(){
        testBase.waitForElementPresent(createdSuccessFullMessage,10);
        return createdSuccessFullMessage.isDisplayed();
    }

    public void deleteProduct(){
        testBase.waitForElementPresent(deleteButton,10);
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyDeletedProduct(){
        testBase.waitForElementPresent(deletedSuccessFullMessage,10);
        return deletedSuccessFullMessage.isDisplayed();
    }


}
