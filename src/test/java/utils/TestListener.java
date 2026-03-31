package utils;

import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = BaseTest.getDriver();
        String testName = result.getName();

        try {

            // ✅ Footer test
            if (testName.contains("Footer")) {

                WebElement footer = driver.findElement(By.tagName("footer"));
                ScreenshotUtils.captureElementScreenshot(driver, footer, testName);
            }

            // ✅ Teams test
            else if (testName.contains("Team")) {

                try {
                    WebElement team = driver.findElement(
                            By.xpath("//a[contains(@href,'/teams/')]")
                    );
                    ScreenshotUtils.captureElementScreenshot(driver, team, testName);
                } catch (Exception e) {
                    ScreenshotUtils.capture(driver, testName);
                }
            }

            // ✅ Default
            else {
                ScreenshotUtils.capture(driver, testName);
            }

        } catch (Exception e) {
            ScreenshotUtils.capture(driver, testName);
        }
    }
}