package managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.BrowserType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {
	
	private WebDriver driver;
	private static BrowserType browserType;
	private static EnvironmentType environmentType;
	
	
	public BrowserManager() {
		browserType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	
	public WebDriver getDriver() {
		if(driver==null) {
			driver = createDriver();
		}
		return driver;
	}
	
	public void closeDriver() {
		driver.quit();
	}
	
	private WebDriver createDriver() {
		
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			
			break;
		case REMOTE:
			driver = createRemoteDriver();
		}

		return driver;
		
		
	}
	
	
	// Coming in the future
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("Remote WebDriver is not yet implemented");
	}
	
	
	private WebDriver createLocalDriver() {
		switch (browserType) {
		case CHROME:
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			break;
			
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		case IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowMaximize()) {
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait()));
		
		return driver;
	}
	
	
	

}
