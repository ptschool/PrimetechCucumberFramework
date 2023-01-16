package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class PageObjectManager {
	
	private WebDriver driver;
	
	private DashboardPage dashboardPage;
	private HomePage homePage;
	private LoginPage loginPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver  = driver;
	}
	
	public DashboardPage getDashboardPage() {
		if(dashboardPage==null) {
			dashboardPage = new DashboardPage(driver);
		}
		return dashboardPage;
	}
	
	public HomePage getHomePage() {
		if(homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
		
	}
	
	public LoginPage getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		
		return loginPage;
	}

}
