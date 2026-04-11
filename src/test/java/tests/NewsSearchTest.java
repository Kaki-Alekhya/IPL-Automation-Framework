package tests;
import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.NewsPage;
import java.util.List;
@Listeners(utils.TestListener.class)
public class NewsSearchTest extends BaseTest {
    @Test
    public void verifyNewsSearch(){
        WebDriver driver = getDriver();

        driver.get("https://www.iplt20.com/news");
        acceptCookies(driver);
        NewsPage newsPage = new NewsPage(driver);
        newsPage.search("Auction 2026");
        List<WebElement> results = newsPage.getResults();
        boolean found = false;
        for (WebElement r : results) {
            String text = (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].textContent;", r);
            text = text.toLowerCase().trim();
            if (text.contains("auction")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, "No auction-related news found");
    }
}