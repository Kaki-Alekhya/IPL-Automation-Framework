package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By teamsTab = By.linkText("Teams");
    By newsTab = By.linkText("News");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickTeams(){
        driver.findElement(teamsTab).click();
    }

    public void clickNews(){
        driver.findElement(newsTab).click();
    }
}