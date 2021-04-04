package demooftestng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectmodel.DashboardPage;
import pageobjectmodel.LoginPage;
import pageobjectmodel.ProductPage;
import tool.TestBase;

public class testngDemo01 extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;

    @BeforeClass
    public void setup(){
        initialization();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        productPage = new ProductPage(driver);
        loginPage.loginUser("", "");
    }

    @Test(dataProvider = "productInfo")
    public void addProducts(String productName, String productCode){
        dashboardPage.clickOnProductsLink();
        productPage.addProduct(productName,productCode);
        Assert.assertTrue(productPage.verifyProduct());
    }

    @AfterClass
    public void teardown(){
        closeBrowser();
    }

    @DataProvider
    public Object[][] productInfo(){
        Object[][] productData = new Object[][]{
                {"netforman","123qwe"},
                {"netforman1","234wer"},
                {"netforman2","345ert"}
        };

        return productData;
    }

}
