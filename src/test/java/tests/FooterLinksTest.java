package tests;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverFactory;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.List;
@Listeners(utils.TestListener.class)
public class FooterLinksTest extends BaseTest {

    @Test
    public void verifyFooterLinks(){

        WebDriver driver = getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // ✅ Find footer first (from DOM)
        WebElement footer = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.tagName("footer"))
        );

        // ✅ Scroll specifically to footer (this works better than page scroll)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", footer
        );

        try { Thread.sleep(1000); } catch (Exception e) {}

        // ✅ Get footer links
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

        // ✅ Assertion
        Assert.assertTrue(footerLinks.size() > 0, "Footer links not found");
    }
}