package com.testShop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class Elements {

	private static final Logger logger = LoggerFactory.getLogger(Elements.class);

	private static boolean bStatus;

	public static boolean doClick(WebDriver driver, By locator) {
		bStatus = Wait.waitForElementToBeClickable(driver, locator, Constants.maxWaitTime);
		if (bStatus) {
			driver.findElement(locator).click();
			return true;
		} else {
			System.out.println("Locator " + locator + " was not available for click");
			return false;
		}

	}
	
	public static boolean doClickOnWebElement(WebDriver driver, WebElement element) {
	    boolean bStatus = false;
	    try {
	        // Wait for the element to be clickable
	        bStatus = Wait.waitForWebElementToBeClickable(driver, element, Constants.maxWaitTime);
	        
	        if (bStatus) {
	            element.click(); // Click the WebElement directly
	            return true;
	        } else {
	            System.out.println("Element was not clickable within the timeout");
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println("An exception occurred while clicking the element: " + e.getMessage());
	        return false;
	    }
	}

	
	

	public static boolean jsDoClick(WebDriver driver, By locator) {
		bStatus = Wait.waitForElementToBeClickable(driver, locator, Constants.maxWaitTime);
		if (bStatus) {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", getWebElement(driver, locator));
			return true;
		} else {
			System.err.println("Locator " + locator + " was not available for click");
			return false;
		}
	}

	public static boolean doSendKeys(WebDriver driver, By locator, String inputText) {
		bStatus = Wait.waitForElementVisible(driver, locator, Constants.maxWaitTime);
		if (bStatus) {
			driver.findElement(locator).sendKeys(inputText);

			return true;
		} else {
			System.err.println("Text field " + locator + " was not present.");
			return false;
		}
	}

	public static boolean jsSendKeys(WebDriver driver, By locator, String inputText) {
		bStatus = Wait.waitForElementVisible(driver, locator, Constants.minWaitTime);
		if (bStatus) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value = arguments[1];", getWebElement(driver, locator), inputText);
			return true;

		} else {
			System.err.println("Text field " + locator + " was not present.");
			return false;
		}

	}

	public static WebElement getWebElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		return element;

	}

	public static boolean turnOnToggle(WebDriver driver, By locator) {
		Wait.waitForElementPresence(driver, locator, Constants.maxWaitTime);
		bStatus = driver.findElement(locator).isEnabled();
		if (!bStatus) {
			doClick(driver, locator);
			return true;
		} else {
			return false;
		}

	}

	public static boolean turnOffToggle(WebDriver driver, By locator) {
		Wait.waitForElementPresence(driver, locator, Constants.maxWaitTime);
		bStatus = driver.findElement(locator).isEnabled();
		if (bStatus) {
			doClick(driver, locator);
			return true;
		} else {
			return false;
		}

	}

	public static String getText(WebDriver driver, By locator) {
		Wait.waitForElementVisible(driver, locator, Constants.maxWaitTime);
		return driver.findElement(locator).getText();

	}

	public static String getPageTitle(WebDriver driver) {
		if (driver == null) {
			logger.warn(() -> "Driver is null");
			return null;
		}

		try {
			String title = driver.getTitle();
			logger.info(() -> "Page title is "+title);
			return title;
		} catch (Exception e) {
			logger.error(() -> "Getting exception while getting the title of a page "+e.getMessage());
			return null;
		}
	}
}
