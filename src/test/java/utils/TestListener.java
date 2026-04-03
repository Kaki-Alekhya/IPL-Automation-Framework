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

        if (driver == null) return;

        try {
            if (testName.contains("Footer")) {
                try {
                    WebElement footer = driver.findElement(By.tagName("footer"));
                    ScreenshotUtils.captureElementScreenshot(driver, footer, testName);
                } catch (Exception e) {
                    ScreenshotUtils.capture(driver, testName);
                }
            }
            else if (testName.contains("Team")) {
                try {
                    WebElement team = driver.findElement(By.xpath("//a[contains(@href,'/teams/')]"));
                    ScreenshotUtils.captureElementScreenshot(driver, team, testName);
                } catch (Exception e) {
                    ScreenshotUtils.capture(driver, testName);
                }
            }
            else if (testName.contains("Points")) {
                try {
                    WebElement table = driver.findElement(By.className("ih-td-tab"));
                    ScreenshotUtils.captureElementScreenshot(driver, table, testName);
                } catch (Exception e) {
                    ScreenshotUtils.capture(driver, testName);
                }
            }
            else if (testName.contains("News")) {
                try {
                    WebElement newsList = driver.findElement(By.className("news-list-wrap"));
                    ScreenshotUtils.captureElementScreenshot(driver, newsList, testName);
                } catch (Exception e) {
                    ScreenshotUtils.capture(driver, testName);
                }
            }
            else {
                ScreenshotUtils.capture(driver, testName);
            }

        } catch (Exception e) {
            ScreenshotUtils.capture(driver, testName);
        }
    }
}