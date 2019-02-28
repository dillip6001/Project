
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

	public class ProductsTest_RTTC041{

		private WebDriver driver;
		private String baseUrl;
		private  LoginPOM_Retail LoginPOM_Retail;
		private  HomePOM_Retail HomePOM_Retail;
		private  com.training.pom.ProductsPOM_Retail ProductsPOM_Retail;
		
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
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			
		}

	   @Test (priority=1)
		public void FilterProductDetails() throws InterruptedException {
		  //logging to the application with admin user id & password
		    LoginPOM_Retail.sendUserName("admin");
			LoginPOM_Retail.sendPassword("admin@123");
			LoginPOM_Retail.clickLoginBtn(); 
		  //clicking on products link from Catalog icon on HomePage
			HomePOM_Retail.ClickonOnProducts();
		  //Enter the product name in the text box.	
			ProductsPOM_Retail.ProductName("Integer vitae iaculis massa");
		  //click on Filter button 	
			ProductsPOM_Retail.FilterButtonClick();
		  //assertion for the entered product name & the filtered product by product name. 	
			String expectedmessage = "Integer vitae iaculis massa";
		    String actualMessage = ProductsPOM_Retail.Filtered();
		    Assert.assertEquals(actualMessage,expectedmessage);
		    Thread.sleep(1000);
		  //clearing the entered product name in the product name text box.
		    ProductsPOM_Retail.ClearTextProductName();
		    
	   }
	   
	   @Test (priority=2)
		public void FilterProductDetailsByPrice() throws InterruptedException {
		  //Enter the product price in the text box.	
		    ProductsPOM_Retail.InputPrice("500");
		    Thread.sleep(1000);
		  //click on Filter button 
			ProductsPOM_Retail.FilterButtonClick();
		  //assertion for the entered price & the filtered product by price.	
			String expectedmessage = "500.0000";
		    String actualMessage = ProductsPOM_Retail.FilteredByPrice();
		    Assert.assertEquals(actualMessage,expectedmessage);
		  // clearing the text entered for the price.  
		    ProductsPOM_Retail.ClearTextProductPrice();
		    
	   }
	   
	   @Test (priority=3)
		public void FilterProductDetailsByStatus() throws InterruptedException {
	     //selecting the Enabled option for the status in products page. 
		   ProductsPOM_Retail.StatusDrodown();
		 //click on Filter button 
		   ProductsPOM_Retail.FilterButtonClick();
		 // selecting the blank from dropdown value for the status.
		   ProductsPOM_Retail.StatusDrodownDeselect();
		 //assertion for selecting the Enabled status & the filtered product by status enabled.
		   String expectedmessage = "Enabled";
		   String actualMessage = ProductsPOM_Retail.FilteredByStatusEnabled();
		   Assert.assertEquals(actualMessage,expectedmessage);
		    Thread.sleep(1000);
	   }
	   
	   
	   @Test (priority=4)
		public void FilterProductDetailsByModel() throws InterruptedException {
		 //Enter the product model in the text box.   
		   ProductsPOM_Retail.InputModel("SKU-003");
		   Thread.sleep(1000);
		 // click on Filter button.  
		   ProductsPOM_Retail.FilterButtonClick();
		 //clear the entered Model name from the text box.  
		   ProductsPOM_Retail.ClearTextProductModel();
	     //assertion for the entered model & the filtered product by model. 
		   String expectedmessage = "SKU-003";
		   String actualMessage = ProductsPOM_Retail.FilteredByModel();
		   Assert.assertEquals(actualMessage,expectedmessage);
		    Thread.sleep(1000);
		    
	   }
	   
	   @Test (priority=5)
		public void FilterProductDetailsByQuantity() throws InterruptedException {
		 //Enter the product model in the text box.
		   ProductsPOM_Retail.InputQuantity("49");
		   Thread.sleep(1000);
		 //click on Filter button. 
		   ProductsPOM_Retail.FilterButtonClick();
	     //clear the entered quantity from the text box.  
		   ProductsPOM_Retail.ClearTextProductQuantity();
	     //assertion for the entered price & the filtered product by price.   
		   String expectedmessage = "49";
		   String actualMessage = ProductsPOM_Retail.FilteredByQuantity();
		   Assert.assertEquals(actualMessage,expectedmessage);
		    Thread.sleep(1000);
		    
	   }  
	   
	   
	   @Test (priority=6)
		public void FilterProductDetailsByImage() throws InterruptedException {
		 //selecting the Enabled option for the image in products page. 
		   ProductsPOM_Retail.ImageDrodown();
		 //click on Filter button  
		   ProductsPOM_Retail.FilterButtonClick();
		 //selecting the blank option from drop down value for the image.  
		   ProductsPOM_Retail.ImageDrodownDeselect();
	     //Boolean assertion for the enabled option for the image & Filtered product by image.  
		   boolean expected=true;
		   boolean actual=ProductsPOM_Retail.FilteredByImage();
		   Assert.assertEquals( expected,actual);	   
		    Thread.sleep(1000);
		    
	   }  
	   
   @AfterClass
   
     // closing all the browser instances opened by WebDriver.	   
		public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		}

	}
	

		
		
	

	


