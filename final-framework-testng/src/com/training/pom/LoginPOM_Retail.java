package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM_Retail {
	private WebDriver driver; 
	
	public LoginPOM_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
//  locating the WebElement user name by id for login details of the admin user .
	@FindBy(id="input-username")
	private WebElement userName; 
//  locating the WebElement password  by id for login details of the admin user .	
	@FindBy(id="input-password")
	private WebElement password;
//  locating the WebElement Login button  by css selector .		
	@FindBy(css=".btn")
	private WebElement loginBtn; 
		
// method to enter the user name in login page of the application.
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	// method to enter the password  in login page of the application.	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	// method to click on Login Button in the Login page of the application.
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}
