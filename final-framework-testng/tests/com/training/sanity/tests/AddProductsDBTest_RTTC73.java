//This test case is to verify the database values with application entered values for the add product scenario  
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
import com.training.dataproviders.LoginDataProviders2;
import com.training.generics.ScreenShot;
import com.training.pom.DBTestPOM_Retail;
import com.training.pom.HomePOM_Retail;
    import com.training.pom.LoginPOM;
	import com.training.pom.LoginPOM_Retail;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class AddProductsDBTest_RTTC73{

		private WebDriver driver;
		private String baseUrl;
		private  LoginPOM_Retail LoginPOM_Retail;
		private  HomePOM_Retail HomePOM_Retail;
		private  com.training.pom.ProductsPOM_Retail ProductsPOM_Retail;
		private com.training.pom.AddProductPOM_Retail AddProductPOM_Retail;
		private DBTestPOM_Retail  DBTestPOM_Retail;
		
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
			 DBTestPOM_Retail=new  DBTestPOM_Retail(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			 
			
		}		
	   @Test(dataProvider="db-inputs1",dataProviderClass=LoginDataProviders2.class)
		public void AddProductTest(String username,String password,String productname,
			String Metatagtile,String model,String price,String quantity,
			String category ) throws InterruptedException {
		//  logging to the application with admin user id & password
		    String username1=DBTestPOM_Retail.sendUserName("admin");
		    String password1=DBTestPOM_Retail.sendPassword("admin@123");
		// click on login button.    
			LoginPOM_Retail.clickLoginBtn(); 
		//  clicking on products link from Catalog icon on HomePage
			HomePOM_Retail.ClickonOnProducts();
		//  clicking on AddNew button(+ symbol) to add the product you need.	
			ProductsPOM_Retail.AddNew();
		//  Navigating to addProduct name & in general tab enter product name	
		String productname1=	DBTestPOM_Retail.Addproductname("Finger Ring");
	    String metatagtitle1=	DBTestPOM_Retail.AddMetaTagTitle("Finger Ring for ladies");
		//  clicking on Data Tab in AddProduct page.	
			AddProductPOM_Retail.ClickOnDatatab();
		// Add/Enter  the model in 	AddModel text box on Data tab & store in a string
			String model1=DBTestPOM_Retail.AddModel("SKU-012");
		//	Enter  the price in text box on Data tab.
			String price1=DBTestPOM_Retail.AddPrice("500");
		//	Enter  the quantity text box on Data tab.
			String quantity1=DBTestPOM_Retail.AddQuantity("50");
		// click on Links tab in AddProduct page 	
			AddProductPOM_Retail.ClickOnLinkstab();
		//  Enter  the category text box on Links tab.	
			String category1=DBTestPOM_Retail.AddCategory("EARRINGS");
		//  click on save icon /button.
	    	AddProductPOM_Retail.ClickOnSave();
		// 	static wait for 2 seconds.
			Thread.sleep(2000);
		// Assertion between the application/user entered values vs DB stored value.	
		Assert.assertEquals(username1,username);
		Assert.assertEquals(password1,password);
		Assert.assertEquals(productname1,productname);
		Assert.assertEquals(metatagtitle1,Metatagtile);
		Assert.assertEquals(model1,model);
		Assert.assertEquals(price1,price);
		Assert.assertEquals(quantity1,quantity);
		Assert.assertEquals(category1,category);
		
		
			
			
	}
	// closing all the browser instances opened by WebDriver.
	   @AfterClass
		public void tearDown() throws Exception {
		Thread.sleep(1000);
	driver.quit();
		}
	}
	

		
		
	

	


