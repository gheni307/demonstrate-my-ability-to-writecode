package demoofjunit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobjectmodel.LoginPage;
import tool.TestBase;

public class JUnitDemo extends TestBase {

    static LoginPage loginPage;
    @BeforeClass
    public static void setup(){
        initialization();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void login(){
        loginPage.loginUser("testautomation","automation123!");
    }

    @AfterClass
    public static void teardown(){
        closeBrowser();
    }
}
