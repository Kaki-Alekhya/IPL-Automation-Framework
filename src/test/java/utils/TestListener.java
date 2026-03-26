package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = BaseTest.getDriver();
        String testName = result.getName();

        try {
            // ✅ If it's Footer test → capture footer only
            if(testName.contains("Footer")) {

                WebElement footer = driver.findElement(By.tagName("footer"));

                ScreenshotUtils.captureElementScreenshot(driver, footer, testName);

            } else {
                // other tests → full screenshot
                ScreenshotUtils.capture(driver, testName);
            }

        } catch (Exception e) {
            ScreenshotUtils.capture(driver, testName);
        }
    }
}