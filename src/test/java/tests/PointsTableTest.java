package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import pages.StatsPage;

@Listeners(utils.TestListener.class)
public class PointsTableTest extends BaseTest {

    @Test
    public void verifyPointsTable(){

        StatsPage statsPage = new StatsPage(getDriver());

        // ⚡ FAST navigation
        statsPage.goToPointsTable();

        String team = statsPage.getTopTeam();
        int matches = statsPage.getMatches();
        int points = statsPage.getPoints();

        System.out.println(team + " | Matches: " + matches + " | Points: " + points);

        Assert.assertTrue(matches > 0, "Matches invalid");
        Assert.assertTrue(points > 0, "Points invalid");
    }
}
