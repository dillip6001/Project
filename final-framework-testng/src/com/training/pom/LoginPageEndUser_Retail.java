package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageEndUser_Retail {
	private WebDriver driver; 
	
	public LoginPageEndUser_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//locating the WebElement catalog icon by css selector in HomePage.
	@FindBy(css=".fa-user-o")
	private WebElement LOGIN;
	
	
	// method to mouse hover on catalog icon & click on products link .
	public void  ClickOnLogin() {
		
		WebElement element = driver.findElement(By.cssSelector(".fa-user-o"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.partialLinkText("LOGIN")).click();
	}
	@FindBy(id="input-email")
	private WebElement Email;
	
	public void EnterEmail(String email){
		
		this.Email.sendKeys(email);
	}
	
	@FindBy(id="input-password")
	private WebElement password;
	
	public void EnterPassword(String password){
		
		this.password.sendKeys(password);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement Login;
	
public void Login(){
		
		this.Login.click();
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	

