package com.testShop.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {

	public static byte[] takeScreenshot(WebDriver driver) {
	    if (driver == null) {
	        throw new IllegalArgumentException("Driver instance is null");
	    }

	    try {
	        // Capture screenshot as bytes
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
