package tests;

import base.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.TeamsPage;
import utils.TeamData;
import java.util.List;
import java.util.Map;
@Listeners(utils.TestListener.class)
public class TeamDetailsTest extends BaseTest {

    @Test
    public void verifyTeamDetails() {
        WebDriver driver = getDriver();
        driver.get("https://www.iplt20.com/teams");
        acceptCookies(driver);
        TeamsPage teamsPage = new TeamsPage(driver);
        Map<String, String> expectedData = TeamData.getTeamWinningYears();
        List<WebElement> teams = teamsPage.getAllTeams();

        System.out.println("Total Teams Found: " + teams.size());

        for (WebElement team : teams) {

            String teamName = team.getAttribute("data-team_name");
            if (teamName == null || teamName.isEmpty()) continue;
            System.out.println("Checking Team: " + teamName);

            Assert.assertTrue(teamsPage.isLogoDisplayed(team), "Logo NOT displayed for: " + teamName);

            String actualYearsRaw = teamsPage.getWinningYearsOnHover(team);

            String expectedYearsStr = expectedData.get(teamName);

            if (expectedYearsStr != null && !expectedYearsStr.isEmpty()) {
                String actualCleaned = actualYearsRaw.replace("|", " ").replaceAll("\\s+", " ").trim();
                String[] expectedYearsArray = expectedYearsStr.split(" ");
                for (String year : expectedYearsArray) {
                    Assert.assertTrue(actualCleaned.contains(year),
                            "\n[FAILED] Mismatch for " + teamName +
                                    "\nExpected Year: " + year +
                                    "\nActual years found on site: " + actualYearsRaw);
                }
                System.out.println("✔ PASS: " + teamName + " [" + actualCleaned + "]");
            } else {
                if (!actualYearsRaw.isEmpty()) {
                    System.out.println("⚠ WARNING: " + teamName + " has trophies on site but is marked empty in TeamData.");
                } else {
                    System.out.println("ℹ Info: " + teamName + " has no trophies (Matches TeamData).");
                }
            }
        }
        System.out.println("--- All Team Details Verified Successfully ---");
    }
}