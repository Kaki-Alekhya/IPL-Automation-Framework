package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import java.util.List;
@Listeners(utils.TestListener.class)
public class FooterLinksTest extends BaseTest {


    @Test
    public void verifyFooterLinksBySection() {
        WebDriver driver = getDriver();
        driver.get("https://www.iplt20.com/");
        HomePage homePage = new HomePage(driver);
        homePage.scrollToFooter();
        String[] sections = {"TEAM", "ABOUT", "GUIDELINES", "CONTACT"};

        for (String section : sections) {
            List<WebElement> links = homePage.getLinksBySection(section);
            System.out.println("Checking Section: " + section + " | Links found: " + links.size());
            Assert.assertTrue(links.size() > 0, "FAILED: No links found under section: " + section);

        }
        System.out.println("✅ All footer sections verified successfully.");
    }
}