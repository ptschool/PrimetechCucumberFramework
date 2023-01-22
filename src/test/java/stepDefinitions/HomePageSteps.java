package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import managers.FileReaderManager;
import pageObjects.HomePage;

public class HomePageSteps {
	
	
	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context) {
		this.testContext  = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		
	}
	
	
	@Given("user is on the Home Page")
	public void user_is_on_the_home_page() throws InterruptedException, FileNotFoundException, IOException {
	
	
		// We will call verify page url method
		homePage.verifyURL(FileReaderManager.getInstance().getConfigReader().getURL());

		// We will call verify page title method
		homePage.verifyTitle();
		
	}

	
}
