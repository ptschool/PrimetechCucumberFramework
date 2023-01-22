package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.DashboardPage;

public class DashboardPageSteps {
	TestContext testContext;
	DashboardPage dashboardPage;
	
	public DashboardPageSteps(TestContext context) {
		this.testContext  = context;
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		
		
	}
	
	
	@When("user dashboard page is displayed")
	public void user_dashboard_page_is_displayed() throws InterruptedException {
		dashboardPage.verifyURL(FileReaderManager.getInstance().getConfigReader().getURL() +  "dashboard");
	}

	@Then("user verify Email is {string}")
	public void user_verify_email(String email) {
		dashboardPage.verifyEmail(email);
	}

	@Then("user verify Account Type is {string}")
	public void user_verify_account_type(String accountType) {
		dashboardPage.verifyAccountType(accountType);
	}

	@Then("user verify First Name is {string}")
	public void user_verify_first_name(String firstName) {
		dashboardPage.verifyFirstName(firstName);
	}

	@Then("user verify Last Name is {string}")
	public void user_verify_last_name(String lastName) {
		dashboardPage.verifyLastName(lastName);
	}

}
