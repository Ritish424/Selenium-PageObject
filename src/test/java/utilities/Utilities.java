package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class Utilities {

    public static String screenShotFilePath(WebDriver driver) throws IOException {
        String screenShotFilePath;
        screenShotFilePath = System.getProperty("user.dir") + "/Screenshots/" + Utilities.timeStamp() + ".png";
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File finalDestination = new File(screenShotFilePath);
        FileUtils.copyFile(screenShotFile, finalDestination);
        return screenShotFilePath;
    }

    public static String timeStamp() {
        Instant instant = Instant.now();
        return instant.toString().replace("-", "_").replace(":", "_").replace(".", "_");

    }
}
