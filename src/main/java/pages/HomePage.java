package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    // Stable locators
    By teamsTab = By.xpath("//a[contains(@href,'teams')]");
    By newsTab = By.xpath("//a[contains(@href,'news')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public void goToTeams(){
        driver.get("https://www.iplt20.com/teams");
    }
    public void goToNews(){
        driver.get("https://www.iplt20.com/news");
    }

    // 🔁 OPTIONAL UI CLICK (for assignment requirement)
    public void clickTeams(){

        WebElement teams = wait.until(
                ExpectedConditions.elementToBeClickable(teamsTab)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", teams
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", teams
        );
    }

    public void clickNews(){

        WebElement news = wait.until(
                ExpectedConditions.elementToBeClickable(newsTab)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", news
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", news
        );
    }
}