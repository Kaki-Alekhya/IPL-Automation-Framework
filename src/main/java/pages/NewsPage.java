package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class NewsPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchIcon = By.xpath("//button[contains(@class,'search')]");
    By searchBox = By.xpath("//input[@type='search']");
    By results = By.xpath("//h3");

    public NewsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToNews(){
        driver.get("https://www.iplt20.com/news");
    }

    public void search(String text){

        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getResults(){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(results));
    }
}