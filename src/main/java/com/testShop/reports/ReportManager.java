package com.testShop.reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize ExtentReports if it is null
    public static ExtentReports getExtent() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/target/ExtentReport/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(new File(path));
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    // Get the current test instance, throw an error if the test is not created
    public static ExtentTest getTest() {
        if (test == null) {
            throw new IllegalStateException("Test has not been created. Call createTest() first.");
        }
        return test;
    }

    // Create a new test, ensure ExtentReports is initialized first
    public static ExtentTest createTest(String testName) {
        getExtent();  // Ensure that ExtentReports is initialized before creating a test
        test = extent.createTest(testName);
        return test;
    }

    // Flush the ExtentReports
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
