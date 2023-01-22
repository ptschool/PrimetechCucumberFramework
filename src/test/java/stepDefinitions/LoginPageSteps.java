package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import managers.FileReaderManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageSteps {
	
	TestContext testContext;
	LoginPage loginPage;
	
	public LoginPageSteps(TestContext context) {
		this.testContext  = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
		
	}
	
	
	
	@Then("user verify Login Page URL")
	public void user_verify_login_page_url() throws InterruptedException {
		loginPage.verifyURL(FileReaderManager.getInstance().getConfigReader().getURL() +   "login");
	}

	@Then("user verify Login Page Logo")
	public void user_verify_login_page_logo() {
		loginPage.verifyPageHeader();
		
	}
	

	@Then("user login with {string} and {string}")
	public void user_login_with_and(String email, String password) {
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	}

	
	
}
