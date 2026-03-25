package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsPage {

    WebDriver driver;

    By searchBox = By.cssSelector("input[type='search']");
    By results = By.cssSelector(".news-card");

    public NewsPage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String text){
        driver.findElement(searchBox).sendKeys(text + Keys.ENTER);
    }

    public List<WebElement> getResults(){
        return driver.findElements(results);
    }
}
