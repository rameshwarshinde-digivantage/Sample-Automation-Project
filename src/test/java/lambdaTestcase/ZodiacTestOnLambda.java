package lambdaTestcase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.TakeScreenshot;

public class ZodiacTestOnLambda {

	String username = "interactiveavenues43";
	String authkey = "VHhi7iPuwRW1BJRMDlqHw1by5QXN7uac55QsTI4RP4RWrpilDF";
	public static RemoteWebDriver driver;
	public String hubURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hhmmss").format(new Date());

	@BeforeMethod
	public void setUp() throws IOException, ParseException, InterruptedException {
	

			DesiredCapabilities browserOptions = new DesiredCapabilities();
			// SafariOptions browserOptions = new SafariOptions();
			browserOptions.setCapability("platformName", "Windows 11");
			browserOptions.setCapability("browserName", "chrome");
			browserOptions.setCapability("browserVersion", "119");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "interactiveavenues43");
			ltOptions.put("accessKey", "VHhi7iPuwRW1BJRMDlqHw1by5QXN7uac55QsTI4RP4RWrpilDF");
			ltOptions.put("visual", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("build", "Zodiac_Test_Desktop:-" + timeStamp);
			ltOptions.put("project", "ZodiacFunctionalityTest");
			ltOptions.put("name", "GuestUserTest");
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			ltOptions.put("selenium_version", "4.0.0");
			browserOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hubURL), browserOptions);

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

	

	@Test(priority = 1)
	public void Test1() throws InterruptedException {

		driver.get("https://www.zodiaconline.com/");

		
	}
	@Test(priority = 2)
	public void Test2() throws InterruptedException {

		driver.get("https://www.zodiaconline.com/");

		
	}

	@AfterMethod
	public void tearDown() {

		driver.executeScript("lambda-status=" + status);
		driver.quit();
	}
}