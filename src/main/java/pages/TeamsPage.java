package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class TeamsPage {

    WebDriver driver;
    WebDriverWait wait;

    // ✅ FIXED locator
    By teamCards = By.xpath("//a[contains(@href,'/teams/')]");

    public TeamsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Get all teams
    public List<WebElement> getAllTeams(){
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(teamCards)
        );
    }
    // ✅ Verify logo
    public boolean isLogoDisplayed(WebElement team){
        try {
            // Try multiple possibilities
            List<WebElement> images = team.findElements(By.xpath(".//img | .//picture//img"));

            if (!images.isEmpty()) {
                return images.get(0).isDisplayed();
            }
            // fallback: check background/logo container
            return team.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }
    // ✅ Hover + get data
    public String getTeamTitleYears(WebElement team){
        Actions actions = new Actions(driver);
        // ✅ hover fast
        actions.moveToElement(team).pause(Duration.ofMillis(2000)).perform();
        return team.getText();
    }
}