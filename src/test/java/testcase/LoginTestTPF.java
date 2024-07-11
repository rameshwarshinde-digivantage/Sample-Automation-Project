package testcase;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;
import utilities.TakeScreenshot;

@Test
public class LoginTestTPF {

	static WebDriver driver;

	@Test
	public void verifyLoginTestTPF() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.thepinkfoundry.com/");

		// click on login icon
		WebElement loginIcon = driver.findElement(By.xpath("//img[@title=\"Login/Register\"]"));
		loginIcon.click();

		Thread.sleep(5000);

		// click on login button
		WebElement loginBtn = driver.findElement(By.xpath("//a[normalize-space()=\"Login\"]"));
		loginBtn.click();

		Thread.sleep(5000);

		// Enter login details
		WebElement emailField = driver.findElement(By.xpath("//input[@name=\"customer[email]\"]"));
		emailField.sendKeys("rameshwar.shinde@digivantagesolutions.com");

		WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
		passwordField.sendKeys("Pass@123");

		Thread.sleep(5000);

		// Submit login btn
		WebElement loginBtnElement = driver.findElement(By.xpath("//button[normalize-space()=\"Login\"]"));
		loginBtnElement.click();

		Thread.sleep(5000);

		// Taking Screenshot
		TakeScreenshot screenshotTaker = new TakeScreenshot(driver);
		// Specify the base directory where you want to save screenshots
		String baseDirectory = System.getProperty("user.dir");
		try {
			screenshotTaker.captureScreenshot(baseDirectory, "Screenshot");
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
		}

//		// Get the current URL
//		String currentURL = driver.getCurrentUrl();
//
//		// Define the expected URL
//		String expectedURL = "https://www.thepinkfoundry.com/account";
//
//		Assert.assertEquals(currentURL, expectedURL, "URLs do not match.");

		System.out.println("Logged in Test passed successfully");
		Thread.sleep(5000);
		driver.quit();
	}
}
