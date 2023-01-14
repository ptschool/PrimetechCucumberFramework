package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

	private WebDriver driver;

	@FindBy(xpath = "//*[@class='account-details']//*[@class='desc']//p")
	private WebElement txt_email;

	@FindBy(xpath = "//*[@class='account-details']//*[@class='desc']//*[contains(@class,'role')]")
	private WebElement txt_accountType;

	@FindBy(name = "firstName")
	private WebElement input_firstName;
	
	@FindBy(name = "lastName")
	private WebElement input_lastName;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLastName(String lastName) {
		// Verify FirstName
		String actualLastName = input_lastName.getAttribute("value");
		if (!actualLastName.equals(lastName)) {
			throw new RuntimeException("Invalid Last Name: " + actualLastName);
		}
	}
	

	public void verifyFirstName(String firstName) {
		// Verify FirstName
		String actualFirstName = input_firstName.getAttribute("value");
		if (!actualFirstName.equals(firstName)) {
			throw new RuntimeException("Invalid First Name: " + actualFirstName);
		}
	}

	public void verifyAccountType(String accountType) {
		// Verify User Account Type
		String actualAccountType = txt_accountType.getText().trim();
		if (!actualAccountType.equals(accountType)) {
			throw new RuntimeException("Invalid Account Type: " + actualAccountType);
		}
	}

	public void verifyEmail(String expectedEmail) {

		String actualEmail = txt_email.getText().trim();
		if (!actualEmail.equals(expectedEmail)) {
			throw new RuntimeException("Invalid Email Address: " + actualEmail);
		}
	}
}
