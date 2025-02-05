package com.testShop.utils;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowUtil {

	private static Boolean bStatus;

	public static void switchToChildWindow(WebDriver driver, By locator) {
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window id: " + parentWindow);
		bStatus = Wait.waitForElementVisible(driver, locator, Constants.maxWaitTime);

		if (bStatus) {
			Elements.doClick(driver, locator);
			Set<String> windowHandles = driver.getWindowHandles();

			for (String windowHandle : windowHandles) {

				if (!windowHandle.equals(parentWindow)) {
					driver.switchTo().window(windowHandle);
					System.out.println(windowHandle);
					break;
				}

			}

		}

	}

	public static void closeWindow(WebDriver driver) {
		driver.close();

	}

	public static void getWindowTitle(WebDriver driver) {
		String windowTitle = driver.getTitle();
		System.out.println(windowTitle);

	}
}
