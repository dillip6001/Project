
	package com.training.sanity.tests;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

import org.openqa.selenium.By;
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

	public class AddProductsTest_RTTC042{

		private WebDriver driver;
		private String baseUrl;
		private  LoginPOM_Retail LoginPOM_Retail;
		private  HomePOM_Retail HomePOM_Retail;
		private  com.training.pom.ProductsPOM_Retail ProductsPOM_Retail;
		private com.training.pom.AddProductPOM_Retail AddProductPOM_Retail;
		
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
			ProductsPOM_Retail=new com.training.pom.ProductsPOM_Retail(driver);
			AddProductPOM_Retail=new com.training.pom.AddProductPOM_Retail(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}		
	   @Test(priority=1)
		public void AddProductTest() throws InterruptedException {
		//  logging to the application with admin user id & password
		    LoginPOM_Retail.sendUserName("admin");
			LoginPOM_Retail.sendPassword("admin@123");
		//  clicking on login button 
			LoginPOM_Retail.clickLoginBtn(); 
		//  clicking on products link from Catalog icon on HomePage
			HomePOM_Retail.ClickonOnProducts();
		//  clicking on AddNew button(+ symbol) to add the product you need.	
			ProductsPOM_Retail.AddNew();
		//  Navigating to addProduct name & in general tab enter product name	
			AddProductPOM_Retail.Addproductname("Finger Ring");
		// In General tab enter Meta Tag Tile 	
			AddProductPOM_Retail.AddMetaTagTitle("Finger Ring for ladies");
		//  clicking to Data Tab in AddProduct page.	
			AddProductPOM_Retail.ClickOnDatatab();
		// Add/Enter  the model in 	AddModel text box on Data tab.
			AddProductPOM_Retail.AddModel("SKU-012");
		//	Enter  the price in text box on Data tab.
			AddProductPOM_Retail.AddPrice("500");
		//	Enter  the quantity text box on Data tab.
			AddProductPOM_Retail.AddQuantity("50");
		// click on Links tab in AddProduct page 	
			AddProductPOM_Retail.ClickOnLinkstab();
		//  Enter  the category text box on Links tab.	
			AddProductPOM_Retail.AddCategory("EARRINGS");
		//  click on save icon /button.
	    	AddProductPOM_Retail.ClickOnSave();
		// 	static wait for 2 seconds.
			Thread.sleep(2000);
		//  Assertion for the successful message once you add the intended product from the  product page. 	
			String expectedmessage = "Success: You have modified products!";
	        String actualMessage = ProductsPOM_Retail.AlertSuccess();
		    Assert.assertTrue(actualMessage.contains(expectedmessage));
			    
			
	}
	// closing all the browser instances opened by WebDriver.
	   @AfterClass
		public void tearDown() throws Exception {
		Thread.sleep(1000);
	driver.quit();
		}
	}
	

		
		
	

	


