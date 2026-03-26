package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser){

        DriverFactory.initDriver(browser);
        WebDriver driver = DriverFactory.getDriver();

        driver.get("https://www.iplt20.com/");

        acceptCookies(driver);
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }

    public void acceptCookies(WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement acceptBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Accept')]")
                    )
            );

            acceptBtn.click();
            System.out.println("✅ Cookies accepted");

        } catch (Exception e){
            System.out.println("⚠️ No cookies popup");
        }
    }
}