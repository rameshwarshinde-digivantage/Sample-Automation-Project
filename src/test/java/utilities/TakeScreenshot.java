package utilities;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class TakeScreenshot {
    private final WebDriver driver;

    public TakeScreenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshot(String baseDirectory, String fileNamePrefix) throws IOException {
        // Create a timestamp for a unique filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Specify the relative path for the screenshots directory
        String relativePath = "src/test/resources/reports/screenshots";

        // Combine the base directory with the relative path and timestamp to form the absolute path
        String absolutePath = baseDirectory + "/" + relativePath;
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String fileName = methodName + "_" + fileNamePrefix + "_" + timestamp + ".png";
        String filePath = absolutePath + "/" + fileName;
        
        // Take screenshot using Selenium
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Create the directories if they don't exist
        File directory = new File(absolutePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Copy screenshot to the given file path
        File destFile = new File(filePath);
        FileUtils.copyFile(sourceFile, destFile);
    }

    // Additional method to capture screenshot without a prefix
    public void captureScreenshot(String baseDirectory) throws IOException {
        captureScreenshot(baseDirectory, "screenshot");
    }
}