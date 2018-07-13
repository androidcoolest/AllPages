package com.myproject.c;
import org.junit.runner.RunWith; 
import cucumber.junit.Cucumber; 

public class RunTest {

	@RunWith(Cucumber.class) 
	@CucumberOptions(
			format = {"pretty", "html:target/cucumber"}
			feature="../src/test/myfeature.feature"
			)
}
