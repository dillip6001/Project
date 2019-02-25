package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPOM_Retail {
	private WebDriver driver; 
	
	public AddProductPOM_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-name1")
	private WebElement productname; 
	
	@FindBy(id="input-meta-title1")
	private WebElement MetaTagTitle;
	
	@FindBy(id="input-model")
	private WebElement Model;
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(id="input-category")
	private WebElement category;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement Datatab;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement Linkstab;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Savebutton;
	
	
		
	public void Addproductname(String FingerRing) {
				
		this.productname.sendKeys(FingerRing);
	}
	
	public void AddModel(String model) {
		
		this.Model.sendKeys(model);
	}
	
public void AddCategory(String category ) {
		
		this.category.sendKeys(category);
	}
	
	
public void AddPrice(String price) {
		
		this.price.sendKeys(price);
	}
	
public void AddQuantity(String quantity) {
	
	this.quantity.clear();
	this.quantity.sendKeys(quantity);
}
	
	
	public void AddMetaTagTitle(String FingerRingforladies) {
		
		this.MetaTagTitle.sendKeys(FingerRingforladies);
	}
public void ClickOnDatatab() {
		
		this.Datatab.click();
	}	

public void ClickOnLinkstab() {
	
	this.Linkstab.click();
}	

public void ClickOnSave() {
	
	this.Savebutton.click();
}	



}
