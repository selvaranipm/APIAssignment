package com.org.runner;
import org.junit.runner.RunWith;
import org.testng.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/resources/features"},glue= {"stepdefinitions"}
, monochrome = true)
public class FunctionalTestCaseRunner {
	

}

 

 
