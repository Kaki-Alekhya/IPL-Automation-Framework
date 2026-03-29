package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import pages.NewsPage;

import java.util.List;

@Listeners(utils.TestListener.class)
public class NewsSearchTest extends BaseTest {

    @Test
    public void verifyNewsSearch(){

        NewsPage newsPage = new NewsPage(getDriver());

        newsPage.goToNews();

        newsPage.search("Auction 2026");

        List<WebElement> results = newsPage.getResults();

        boolean found = false;

        for(WebElement r : results){
            if(r.getText().toLowerCase().contains("auction")){
                found = true;
                break;
            }
        }

        Assert.assertTrue(found, "Auction news not found");
    }
}