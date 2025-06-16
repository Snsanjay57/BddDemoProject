package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {
	
    public static void takeScreenshot(WebDriver driver, String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(src.toPath(), new File("screenshots/" + fileName + ".png").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
