package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"StepDefinitions", "hooks"},		//plugin = { "pretty","html:target/cucumber-reports.html", "json:target/cucumber.json" },
		monochrome = true,
		dryRun = false
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
