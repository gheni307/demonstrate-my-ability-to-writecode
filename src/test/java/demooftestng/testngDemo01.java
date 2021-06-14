package demooftestng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tool.TestBase;
import pageobjectmodel.*;

public class testngDemo01 extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;

    @BeforeClass
    public void setup(){
        initialization("url");
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        productPage = new ProductPage();
        loginPage.loginUser("********", "*******");
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

        return new Object[][]{
                {"netforman","123qwe"},
                {"netforman1","234wer"},
                {"netforman2","345ert"}
        };
    }

}
