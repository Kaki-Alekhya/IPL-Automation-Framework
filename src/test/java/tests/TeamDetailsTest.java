package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamsPage;
import utils.DriverFactory;

import java.util.List;

public class TeamDetailsTest extends BaseTest {

    @Test
    public void verifyTeamDetails(){

        HomePage home = new HomePage(DriverFactory.getDriver());
        home.clickTeams();

        TeamsPage teamsPage = new TeamsPage(DriverFactory.getDriver());

        List<WebElement> teams = teamsPage.getTeams();

        for(WebElement team : teams){

            Assert.assertTrue(team.isDisplayed(), "Team logo not visible");

            Actions actions = new Actions(DriverFactory.getDriver());
            actions.moveToElement(team).perform();
        }
    }
}