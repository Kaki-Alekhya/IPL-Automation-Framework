package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static void capture(WebDriver driver, String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        // ✅ UNIQUE NAME FIX
        String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        try {
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
            System.out.println("📸 Screenshot saved: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void captureElementScreenshot(WebDriver driver, WebElement element, String testName) {

        File src = element.getScreenshotAs(OutputType.FILE);

        // ✅ UNIQUE NAME FIX
        String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        try {
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
            System.out.println("📸 Element Screenshot saved: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}