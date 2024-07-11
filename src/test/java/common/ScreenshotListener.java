package common;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import utilities.TakeScreenshot;

import java.io.IOException;

public class ScreenshotListener extends TestListenerAdapter {
    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result.getName() + "_Failure");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        captureScreenshot(result.getName() + "_Success");
    }

    private void captureScreenshot(String fileNamePrefix) {
        if (driver != null) {
            try {
                TakeScreenshot screenshotTaker = new TakeScreenshot(driver);
                // Specify the base directory where you want to save screenshots
                String baseDirectory = System.getProperty("user.dir");

                screenshotTaker.captureScreenshot(baseDirectory, fileNamePrefix);
                System.out.println("Screenshot captured for: " + fileNamePrefix);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        } else {
            System.err.println("WebDriver is null. Cannot capture screenshot.");
        }
    }
}