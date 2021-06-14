package demoofjunit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobjectmodel.*;
import tool.TestBase;

public class JUnitDemo extends TestBase {

    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    static CustomerPage customerPage;
    static TestDataHolder dataHolder;
    @BeforeClass
    public static void setup(){
        initialization("url");
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        customerPage = new CustomerPage();
        dataHolder = new TestDataHolder();
        loginPage.loginUser("","");
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
