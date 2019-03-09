// This test case is used to verify  whether application allows the user to return multiple ordered product
	package com.training.sanity.tests;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
    import com.training.pom.HomePOM_Retail;
    import com.training.pom.LoginPOM;
	import com.training.pom.LoginPOM_Retail;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class ReturnProducts_RTTC75{

		private WebDriver driver;
		private String baseUrl;
		private  LoginPOM_Retail LoginPOM_Retail;
		private  HomePOM_Retail HomePOM_Retail;
		private  com.training.pom.ProductsPOM_Retail ProductsPOM_Retail;
		private com.training.pom.AddProductPOM_Retail AddProductPOM_Retail;
		private com.training.pom.LoginPageEndUser_Retail LoginPageEndUser_Retail;
		private com.training.pom.HomePageEndUser_Retail HomePageEndUser_Retail;
		
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
			LoginPageEndUser_Retail=new com.training.pom.LoginPageEndUser_Retail(driver);
			HomePageEndUser_Retail =new com.training.pom.HomePageEndUser_Retail(driver);
			baseUrl = properties.getProperty("baseURL1");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			LoginPageEndUser_Retail.ClickOnLogin();
			LoginPageEndUser_Retail.EnterEmail("dillip6002@gmail.com");
			LoginPageEndUser_Retail.EnterPassword("test@123");
			LoginPageEndUser_Retail.Login();
			
			
		}		
	  
		@Test(priority=1)
		
		public void ReturnProducts() throws InterruptedException {
		
		 	// click on My orders in home page	 
			    HomePageEndUser_Retail.Clickonmyorders();
		 	//   click on view icon	  
		 	     HomePageEndUser_Retail.clickonview();
		 	//  click on return icon Orders details page	  
		 		  HomePageEndUser_Retail.clickonreturn();
		 	//   click on return icon 	  
		 		  HomePageEndUser_Retail.resasonforeturn();
		 	// select reason for return as Dead on arrival	  
		 		  HomePageEndUser_Retail.productisopen();
		 	// Enter comment on text box	  
		 		  HomePageEndUser_Retail.EnterComment();
		 	// click on Submit button.	
		     	 HomePageEndUser_Retail.clickonsubmit();
		 	// Assertion for success message.	
		     	String expectedmessage = "Thank you";
		        String actualMessage =  HomePageEndUser_Retail.getsuccessmessage();
			    Assert.assertTrue(actualMessage.contains(expectedmessage));
		     	 
		 		Thread.sleep(1000);
		   
		   
	   }
		    
		
		    
		    
			    
			
	
	// closing all the browser instances opened by WebDriver.
	   @AfterClass
		public void tearDown() throws Exception {
		Thread.sleep(1000);
	driver.quit();
		}
	}
	

		
		
	

	


