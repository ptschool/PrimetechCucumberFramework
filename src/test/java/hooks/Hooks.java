package hooks;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.FileReaderManager;

public class Hooks {
	WebDriver driver;
	TestContext testContext;
	public Hooks(TestContext context) {
		this.testContext = context;
		driver = testContext.getBrowserManager().getDriver();
	}
	
	@Before
	public void before() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getURL());
	}
	
	@After
	public void after() {
		testContext.getBrowserManager().closeDriver();
	}
	

}
