package base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest_Lambda_Desktop {
	
	String username = "interactiveavenues43";
	String authkey = "VHhi7iPuwRW1BJRMDlqHw1by5QXN7uac55QsTI4RP4RWrpilDF";
	public static RemoteWebDriver driver;
	public String hubURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hhmmss").format(new Date());

	@BeforeMethod
	@Parameters({"browserName", "os"})
	public void setUp(String browserName,String os,Method method) throws IOException, ParseException, InterruptedException {
	

		if(browserName.equalsIgnoreCase("Chrome") && (os.equalsIgnoreCase("Windows")))
		{
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
			ltOptions.put("name", ""+ method.getName());
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			ltOptions.put("selenium_version", "4.0.0");
			browserOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hubURL), browserOptions);
			
		}
		
		if(browserName.equalsIgnoreCase("Edge") && (os.equalsIgnoreCase("Windows")))
		{
			DesiredCapabilities browserOptions = new DesiredCapabilities();
			// SafariOptions browserOptions = new SafariOptions();
			browserOptions.setCapability("platformName", "Windows 11");
			browserOptions.setCapability("browserName", "Edge");
			browserOptions.setCapability("browserVersion", "119");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "interactiveavenues43");
			ltOptions.put("accessKey", "VHhi7iPuwRW1BJRMDlqHw1by5QXN7uac55QsTI4RP4RWrpilDF");
			ltOptions.put("visual", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("build", "Zodiac_Test_Desktop:-" + timeStamp);
			ltOptions.put("project", "ZodiacFunctionalityTest");
			ltOptions.put("name", ""+ method.getName());
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			ltOptions.put("selenium_version", "4.0.0");
			browserOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hubURL), browserOptions);
			
		}
		
		if(browserName.equalsIgnoreCase("Firefox") && (os.equalsIgnoreCase("Windows")))
		{
			DesiredCapabilities browserOptions = new DesiredCapabilities();
			// SafariOptions browserOptions = new SafariOptions();
			browserOptions.setCapability("platformName", "Windows 11");
			browserOptions.setCapability("browserName", "Firefox");
			browserOptions.setCapability("browserVersion", "119");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "interactiveavenues43");
			ltOptions.put("accessKey", "VHhi7iPuwRW1BJRMDlqHw1by5QXN7uac55QsTI4RP4RWrpilDF");
			ltOptions.put("visual", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("build", "Zodiac_Test_Desktop:-" + timeStamp);
			ltOptions.put("project", "ZodiacFunctionalityTest");
			ltOptions.put("name", ""+ method.getName());
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			ltOptions.put("selenium_version", "4.0.0");
			browserOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hubURL), browserOptions);
			
		}
		
		if(browserName.equalsIgnoreCase("Safari") && (os.equalsIgnoreCase("macOS Ventura")))
		{
			DesiredCapabilities browserOptions = new DesiredCapabilities();
			// SafariOptions browserOptions = new SafariOptions();
			browserOptions.setCapability("platformName", "macOS Ventura");
			browserOptions.setCapability("browserName", "Safari");
			browserOptions.setCapability("browserVersion", "16.0");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "interactiveavenues43");
			ltOptions.put("accessKey", "VHhi7iPuwRW1BJRMDlqHw1by5QXN7uac55QsTI4RP4RWrpilDF");
			ltOptions.put("visual", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("build", "Zodiac_Test_Desktop:-" + timeStamp);
			ltOptions.put("project", "ZodiacFunctionalityTest");
			ltOptions.put("name", ""+ method.getName());
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			ltOptions.put("selenium_version", "4.0.0");
			browserOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hubURL), browserOptions);
			
		}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
	
	@AfterMethod
	public void tearDown() {

		driver.executeScript("lambda-status=" + status);
		driver.quit();
	}
	
	

}
