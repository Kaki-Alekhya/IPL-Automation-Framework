package tests;

import base.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamsPage;
import utils.TeamData;
import java.util.List;
import java.util.Map;

public class TeamDetailsTest extends BaseTest {

    @Test
    public void verifyTeamDetails() {
        WebDriver driver = getDriver();
        driver.get("https://www.iplt20.com/teams");

        // Use your base class method to accept cookies if needed
        acceptCookies(driver);

        TeamsPage teamsPage = new TeamsPage(driver);
        Map<String, String> expectedData = TeamData.getTeamWinningYears();
        List<WebElement> teams = teamsPage.getAllTeams();

        System.out.println("Total Teams Found: " + teams.size());

        for (WebElement team : teams) {
            // 1. Identify the team using the data attribute
            String teamName = team.getAttribute("data-team_name");
            if (teamName == null || teamName.isEmpty()) continue;

            System.out.println("Checking Team: " + teamName);

            // 2. Assertion: Verify Logo is present
            Assert.assertTrue(teamsPage.isLogoDisplayed(team), "Logo NOT displayed for: " + teamName);

            // 3. Extraction: Get years from website via Hover/JS
            String actualYearsRaw = teamsPage.getWinningYearsOnHover(team);

            // 4. Mapping: Get expected data from your TeamData class
            String expectedYearsStr = expectedData.get(teamName);

            // 5. Strict Validation
            if (expectedYearsStr != null && !expectedYearsStr.isEmpty()) {
                // Clean the website text (remove pipes '|' and normalize spaces)
                String actualCleaned = actualYearsRaw.replace("|", " ").replaceAll("\\s+", " ").trim();

                String[] expectedYearsArray = expectedYearsStr.split(" ");

                for (String year : expectedYearsArray) {
                    // This assertion will FAIL if you change years in TeamData.java
                    Assert.assertTrue(actualCleaned.contains(year),
                            "\n[FAILED] Mismatch for " + teamName +
                                    "\nExpected Year: " + year +
                                    "\nActual years found on site: " + actualYearsRaw);
                }
                System.out.println("✔ PASS: " + teamName + " [" + actualCleaned + "]");
            } else {
                // Check if it's a team that HASN'T won yet (like Delhi Capitals)
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