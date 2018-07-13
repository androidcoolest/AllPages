package cucumberNew.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)

@CucumberOptions(
	features = {"src/test/java/cucumberNew/featurefiles"},
	glue = "cucumberNew.steps",
	plugin = {"pretty", "html:target/cucumber-html-report"},
	monochrome = true
	)

public class testrunner {
}
