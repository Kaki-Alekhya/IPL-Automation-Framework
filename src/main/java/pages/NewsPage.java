package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class NewsPage {
    WebDriver driver;
    WebDriverWait wait;
    By results = By.xpath("//a[contains(@href,'/news')]");
    public NewsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void search(String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "document.getElementById('searchTabForHeaderMenu').style.display='block';"
        );
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("searchInputForHeader"))
        );
        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//h2 | //h3")
        ));
    }
    By newsTitles = By.id("more_search_res");
    public List<WebElement> getResults(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newsTitles));
        return driver.findElements(newsTitles);
    }
}