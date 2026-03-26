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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // 🔥 Recommended (DIRECT NAVIGATION - BEST FOR ASSIGNMENT)
    public void goToTeams(){
        driver.get("https://www.iplt20.com/teams");
    }

    public void goToNews(){
        driver.get("https://www.iplt20.com/news");
    }

    // 🔁 Optional UI click (LESS RELIABLE but kept for requirement)
    public void clickTeams(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        WebElement teams = wait.until(
                ExpectedConditions.presenceOfElementLocated(teamsTab)
        );

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", teams
        );

        // JS click (avoids overlay issues)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", teams
        );
    }

    public void clickNews(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        WebElement news = wait.until(
                ExpectedConditions.presenceOfElementLocated(newsTab)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", news
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", news
        );
    }
}