package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPgae;

public class Steps {

	WebDriver driver;
	HomePage homePage;
	LoginPgae loginPage;
	DashboardPage dashboardPage;

	@Given("user is on the Home Page")
	public void user_is_on_the_home_page() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://primetech-store-qa.herokuapp.com/");

		// We will create Object Of Home Page Class
		homePage = new HomePage(driver);

		// We will call the verify page logo methods
		homePage.verifyLogo();

		// We will call verify page url method
		homePage.verifyURL("https://primetech-store-qa.herokuapp.com/");

		// We will call verify page title method
		homePage.verifyTitle();

	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		homePage.clickWelcomeLink();
		homePage.clickLoginButton();
	}

	@Then("user verify Login Page URL")
	public void user_verify_login_page_url() {
		loginPage = new LoginPgae(driver);
	}

	@Then("user verify Login Page Logo")
	public void user_verify_login_page_logo() {
		loginPage.verifyPageHeader();

	}

	@Then("user login with valid credentials")
	public void user_login_with_valid_credentials() {
		loginPage.enterEmail("pt_test@gmail.com");
		loginPage.enterPassword("Test@1234");
		loginPage.clickLoginButton();

	}

	@When("user dashboard page is displayed")
	public void user_dashboard_page_is_displayed() throws InterruptedException {
		dashboardPage = new DashboardPage(driver);
		dashboardPage.verifyURL("https://primetech-store-qa.herokuapp.com/dashboard");
	}

	@Then("user verify Email")
	public void user_verify_email() {
		dashboardPage.verifyEmail("pt_test@gmail.com");
	}

	@Then("user verify Account Type")
	public void user_verify_account_type() {
		dashboardPage.verifyAccountType("Member");
	}

	@Then("user verify First Name")
	public void user_verify_first_name() {
		dashboardPage.verifyFirstName("PT");
	}

	@Then("user verify Last Name")
	public void user_verify_last_name() {
		dashboardPage.verifyLastName("Test");
	}

	@When("user click logout button")
	public void user_click_logout_button() {
		dashboardPage.clickAccountDropdown("PT");
		dashboardPage.clickSignoutButton();

	}

	@Then("user closed the browser")
	public void user_closed_the_browser() {
		driver.quit();
	}

}
