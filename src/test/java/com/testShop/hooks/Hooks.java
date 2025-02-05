package com.testShop.hooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.testShop.driverManager.DriverManager;
import com.testShop.reports.ReportManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static WebDriver driver;

	@Before
	public void setup() throws IOException {
		if(driver == null) {
			
			driver = DriverManager.initDriver();
			
		}
		
			

	}

	@After
	public void tearDown() {
		DriverManager.quitDriver();
		
	}

	public static WebDriver getDriver() {
		return driver;
	}

	

}
