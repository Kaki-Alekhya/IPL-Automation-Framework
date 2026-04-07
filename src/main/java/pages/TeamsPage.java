package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class TeamsPage {
    WebDriver driver;
    WebDriverWait wait;

    // Updated locator to be more specific to the team cards seen in your screenshot
    By teamCards = By.xpath("//a[contains(@class,'w-100') and contains(@href,'/teams/')]");

    public TeamsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public List<WebElement> getAllTeams() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(teamCards));
    }

    /**
     * Uses JavaScript to extract the text from the hover element.
     * This avoids issues where Selenium's getText() returns empty for hidden elements.
     */
    public String getWinningYearsOnHover(WebElement team) {
        try {
            // Scroll to element first to ensure it's "active" in the DOM
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", team);

            String script = "var el = arguments[0].querySelector('.trophy-text-align');" +
                    "return el ? el.textContent : '';";

            Object result = ((JavascriptExecutor) driver).executeScript(script, team);
            return (result != null) ? result.toString().trim() : "";
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isLogoDisplayed(WebElement team) {
        try {
            // Locates the logo image within the team card
            WebElement logo = team.findElement(By.xpath(".//div[contains(@class,'vn-team-logo')]//img"));
            return logo.isDisplayed() && logo.getAttribute("src") != null;
        } catch (Exception e) {
            return false;
        }
    }
}