package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM_Retail;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTestsRetail_RTCC011 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_Retail loginPOM_Retail;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM_Retail = new LoginPOM_Retail(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	// closing all the browser instances opened by WebDriver.
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
	//   logging to the application with admin user id & password 
		loginPOM_Retail.sendUserName("admin");
		loginPOM_Retail.sendPassword("admin@123");
	//  clicking on login button 	
		loginPOM_Retail.clickLoginBtn(); 
	//   capturing the screen shot of HomePage	
		screenShot.captureScreenShot("RTTC011");
	//  Assertions for HomePage tile
		String expectedTitle = "Dashboard";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	
	
	
	
	
	
}
