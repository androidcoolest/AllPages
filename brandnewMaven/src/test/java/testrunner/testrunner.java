package testrunner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)

@CucumberOptions(
	features = {"src/test/java/features"},
	glue = "steps",
	plugin = {"pretty", "html:target/cucumber-html-report"},
	monochrome = true
	)

public class testrunner {
}
