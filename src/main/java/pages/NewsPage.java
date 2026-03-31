package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class NewsPage {

    WebDriver driver;
    WebDriverWait wait;

    // ✅ FIXED locators
    By searchIcon = By.xpath("//a[contains(@class,'search')]");
    By searchBox = By.xpath("//input[contains(@placeholder,'Search')]");
    By results = By.xpath("//h3");

    public NewsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void goToNews(){
        driver.get("https://www.iplt20.com/news");
    }

    public void search(String text){

        // ✅ click search icon first
        WebElement icon = wait.until(
                ExpectedConditions.elementToBeClickable(searchIcon)
        );
        icon.click();

        // ✅ wait for input
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getResults(){
        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(results)
        );
    }
}