package tests;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        driver.get("https://www.iplt20.com/teams");
        acceptCookies(driver);
        TeamsPage teamsPage = new TeamsPage(driver);
        Map<String, String> expectedData = TeamData.getTeamWinningYears();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int totalTeams = teamsPage.getAllTeams().size();
        for (int i = 0; i < totalTeams; i++) {
            List<WebElement> teams = teamsPage.getAllTeams();
            WebElement team = teams.get(i);
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", team);
            teamsPage.waitForLogoLoad(team);
            Assert.assertTrue(
                    teamsPage.isLogoDisplayed(team),
                    "Logo not displayed"
            );
            String teamName;
            try {
                teamName = team.findElement(By.xpath(".//img")).getAttribute("alt");
            } catch (Exception e) {
                teamName = team.getText().trim();
            }
            teamsPage.clickTeam(team);
            String actualYears = teamsPage.getWinningYears();
            if (expectedData.containsKey(teamName)) {
                String expectedYears = expectedData.get(teamName);
                if (!expectedYears.isEmpty()) {
                    System.out.println("✔ " + teamName + " -> " + actualYears);
                    String normalized = (actualYears == null ? "" : actualYears).replace(",", "");
                    for (String year : expectedYears.split(" ")) {
                        Assert.assertTrue(
                                normalized.contains(year),
                                "Year " + year + " not found for " + teamName
                        );
                    }
                }
            }
            driver.navigate().back();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//a[contains(@href,'/teams/')]")
                    ));
        }
        System.out.println("✅ All teams verified successfully");
    }
}