package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
public class StatsPage {
    WebDriver driver;
    WebDriverWait wait;
    public StatsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    By rows = By.xpath("//table//tbody/tr");
    private WebElement getFirstRow() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rows));
        List<WebElement> allRows = driver.findElements(rows);
        for (WebElement row : allRows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() >= 10 && row.isDisplayed()) {
                return row;
            }
        }
        throw new RuntimeException("❌ No valid row found");
    }
    public String getRankOneTeam() {
        WebElement row = getFirstRow();
        List<WebElement> cols = row.findElements(By.tagName("td"));
        return cols.get(2).getText().trim(); // ✅ TEAM column
    }
    public int getMatchesPlayed() {

        WebElement row = getFirstRow();

        List<WebElement> cols = row.findElements(By.tagName("td"));

        return parse(cols.get(3).getText()); // P column
    }
    public int getPoints() {

        WebElement row = getFirstRow();

        List<WebElement> cols = row.findElements(By.tagName("td"));

        return parse(cols.get(10).getText()); // PTS column
    }
    private int parse(String text) {
        if (text == null || text.isEmpty()) return 0;

        String num = text.replaceAll("[^0-9]", "");
        if (num.isEmpty()) return 0;

        return Integer.parseInt(num);
    }
}