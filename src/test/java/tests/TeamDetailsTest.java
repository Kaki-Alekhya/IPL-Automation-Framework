package tests;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.TeamsPage;
import utils.TeamData;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Listeners(utils.TestListener.class)
public class TeamDetailsTest extends BaseTest {

    @Test
    public void verifyTeamDetails() {
        WebDriver driver = getDriver();
        driver.navigate().to("https://www.iplt20.com/teams");
        acceptCookies(driver);
        TeamsPage teamsPage = new TeamsPage(driver);
        // ✅ Get all teams
        List<WebElement> teams = teamsPage.getAllTeams();
        Map<String, String> expectedData = TeamData.getTeamWinningYears();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement team : teams) {
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", team);
            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(d -> team.isDisplayed());
            // ✅ Logo check (robust)
            Assert.assertTrue(
                    teamsPage.isLogoDisplayed(team),
                    "Logo not displayed"
            );
            // ✅ Get team name
            String teamName;
            try {
                teamName = team.findElement(By.xpath(".//img")).getAttribute("alt");
            } catch (Exception e) {
                teamName = team.getText().trim();
            }
            // ✅ Hover (
            String actualYears = teamsPage.getTeamTitleYears(team);
            if (expectedData.containsKey(teamName)) {

                Assert.assertTrue(
                        actualYears != null && !actualYears.isEmpty(),
                        "Hover data missing for " + teamName
                );
            }
        }
    }
}