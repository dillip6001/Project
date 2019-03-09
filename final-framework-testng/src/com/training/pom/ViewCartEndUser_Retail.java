package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartEndUser_Retail {
	private WebDriver driver; 
	
	public ViewCartEndUser_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//locating the WebElement catalog icon by css selector in HomePage.
	
	@FindBy(css="a.btn-primary")
	private WebElement CheckOut;
	
	
	
	
	
	
	
	
	
	// method to mouse hover on catalog icon & click on products link .
	public void  ClickOnCheckOut() {
		
		this.CheckOut.click();
	}




	
	}
	
	
	
	
	
	
	
	
	
	

