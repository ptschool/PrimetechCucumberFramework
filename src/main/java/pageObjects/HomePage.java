package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;

	@FindBy(linkText = "Welcome!")
	WebElement welcomeLink;

	By by_LoginBtn = By.xpath("//button[text()='Login']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLoginButton() {
		// Click Welcome dropdown link
//		driver.findElement(By.linkText("Welcome!")).click();
		welcomeLink.click();

		// Waiting for the Login Button to be clickable within 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginElem = wait.until(ExpectedConditions.elementToBeClickable(by_LoginBtn));
		// Click login Element
		loginElem.click();

	}

	public void verifyTitle() {
		// Verify Page Title
		String actualTitle = driver.getTitle();
		String expectedTitle = "Prime Tech Store";
		if (!actualTitle.equals(expectedTitle)) {
			throw new RuntimeException("Title of the page does not match as expected: " + expectedTitle);
		}
	}

	public void verifyURL() {
		// Verify URL
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://primetech-store-qa.herokuapp.com/";
		if (!actualURL.equals(expectedURL)) {
			throw new RuntimeException("Actual URL is not matching with expected url: " + expectedURL);
		}
	}

	public void verifyLogo() {
		// Verify Logo
		WebElement logoElem = driver.findElement(By.xpath("//h1[@class='logo']"));
		String actualLogText = logoElem.getText();
		String expectedLogoText = "Sporting Goods Shop";
		if (!actualLogText.equals(expectedLogoText)) {
			throw new RuntimeException("Actual Log Text is not matching with expected logo text: " + expectedLogoText);
		}
	}

}
