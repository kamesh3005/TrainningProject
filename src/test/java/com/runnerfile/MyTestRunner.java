package com.runnerfile;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/resources/Appfeature/AccountPage.feature"},
		glue = {"com.stepdefinition","AppsHooks"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty"}
		
		
		
		
		
		
		
		)







public class MyTestRunner {

}
