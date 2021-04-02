package demoofjunit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobjectmodel.CustomerPage;
import pageobjectmodel.DashboardPage;
import pageobjectmodel.LoginPage;
import pageobjectmodel.TestDataHolder;
import tool.TestBase;

public class JUnitDemo extends TestBase {

    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    static CustomerPage customerPage;
    static TestDataHolder dataHolder;
    @BeforeClass
    public static void setup(){
        initialization();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        customerPage = new CustomerPage(driver);
        dataHolder = new TestDataHolder();
        loginPage.loginUser("testautomation","automation123!");
    }

    @Test()
    public void addCustomer(){
        dashboardPage.clickOnCustomerLink();
        String addEmail = "demo" + System.currentTimeMillis() + "@gmail.com";
        dataHolder.setEmail(addEmail);
        customerPage.addCustomers("Demo", "Gheni", "Mamut", addEmail);
        customerPage.verifyAddNemCustomer();

    }

    @Test
    public void deleteCustomer(){
        dashboardPage.clickOnCustomerLink();
        customerPage.deleteCustomer();
        customerPage.verifyDeletedCustomer();
    }

    @AfterClass
    public static void teardown(){
        closeBrowser();
    }
}