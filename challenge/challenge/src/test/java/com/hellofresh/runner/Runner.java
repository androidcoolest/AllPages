package com.hellofresh.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class Runner {
	@CucumberOptions(
			features = {"src/test/java/com/hellofresh/features"},
			glue = "com.hellofresh.steps",
			plugin = {"pretty", "html:target/simplereport", "json:target/cucumber.json"},
			monochrome = true
			)

		public class runner extends AbstractTestNGCucumberTests {
	
	}
}