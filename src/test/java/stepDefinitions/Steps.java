package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.BrowserManager;
import managers.FileReaderManager;
import managers.PageObjectManager;

public class Steps {

	WebDriver driver;
	private PageObjectManager pageObjectManager;
	BrowserManager browserManager;
	
	@Given("user is on the Home Page")
	public void user_is_on_the_home_page() throws InterruptedException, FileNotFoundException, IOException {
	
		browserManager = new BrowserManager();
		 driver = browserManager.getDriver();
		
		driver.get(FileReaderManager.getInstance().getConfigReader().getURL());

		// Initialize Page Object Manager class object
		pageObjectManager = new PageObjectManager(driver);
		
		// We will call verify page url method
		pageObjectManager.getHomePage().verifyURL(FileReaderManager.getInstance().getConfigReader().getURL());

		// We will call verify page title method
		pageObjectManager.getHomePage().verifyTitle();
		
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		pageObjectManager.getHomePage().clickWelcomeLink();
		pageObjectManager.getHomePage().clickLoginButton();
	}

	@Then("user verify Login Page URL")
	public void user_verify_login_page_url() throws InterruptedException {
		pageObjectManager.getLoginPage().verifyURL(FileReaderManager.getInstance().getConfigReader().getURL() +   "login");
	}

	@Then("user verify Login Page Logo")
	public void user_verify_login_page_logo() {
		pageObjectManager.getLoginPage().verifyPageHeader();
		
	}
	

	@Then("user login with {string} and {string}")
	public void user_login_with_and(String email, String password) {
		pageObjectManager.getLoginPage().enterEmail(email);
		pageObjectManager.getLoginPage().enterPassword(password);
		pageObjectManager.getLoginPage().clickLoginButton();
	}


	@When("user dashboard page is displayed")
	public void user_dashboard_page_is_displayed() throws InterruptedException {
		pageObjectManager.getDashboardPage().verifyURL(FileReaderManager.getInstance().getConfigReader().getURL() +  "dashboard");
	}

	@Then("user verify Email is {string}")
	public void user_verify_email(String email) {
		pageObjectManager.getDashboardPage().verifyEmail(email);
	}

	@Then("user verify Account Type is {string}")
	public void user_verify_account_type(String accountType) {
		pageObjectManager.getDashboardPage().verifyAccountType(accountType);
	}

	@Then("user verify First Name is {string}")
	public void user_verify_first_name(String firstName) {
		pageObjectManager.getDashboardPage().verifyFirstName(firstName);
	}

	@Then("user verify Last Name is {string}")
	public void user_verify_last_name(String lastName) {
		pageObjectManager.getDashboardPage().verifyLastName(lastName);
	}

	@When("user click logout button for account {string}")
	public void user_click_logout_button(String firstName) {
		pageObjectManager.getDashboardPage().clickAccountDropdown(firstName);
		pageObjectManager.getDashboardPage().clickSignoutButton();

	}

	@Then("user closed the browser")
	public void user_closed_the_browser() {
		driver.quit();
	}

}
