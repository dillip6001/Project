
	package com.training.sanity.tests;

	import static org.testng.Assert.assertTrue;

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
import com.training.pom.CateogriesPOM_Retail;
import com.training.pom.HomePOM_Retail;
    import com.training.pom.LoginPOM;
	import com.training.pom.LoginPOM_Retail;
import com.training.pom.ShoppingCartOrdersPOM_Retail;
import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class InvoiceGenerationTest_RTTC45{

		private WebDriver driver;
		private String baseUrl;
		private  LoginPOM_Retail LoginPOM_Retail;
		private  HomePOM_Retail HomePOM_Retail;
		private  CateogriesPOM_Retail CateogriesPOM_Retail;
		private ShoppingCartOrdersPOM_Retail ShoppingCartOrdersPOM_Retail;
		
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
			ShoppingCartOrdersPOM_Retail=new ShoppingCartOrdersPOM_Retail(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			
		}

	   @Test (priority=1)
		public void InvoiceGeneration() throws InterruptedException {
		//  logging to the application with admin user id & password & clicking login button
		    LoginPOM_Retail.sendUserName("admin");
			LoginPOM_Retail.sendPassword("admin@123");
			LoginPOM_Retail.clickLoginBtn(); 
		//  clicking on orders link from Shopping Cart icon.
			HomePOM_Retail.ShoppingCartOrders();
		//  clicking on view icon/image to navigate to order details of the customer.	
			ShoppingCartOrdersPOM_Retail.ClickonView();
		//  clicking on invoice image to get invoice number generated  of the customer. 	
			ShoppingCartOrdersPOM_Retail.Clickoninvoicebutton();
			ShoppingCartOrdersPOM_Retail.invoicenumber();
			Thread.sleep(2000);
		//  Assertion for invoice number generation 
			String expectedmessage = "INV";
		    String actualMessage =ShoppingCartOrdersPOM_Retail.invoicenumber();
		    Assert.assertTrue(actualMessage.contains(expectedmessage));
		 // static wait for 3 seconds.
			Thread.sleep(3000);
			
	}
	
	 //  closing all the browser instances opened  by WebDriver.
	   @AfterClass
		public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		}
		
	}
	

		
		
	

	


