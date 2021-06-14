package demoofdatabase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjectmodel.*;
import tool.ConnectionType;
import tool.TestBase;
import java.sql.Connection;

public class DatabaseUiTest extends TestBase {

    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    CustomerPage customerPage;
    DataAccess dataAccess;
    Connection connection = null;
    TestDataHolder dataHolder = null;
    static String dbUrl = "148.72.106.125";
    static String port = "3306";
    static String username = "**********";
    static String password = "**********";
    static String defaultSchema = "i4296639_cc1";

    @BeforeClass
    public void setUp(){
        connection = ConnectionManager.connectToDatabaseServer(dbUrl,port,username,
                password,defaultSchema, ConnectionType.MYSQLSERVER);
        initialization("url");
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        dataAccess = new DataAccess();
        loginPage.loginUser(username,password);
    }

    @Test(description = "Admin should be added 3 customers")
    public void addCustomer(){
        dashboardPage.clickOnCustomerLink();
        customerPage = new CustomerPage();
        dataHolder = new TestDataHolder();

        for (int i = 1; i <= 3; i++){
            String addTitle = "HP" + System.currentTimeMillis();
            dataHolder.setTitle(addTitle);
            String addEmail = "a" + System.currentTimeMillis() + "@gmail.com";
            dataHolder.setEmail(addEmail);
            customerPage.addCustomers(addTitle,"Gheni", "Mamut", addEmail);
            Assert.assertTrue(customerPage.verifyAddNemCustomer());
            dataAccess.getCustomer(addEmail,connection);

        }
    }

    @AfterClass
    public void tearDown(){
        dashboardPage.logout();
        driver.close();
        driver.quit();
        ConnectionManager.closeDatabaseConnection(connection);
    }
}
