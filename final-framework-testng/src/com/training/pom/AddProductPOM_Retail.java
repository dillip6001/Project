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
	
// locating the WebElement Product name text box by id  in Add Product page
	@FindBy(id="input-name1")
	private WebElement productname; 
// locating the WebElement Meta Tag Title text box by id  in Add Product page	
	@FindBy(id="input-meta-title1")
	private WebElement MetaTagTitle;
// locating the WebElement Model text box by id  in Add Product page Data tab.	
	@FindBy(id="input-model")
	private WebElement Model;
// locating the WebElement Price text box by id  in Add Product page Data tab.		
	@FindBy(id="input-price")
	private WebElement price;
// locating the WebElement quantity text box by id  in Add Product page Data tab.	
	@FindBy(id="input-quantity")
	private WebElement quantity;
// locating the WebElement categories text box by id  in Add Product page Links tab.	
	@FindBy(id="input-category")
	private WebElement category;
//	locating the WebElement Data tab by x path  in Add Product page.
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement Datatab;
//	locating the WebElement Links tab by x path  in Add Product page.	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement Linkstab;
//	locating the WebElement save button/icon  by x path  in Add Product page.	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Savebutton;
	
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	private WebElement Discounttab;
	
    public void ClickOnDiscounttab() {
		
		this.Discounttab.click();
	}	
	
    @FindBy(xpath="//div[@class='tab-pane active']//i[@class='fa fa-plus-circle']")
	private WebElement AddDiscount; 
    
 public void ClickOnAddDiscount() {
		
		this.AddDiscount.click();
	}	
 
 @FindBy(xpath="//tr[@id='discount-row0']//input[@placeholder='Quantity']")
	private WebElement QuantityDiscount;
 
 public void SendQuantity(String quantitydiscount) {
		
		this.QuantityDiscount.sendKeys(quantitydiscount);
		
	}	

 @FindBy(xpath="//tr[@id='discount-row0']//input[@placeholder='Price']")
	private WebElement PriceDiscount;
 
 public void SendPricediscount(String pricediscount) {
		
		this.PriceDiscount.sendKeys(pricediscount);
		
	}
 
 
 @FindBy(xpath="//a[@href='#tab-reward']")
	private WebElement RewardPointstab;
 
 public void ClickOnRewardPointstab() {
		
		this.RewardPointstab.click();
	}	
 
 
 @FindBy(id="input-points")
	private WebElement RewardsPoint;
 
 public void AddRewardpoints(String rewardpoint) {
		
		this.RewardsPoint.sendKeys(rewardpoint);
		
 }
 
	
// method to enter the product name in general tab in AddProduct page.		
	public void Addproductname(String FingerRing) {
				
		this.productname.sendKeys(FingerRing);
	}
	
// method to enter the model name in Data tab in AddProduct page.		
	public void AddModel(String model) {
		
		this.Model.sendKeys(model);
	}

// method to enter the categories name in Links tab in AddProduct page.
public void AddCategory(String category ) {
		
		this.category.sendKeys(category);
	}
	
//method to enter the price  in Data tab in AddProduct page.	
public void AddPrice(String price) {
		
		this.price.sendKeys(price);
	}

//method to enter the quantity  in Data tab in AddProduct page.
public void AddQuantity(String quantity) {
	
	this.quantity.clear();
	this.quantity.sendKeys(quantity);
}
	
//method to enter the Meta Tag Title   in General tab in AddProduct page.	
	public void AddMetaTagTitle(String FingerRingforladies) {
		
		this.MetaTagTitle.sendKeys(FingerRingforladies);
	}
// method to click on Data tab in Add Product page.	
public void ClickOnDatatab() {
		
		this.Datatab.click();
	}	

//method to click on Links tab in Add Product page.	
public void ClickOnLinkstab() {
	
	this.Linkstab.click();
}	

//method to click on Save button/icon in Add Product page.	
public void ClickOnSave() {
	
	this.Savebutton.click();
}	



}
