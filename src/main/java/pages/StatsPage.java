package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class StatsPage {

    WebDriver driver;
    WebDriverWait wait;

    By rows = By.xpath("//table//tbody/tr");

    public StatsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToPointsTable(){
        driver.get("https://www.iplt20.com/points-table");
    }

    public List<WebElement> getRows(){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rows));
    }

    public String getTopTeam(){
        return getRows().get(0).findElement(By.xpath("./td[2]")).getText();
    }

    public int getMatches(){
        return Integer.parseInt(
                getRows().get(0).findElement(By.xpath("./td[3]")).getText()
        );
    }

    public int getPoints(){
        return Integer.parseInt(
                getRows().get(0).findElement(By.xpath("./td[last()]")).getText()
        );
    }
}