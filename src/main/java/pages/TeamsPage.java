package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TeamsPage {

    WebDriver driver;

    By teamCards = By.cssSelector(".team-card");

    public TeamsPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getTeams(){
        return driver.findElements(teamCards);
    }
}