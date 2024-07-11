package lambdaTestcase;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import base.BaseTest_Lambda_Desktop;




public class SampleTest extends BaseTest_Lambda_Desktop {
	
	
	
	@Test(priority = 1)
	public void Test1() throws InterruptedException {

		driver.get("https://www.zodiaconline.com/");

		System.out.println("Test 1 passed");
	}
	@Test(priority = 2)
	public void Test2() throws InterruptedException {

		driver.get("https://www.zodiaconline.com/");

		System.out.println("Test 2 passed");
	}

}