package com.testShop.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/testShop/features", // Path to your feature files
    glue = { "com.testShop.stepDefinitions", "com.testShop.hooks" },              // Package containing step definitions
    		 plugin = {
    			        "pretty",
    			        "html:target/cucumber-reports/cucumber-html-report.html"
    			        
    			    },
    monochrome = true,                         // Makes the console output readable
    dryRun = false,                            // Set to true to check the mapping of steps before actual execution
  //  strict = true,                             // Fails the execution if undefined steps are found
    tags = "@TS-01"                        // Tags to run specific tests, remove if running all tests
)

public class TestRunner{

}
