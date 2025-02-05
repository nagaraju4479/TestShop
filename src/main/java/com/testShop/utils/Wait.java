package com.testShop.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait {

	
	
	 public static boolean waitForElementVisible(WebDriver driver, By locator, Duration timeOut) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, timeOut);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            return Verify.verifyElementVisible(driver, locator);
	        } catch (TimeoutException e) {
	            System.err.println("Locator " + locator + " is not found within the timeout period.");
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	        return false;
	    }
	 
	
	 
	 public static boolean waitForElementPresence(WebDriver driver,By locator, Duration timeout)
	 {
		 try {
			 WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return Verify.verifyElementVisible(driver, locator);			 
			
		} catch (TimeoutException e) {
			System.err.println("Element "+locator+" is not present");
		}
		 return false;
	 }

	    // Wait for a button to be 
	    public static boolean waitForElementToBeClickable(WebDriver driver, By locator, Duration timeOut) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, timeOut);
	            wait.until(ExpectedConditions.elementToBeClickable(locator));
	            return Verify.verifyElementVisible(driver, locator);
	        } catch (TimeoutException e) {
	            System.err.println("Button " + locator + " is not clickable within the timeout period.");
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	        return false;
	    }
	    
	    public static boolean waitForWebElementToBeClickable(WebDriver driver, WebElement element, Duration maxwaittime) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            return true;
	        } catch (Exception e) {
	            System.out.println("Exception while waiting for element to be clickable: " + e.getMessage());
	            return false;
	        }
	    }

	 

	    // Wait for an alert to be present
	    public static boolean waitForAlertPresence(WebDriver driver,By locator, Duration waitTime) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver,Constants.maxWaitTime);
	            wait.until(ExpectedConditions.alertIsPresent());
	            return Verify.verifyElementVisible(driver, locator);
	        } catch (TimeoutException e) {
	            System.err.println("Alert is not found within the timeout period.");
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	        return false;
	    }

	    // Wait for a calendar to be present and visible
	    public static boolean waitForCalendarPresence(WebDriver driver, By locator, Duration timeOut) {
	       try {
	    	  new WebDriverWait(driver, timeOut).until(ExpectedConditions.numberOfElementsToBe(locator, 2));
	    	  
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	       return false;
	    }

}