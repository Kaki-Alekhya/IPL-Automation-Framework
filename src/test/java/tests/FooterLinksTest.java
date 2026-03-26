package tests;

import base.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverFactory;

import java.util.List;

public class FooterLinksTest extends BaseTest {

    @Test
    public void verifyFooterLinks(){

        WebDriver driver = DriverFactory.getDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Assert.assertTrue(links.size() > 0, "Footer links not found");
    }
}