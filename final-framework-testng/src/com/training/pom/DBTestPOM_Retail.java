package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DBTestPOM_Retail {
	private WebDriver driver; 
	
	public DBTestPOM_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
//  locating the WebElement user name by id for login details of the admin user .
	@FindBy(id="input-username")
	private WebElement userName; 
//  locating the WebElement password  by id for login details of the admin user .	
	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(id="input-name1")
	private WebElement productname; 
	
	public String Addproductname(String FingerRing) {
		
		this.productname.sendKeys(FingerRing);
		return FingerRing;
		
	}
	
	
	@FindBy(id="input-meta-title1")
	private WebElement MetaTagTitle;

public String AddMetaTagTitle(String FingerRingforladies) {
		
		this.MetaTagTitle.sendKeys(FingerRingforladies);
		return FingerRingforladies;
	}
	
	
@FindBy(id="input-model")
private WebElement Model;


public String AddModel(String model) {
	
	this.Model.sendKeys(model);
	return model;
}


@FindBy(id="input-price")
private WebElement price;

public String AddPrice(String price) {
	
	this.price.sendKeys(price);
	return price;
}

@FindBy(id="input-quantity")
private WebElement quantity;

public String AddQuantity(String quantity) {

this.quantity.clear();
this.quantity.sendKeys(quantity);
return quantity;
}

@FindBy(id="input-category")
private WebElement category;

public String AddCategory(String category ) {
	
	this.category.sendKeys(category);
	return category;
}

	
	
	
		
// method to enter the user name in login page of the application.
	public String sendUserName(String userName) {
		
		this.userName.sendKeys(userName);
		return userName;
		
		
	}
	// method to enter the password  in login page of the application.	
	public String sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password);
		return password; 
	}
	
	
}
