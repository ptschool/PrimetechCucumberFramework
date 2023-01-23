package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
glue = { "stepDefinitions", "hooks" },
plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-reports.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true)

public class RegressionRunner {

}
