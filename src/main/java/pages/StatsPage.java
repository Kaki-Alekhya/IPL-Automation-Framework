package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
public class StatsPage
{
    WebDriver driver;
    WebDriverWait wait;
    public StatsPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    By firstRow = By.xpath("//table//tbody/tr[1]");
    By allRows = By.xpath("//table//tbody/tr");
    By firstRowCols = By.xpath("//table//tbody/tr[1]/td");
    private List<WebElement> getFirstRowCells() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstRow));
        return driver.findElements(firstRowCols);
    }
    public String getRankOneTeam(){
        List<WebElement> cols = getFirstRowCells();
        return cols.get(1).getText(); // Team column
    }
    public int getMatchesPlayed(){
        List<WebElement> cols = getFirstRowCells();

        String matches = cols.get(2).getText();
        return Integer.parseInt(matches.replaceAll("[^0-9]", ""));
    }
    public int getPoints(){
        List<WebElement> cols = getFirstRowCells();

        String text = cols.get(9).getText().trim();

        if(text.isEmpty()){
            return 0;
        }
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }
}