
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

	public class ProductsTest_RTTC014{

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
			LoginPOM_Retail.sendUserName("admin");
			LoginPOM_Retail.sendPassword("admin@123");
			LoginPOM_Retail.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			HomePOM_Retail.ClickonOnProducts();
			ProductsPOM_Retail.ProductName("Integer vitae iaculis massa");
			ProductsPOM_Retail.FilterButtonClick();
			ProductsPOM_Retail.InputPrice();
			ProductsPOM_Retail.FilterButtonClick();
			screenShot.captureScreenShot("RTTC014");
			String expectedmessage = "Integer vitae iaculis massa";
		    String actualMessage = ProductsPOM_Retail.Filtered();
		    screenShot.captureScreenShot("RTTC014_1");
		    Assert.assertEquals(actualMessage,expectedmessage);
		    Thread.sleep(3000);
		    
			
	}
	   
	   @AfterClass
	   
		public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		}

	}
	

		
		
	

	


