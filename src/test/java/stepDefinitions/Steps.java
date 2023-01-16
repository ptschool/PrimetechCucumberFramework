package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.PageObjectManager;

public class Steps {

	WebDriver driver;
	private PageObjectManager pageObjectManager;
	@Given("user is on the Home Page")
	public void user_is_on_the_home_page() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://primetech-store-qa.herokuapp.com/");

		// Initialize Page Object Manager class object
		pageObjectManager = new PageObjectManager(driver);
		

		// We will call verify page url method
		pageObjectManager.getHomePage().verifyURL("https://primetech-store-qa.herokuapp.com/");

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
		pageObjectManager.getLoginPage().verifyURL("https://primetech-store-qa.herokuapp.com/login");
	}

	@Then("user verify Login Page Logo")
	public void user_verify_login_page_logo() {
		pageObjectManager.getLoginPage().verifyPageHeader();

	}

	@Then("user login with valid credentials")
	public void user_login_with_valid_credentials() {
		pageObjectManager.getLoginPage().enterEmail("pt_test@gmail.com");
		pageObjectManager.getLoginPage().enterPassword("Test@1234");
		pageObjectManager.getLoginPage().clickLoginButton();

	}

	@When("user dashboard page is displayed")
	public void user_dashboard_page_is_displayed() throws InterruptedException {
		pageObjectManager.getDashboardPage().verifyURL("https://primetech-store-qa.herokuapp.com/dashboard");
	}

	@Then("user verify Email")
	public void user_verify_email() {
		pageObjectManager.getDashboardPage().verifyEmail("pt_test@gmail.com");
	}

	@Then("user verify Account Type")
	public void user_verify_account_type() {
		pageObjectManager.getDashboardPage().verifyAccountType("Member");
	}

	@Then("user verify First Name")
	public void user_verify_first_name() {
		pageObjectManager.getDashboardPage().verifyFirstName("PT");
	}

	@Then("user verify Last Name")
	public void user_verify_last_name() {
		pageObjectManager.getDashboardPage().verifyLastName("Test");
	}

	@When("user click logout button")
	public void user_click_logout_button() {
		pageObjectManager.getDashboardPage().clickAccountDropdown("PT");
		pageObjectManager.getDashboardPage().clickSignoutButton();

	}

	@Then("user closed the browser")
	public void user_closed_the_browser() {
		driver.quit();
	}

}
