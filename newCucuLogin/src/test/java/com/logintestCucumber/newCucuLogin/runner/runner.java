package com.logintestCucumber.newCucuLogin.runner;


import com.logintestCucumber.newCucuLogin.steps.Stack;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(
	features = {"src/test/java/com/logintestCucumber/newCucuLogin/featurefiles"},
	glue = "com.logintestCucumber.newCucuLogin.steps",
	plugin = {"pretty", "html:target/simplereport", "json:target/cucumber.json"},
	monochrome = true
	)

public class runner extends AbstractTestNGCucumberTests {
	Stack stackObj = new Stack();
	
	/*@BeforeSuite (alwaysRun = true)
	public void initialize() {
		stackObj.setup();
	}
	
	@AfterSuite (alwaysRun = true)
	public void tearDownAll() {
		stackObj.tearDown();
	}*/
	
}
