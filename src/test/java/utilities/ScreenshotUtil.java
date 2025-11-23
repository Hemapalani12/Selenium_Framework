package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String tName) {
        
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            File sourceFile= screenshot.getScreenshotAs(OutputType.FILE);
            
            String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+ tName + "-" + timestamp + ".png";
            File targetFile = new File(targetFilePath);
            sourceFile.renameTo(targetFile);
            return targetFilePath;
        
        
    }
}
