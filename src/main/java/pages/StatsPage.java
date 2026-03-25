package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatsPage {

    WebDriver driver;

    By topTeam = By.cssSelector(".table-row:first-child .team-name");
    By matches = By.cssSelector(".table-row:first-child .matches");
    By points = By.cssSelector(".table-row:first-child .points");

    public StatsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTopTeam(){
        return driver.findElement(topTeam).getText();
    }

    public String getMatches(){
        return driver.findElement(matches).getText();
    }

    public String getPoints(){
        return driver.findElement(points).getText();
    }
}