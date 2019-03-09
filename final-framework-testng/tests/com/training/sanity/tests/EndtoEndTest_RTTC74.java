
/*
  This test case is to verify whether application allows user to place 
  an order as guest user & admin to change
   order order status as complete with the end to end scenario.
 */
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EthincProdcts_Retail;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM_Retail;
import com.training.pom.LoginPageEndUser_Retail;
import com.training.pom.ShoppingCartOrdersPOM_Retail;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EndtoEndTest_RTTC74 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_Retail loginPOM_Retail;
	private static Properties properties;
	private ScreenShot screenShot;
	private LoginPageEndUser_Retail LoginPageEndUser;
	private com.training.pom.HomePageEndUser_Retail HomePageEndUser_Retail;
	private com.training.pom.HomePageEndUser_Retail MyAccountEndUser_Retail;
	private EthincProdcts_Retail  EthincProdcts_Retail;
	private com.training.pom.ViewCartEndUser_Retail ViewCartEndUser_Retail;
	private com.training.pom.CheckOutPOM_Retail CheckOutPOM_Retail;
	private com.training.pom.HomePOM_Retail HomePOM_Retail;
	private com.training.pom.ShoppingCartOrdersPOM_Retail ShoppingCartOrdersPOM_Retail;

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
		baseUrl = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		LoginPageEndUser =new LoginPageEndUser_Retail(driver);
		HomePageEndUser_Retail=new com.training.pom.HomePageEndUser_Retail(driver);
		MyAccountEndUser_Retail=new com.training.pom.HomePageEndUser_Retail(driver);
		 EthincProdcts_Retail =new EthincProdcts_Retail(driver);
		 ViewCartEndUser_Retail=new com.training.pom.ViewCartEndUser_Retail(driver);
		 CheckOutPOM_Retail=new com.training.pom.CheckOutPOM_Retail(driver);
		 HomePOM_Retail =new com.training.pom.HomePOM_Retail (driver);
		 ShoppingCartOrdersPOM_Retail=new ShoppingCartOrdersPOM_Retail(driver);
		
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
// closing all the browser instances opened by WebDriver.
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
	  // click on Ethnic to order a product as guest user
		HomePageEndUser_Retail.ClickOnEthnic();
	 //  select & click on  product on home page	
		EthincProdcts_Retail.ClickOnProduct();
		Thread.sleep(8000);
	// 	click on AddtoCart button.
		EthincProdcts_Retail.ClickOnAddtoCart();
		Thread.sleep(8000);
	//  click on view cart.	
		EthincProdcts_Retail.ClickOnViewCart();
	//  click on checkout.	
		ViewCartEndUser_Retail.ClickOnCheckOut();
	// click on Guest checkout.	
		CheckOutPOM_Retail.GuestCheckOut();
	// click on Continue button on continue button.	
		CheckOutPOM_Retail.ClickOnContinue();
	//	Enter Address details on checkout page.
		CheckOutPOM_Retail.SendFirstName("Dillip");
		CheckOutPOM_Retail.SendLastName("Behera");
		CheckOutPOM_Retail.SendEmail("dillip6001@gmail.com");
		CheckOutPOM_Retail.Sendphone("9620680009");
		CheckOutPOM_Retail.SendAddress("Kadugudi,Bangalore");
		CheckOutPOM_Retail.SendCity("Bangalore");
		CheckOutPOM_Retail.SendPostCode("560067");
	// select country as India from the country drop down.	
		CheckOutPOM_Retail.SelectCountry();
	//select Region	
		CheckOutPOM_Retail.SelectRegion();
		Thread.sleep(2000);
	// select check box.	
		CheckOutPOM_Retail.SelectCheckbox();
		CheckOutPOM_Retail.SelectCheckbox();
	//  click on continue button.	
		CheckOutPOM_Retail.ClickContinue();
	// Enter comment.	
		CheckOutPOM_Retail.EnterComment("test123");
    //  click on continue		
		CheckOutPOM_Retail.ClickOnContinue3();
		Thread.sleep(1000);
	// click & select on agree check box	
		CheckOutPOM_Retail.checkonagree();
	// click on continue	
		CheckOutPOM_Retail.ClickOnContinue4();
	// click on confirm button.	
		CheckOutPOM_Retail.ClickOnConfirm();
		Thread.sleep(2000);
    // Open admin URL in a new browser &login to the application.		
		CheckOutPOM_Retail.OpenAdminURL();
		CheckOutPOM_Retail.newwindow();
		loginPOM_Retail.sendUserName("admin");
		loginPOM_Retail.sendPassword("admin@123");
		loginPOM_Retail.clickLoginBtn();
	//  navigate to the shopping cart orders.	
		HomePOM_Retail.ShoppingCartOrders();
	// click on view icon for the ordered product.	
		ShoppingCartOrdersPOM_Retail.ClickonView1();
	// scroll down to last page	in order details page.
		ShoppingCartOrdersPOM_Retail.Scorlldowntolast();
	// select complete from the drop down. 	
		ShoppingCartOrdersPOM_Retail.SelectComplete();
	  // clicking on Add History tab on order details page.	
		ShoppingCartOrdersPOM_Retail.ClickonAddhistory();
      // Assertion on success message on completion of order
		String expectedmessage = "Success: You have modified orders!";
	    String actualMessage = ShoppingCartOrdersPOM_Retail.GetText();
	    Assert.assertTrue(actualMessage.contains(expectedmessage));
		
		
		
	}
	
	
	
}
