package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static void capture(WebDriver driver, String name){
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(src, new File("screenshots/" + name + ".png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void captureElementScreenshot(WebDriver driver, WebElement element, String testName) {
        try {
            File src = element.getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + testName + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}