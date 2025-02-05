package com.testShop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtil {
	private static boolean bStatus;
	
	public static boolean selectDropdownValuByVisibleText(WebDriver driver, By locator, String sText) {
		bStatus = Wait.waitForElementVisible(driver, locator, Constants.maxWaitTime);
		if (bStatus) {

			Select select = new Select(Elements.getWebElement(driver, locator));
			select.selectByVisibleText(sText);
			return true;
		} else {
			System.err.println("Dropdown " + locator + " was not present.");
			return false;
		}
	}

	public static boolean selectDropdownValueByIndex(WebDriver driver, By locator, int indexValue) {
		bStatus = Wait.waitForElementVisible(driver, locator, Constants.maxWaitTime);
		if (bStatus) {

			Select select = new Select(Elements.getWebElement(driver, locator));
			select.selectByIndex(indexValue);
			return true;

		} else {
			System.err.println("Dropdown " + locator + " was not present.");
			return false;
		}

	}

	public static boolean selectDropdownValueByValue(WebDriver driver, By locator, String inputValue) {

		bStatus = Wait.waitForElementVisible(driver, locator, Constants.maxWaitTime);
		if (bStatus) {
			Select select = new Select(Elements.getWebElement(driver, locator));
			select.selectByValue(inputValue);
			return true;
		} else {
			System.err.println("Dropdown " + locator + " was not present.");
			return false;
		}

	}

}
