package com.mycompany.cucumberSuccess;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;.
import Cucumber.api.CucumberOptions;
import Cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ""
		,glue={"stepDefinition"}
		)
public class runnertest {

}
