package demooftestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tool.TestBase;
import pageobjectmodel.*;

public class TestngDemo extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    TestDataHolder testDataHolder;

    @BeforeClass
    public void setup(){
        initialization("url");
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        productPage = new ProductPage();
        testDataHolder = new TestDataHolder();
        loginPage.loginUser("********", "*********");

    }

    @Test(description = "Admin user should be able to add product", groups = {"regression test"})
    public void addProduct(){
        dashboardPage.clickOnProductsLink();
        String addProductName = "Netforman" + System.currentTimeMillis();
        testDataHolder.setProductName(addProductName);
        String addProductCode = "3342xc";
        testDataHolder.setProductCode(addProductCode);
        productPage.addProduct(addProductName,addProductCode);
        productPage.verifyProduct();

    }

    @Test(dependsOnMethods = "addProduct", description = "Admin user should be able to delete product", groups = {"regression test"})
    public void deleteProduct(){
        dashboardPage.clickOnProductsLink();
        productPage.deleteProduct();
        productPage.verifyDeletedProduct();
    }

    @AfterClass
    public void teardown(){
        closeBrowser();
    }
}
