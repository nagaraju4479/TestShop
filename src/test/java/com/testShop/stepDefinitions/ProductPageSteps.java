package com.testShop.stepDefinitions;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import com.testShop.hooks.Hooks;
import com.testShop.utils.CommonUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.When;

public class ProductPageSteps{
	
	static Logger logger = LogManager.getLogger(ProductPageSteps.class);

	
	WebDriver driver = Hooks.getDriver();

    @When("I launch the url")
    public void i_launch_the_url() throws IOException {
    	String url = CommonUtils.getProperties().getProperty("url");
    	driver.get(url);
    	logger.info("Url launched successfully");
       
    
    }
    
    @When("I am landing on product page")
    public void IamOnProductPage()
    {
    	System.out.println("I am on product page");
    }
    
    

     
   
   

}
