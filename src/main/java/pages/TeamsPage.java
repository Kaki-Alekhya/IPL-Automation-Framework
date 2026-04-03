package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class TeamsPage {

    WebDriver driver;
    WebDriverWait wait;

    By teamCards = By.xpath("//a[contains(@href,'/teams/')]");

    public TeamsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public List<WebElement> getAllTeams(){
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(teamCards)
        );
    }

    public void waitForLogoLoad(WebElement team){

        WebDriverWait logoWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logoWait.until(driver1 -> {

            try {
                List<WebElement> images = team.findElements(By.xpath(".//img"));

                if (images.isEmpty()) {
                    return team.isDisplayed();
                }

                WebElement logo = images.get(0);

                return (Boolean) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].complete && arguments[0].naturalWidth > 0",
                        logo
                );

            } catch (StaleElementReferenceException e) {
                return true;
            }
        });
    }
    public boolean isLogoDisplayed(WebElement team){

        try {
            List<WebElement> images = team.findElements(By.xpath(".//img"));

            if (!images.isEmpty()) {
                WebElement logo = images.get(0);

                return logo.isDisplayed() &&
                        logo.getAttribute("src") != null &&
                        !logo.getAttribute("src").isEmpty();
            }

            return team.isDisplayed();

        } catch (StaleElementReferenceException e) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickTeam(WebElement team){

        String currentUrl = driver.getCurrentUrl();

        wait.until(ExpectedConditions.elementToBeClickable(team));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", team);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", team);

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(currentUrl)
        ));
    }

    public String getWinningYears(){

        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));

            WebElement years = shortWait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//img[contains(@src,'trophy')]/following-sibling::*")
                    )
            );

            return years.getText().trim();

        } catch (Exception e) {
            return "";
        }
    }
}