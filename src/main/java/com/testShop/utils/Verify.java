package com.testShop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verify {

	// Element visibility

	public static boolean verifyElementVisible(WebDriver driver, By locator) {

		try {
			WebElement element = driver.findElement(locator);
			return element.isDisplayed();

		} catch (NoSuchElementException e) {
			System.err.println("Locator " + locator + " is not visible");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;

	}

	public static boolean verifyElementIsSelected(WebDriver driver, By locator) {
		try {

			return driver.findElement(locator).isSelected();
		} catch (NoSuchElementException e) {

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return false;
	}

	public static boolean verifyElementIsEnabled(WebDriver driver, By locator) {

		try {
			return driver.findElement(locator).isEnabled();
		} catch (NoSuchElementException e) {

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}

// Toggle button enable or disabled
