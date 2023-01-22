package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;

public class CommonSteps {
	
	
	TestContext testContext;
	WebDriver driver;
	BasePage basePage;
	
	public CommonSteps(TestContext context) {
		this.testContext  = context;
		basePage = testContext.getPageObjectManager().getBasePage();
		driver = testContext.getBrowserManager().getDriver();
		
	}
	
	
	
	@When("user click on login button")
	public void user_click_on_login_button() {
		basePage.clickWelcomeLink();
		basePage.clickLoginButton();
	}
	
	@When("user click logout button for account {string}")
	public void user_click_logout_button(String firstName) {
		basePage.clickAccountDropdown(firstName);
		basePage.clickSignoutButton();

	}

}
