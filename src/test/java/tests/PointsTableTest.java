package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import pages.StatsPage;

@Listeners(utils.TestListener.class)
public class PointsTableTest extends BaseTest {

    @Test
    public void verifyPointsTable() {

        WebDriver driver = getDriver();

        driver.get("https://www.iplt20.com/points-table/men");
        acceptCookies(driver);
        StatsPage stats = new StatsPage(driver);
        String team = stats.getRankOneTeam();
        int matches = stats.getMatchesPlayed();
        int points = stats.getPoints();
        System.out.println("🏆 Top Team: " + team);
        System.out.println("📊 Matches: " + matches);
        System.out.println("🎯 Points: " + points);

        Assert.assertNotNull(team, "Team name should not be null");
        Assert.assertFalse(team.isEmpty(), "Team name should not be empty");

        Assert.assertTrue(matches >= 0, "Matches should be >= 0");
        Assert.assertTrue(points >= 0, "Points should be >= 0");

        Assert.assertTrue(points <= matches * 2,
                "Points exceed possible limit");

        System.out.println("✅ Points Table verified successfully");
    }
}