package cucumberframework.customermodulesteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.CustomerPage;
import pageobjectmodel.DashboardPage;
import pageobjectmodel.LoginPage;
import tool.TestBase;

public class ReviewsCustomerListSteps extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    @Given("Admin user should logged into the Dashboard page")
    public void adminUserShouldLoggedIntoTheDashboardPage() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        customerPage = new CustomerPage();
        loginPage.loginUser(prop.getProperty("username"), prop.getProperty("password"));
    }

    @When("click on Customer List link to the Customer List page")
    public void clickOnCustomerListLinkToTheCustomerListPage() {
        dashboardPage.clickOnCustomerLink();
    }

    @Then("verify count of total customers")
    public void verifyCountOfTotalCustomers() {
        customerPage.verifyTotalCountOfCustomerList();
    }
}
