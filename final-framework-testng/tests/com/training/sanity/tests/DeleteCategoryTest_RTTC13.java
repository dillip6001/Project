package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM_Retail;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM_Retail;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
public class DeleteCategoryTest_RTTC13 {
	
	private WebDriver driver;
	private String baseUrl;
	private  LoginPOM_Retail LoginPOM_Retail;
	private  HomePOM_Retail HomePOM_Retail;
	private com.training.pom.CateogriesPOM_Retail CateogriesPOM_Retail;
	private static Properties properties;
	private ScreenShot screenShot;
	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM_Retail = new LoginPOM_Retail(driver);
		HomePOM_Retail=  new  HomePOM_Retail(driver);
		CateogriesPOM_Retail =new com.training.pom.CateogriesPOM_Retail(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	 @Test (priority=1)
		public void DeleteCategoryTest() throws InterruptedException {
	       //logging to the application with admin user id & password
		    LoginPOM_Retail.sendUserName("admin");
			LoginPOM_Retail.sendPassword("admin@123");
	       //clicking on login button	
			LoginPOM_Retail.clickLoginBtn(); 
		   //clicking on Categories link from Catalog icon on HomePage	
			HomePOM_Retail.ClickonOnCategories();
		  // select the checkbox against category Ethnic.
		    CateogriesPOM_Retail.checkbox();
		  // clicking on Delete button icon on the categories page.  
		 	CateogriesPOM_Retail.DeleteCategory();
			screenShot.captureScreenShot("RTTC013");
		  // Assertion for the successful message once you delete the intended category from the category page. 	
			String expectedmessage = "Success: You have modified categories!";
		    String actualMessage = CateogriesPOM_Retail.AlertSuccess();
		      Assert.assertTrue(actualMessage.contains(expectedmessage));
		    
			
	}
	 
	// closing all the browser instances opened by WebDriver.
	 
	 @AfterClass
		public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		}
	 
		
}
