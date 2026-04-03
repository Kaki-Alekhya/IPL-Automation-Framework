package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By footerContainer = By.tagName("footer");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void scrollToFooter() {
        WebElement footer = wait.until(ExpectedConditions.presenceOfElementLocated(footerContainer));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", footer);
        try {
            System.out.println("Scrolling to footer... waiting 5 seconds for links to render.");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public List<WebElement> getLinksBySection(String sectionHeader) {
        // Updated XPath: Finds the h2 header, moves to the parent div, then finds all anchor links
        String xpath = "//h2[text()='" + sectionHeader + "']/parent::div//a";
        return driver.findElements(By.xpath(xpath));
    }
}