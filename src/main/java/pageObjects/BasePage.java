package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;

	@FindBy(linkText = "Welcome!")
	private WebElement welcomeLink;

	@FindBy(xpath = "//h1[@class='logo']")
	private WebElement logo_appLogo;

	By by_LoginBtn = By.xpath("//button[text()='Login']");
	By by_SignoutBtn = By.xpath("//button[text()='Sign Out']");

	public BasePage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}

	public void clickAccountDropdown(String firstName) {
		driver.findElement(By.linkText(firstName)).click();
	}

	public void clickSignoutButton() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by_SignoutBtn))
				.click();
	}

	public void clickLoginButton() {
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

	public void verifyLogo() {
		String actualLogText = logo_appLogo.getText().trim();
		String expectedLogoText = "Sporting Goods Shop";
		if (!actualLogText.equals(expectedLogoText)) {
			throw new RuntimeException("Actual Log Text is not matching with expected logo text: " + expectedLogoText);
		}
	}

	public void clickWelcomeLink() {
		welcomeLink.click();
	}

	public void verifyURL(String pageURL) throws InterruptedException {
		// Verify URL
		Thread.sleep(3000);
		String actualURL = driver.getCurrentUrl();
		if (!actualURL.equals(pageURL)) {
			throw new RuntimeException("Actual URL is not matching - Actual:  " + actualURL + " vs Expected: " + pageURL);
		}
	}

}
