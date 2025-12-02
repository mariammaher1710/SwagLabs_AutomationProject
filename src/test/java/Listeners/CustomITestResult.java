package Listeners;

import Utilities.LogUtilities;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;

public class CustomITestResult implements ITestListener {

    public void onTestStart(ITestResult result) {
        LogUtilities.info("test case" + result.getName() + "started");
    }

    public void onTestSuccess(ITestResult result) {
        LogUtilities.info("test case" + result.getName() + "success");
    }
    public void onTestSkipped(ITestResult result) {
        LogUtilities.info("test case" + result.getName() +" skipped");
    }
    @Override
    public void onTestFailure(ITestResult result) {

        // Log failure details
        LogUtilities.error("❌ TEST FAILED: " + result.getName());
        LogUtilities.error("Reason: " + result.getThrowable());

    }


}
