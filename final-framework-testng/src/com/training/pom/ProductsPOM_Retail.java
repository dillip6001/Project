package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductsPOM_Retail {
	
private WebDriver driver; 
	
	public ProductsPOM_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
// locating the webElement Product name text box by id in product lists page.
	@FindBy(id="input-name")
	private WebElement ProductName; 
// locating the webElement Price text box by id in product lists page.	
	@FindBy(id="input-price")
	private WebElement Price;
// locating the webElement Status drop down select option by id product lists page.		
	@FindBy(id="input-status")
	private WebElement status;
// locating the webElement Model text box by id in product lists page.	
	@FindBy(id="input-model")
	private WebElement model;
// locating the webElement Quantity text box by id in product lists page.	
	@FindBy(id="input-quantity")
	private WebElement quantity;
// locating the webElement Image drop down select option by id product lists page.	
	@FindBy(id="input-image")
	private WebElement image;
// locating the Filter button image/icon in Product List page.	
	@FindBy(id="button-filter")
	private WebElement Filterbutton; 
// Locating the WebElement finger ring2 check box by relative x path in products page.	
	@FindBy(xpath="//td[contains(text(),'finger ring2')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement Fingerring;
// Locating the WebElement Ear Rings check box by relative x path in products page.	
	@FindBy(xpath="//td[contains(text(),'Ear Rings')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement EarRings;
// Locating the WebElement Finger Ring check box by relative x path in products page.	
	@FindBy(xpath="//td[contains(text(),'Finger Ring')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement FingerRing;
// locating the WebElement price value as '500' as text by x path in column value.	
	@FindBy(xpath="//tr[1]/td[contains(text(),'500')]")
	 private WebElement FilteredByPrice;
// locating the WebElement Status value as Enabled  as text by x path in column value for the Web table.	
	@FindBy(xpath="//tr[1]/td[contains(text(),'Enabled')]")
	 private WebElement FilteredByStatusEnabled;
// locating the WebElement Model value as 'SKU-003' as text by x path in column value for the Web table.	
	@FindBy(xpath="//tr[1]/td[contains(text(),'SKU-003')]")
	 private WebElement FilteredByModel;
// 	locating the WebElement quantity by x path in the web table with row 1 & column 6.
	@FindBy(xpath="//table/tbody/tr[1]/td[6]/span")
	 private WebElement FilteredByQuantity;
//  locating the WebElemet image by x path in the Web table.	
	@FindBy(xpath="//tbody//img")
	 private WebElement FilteredByImage;
//  locating the WebElement delete button in products page.	
	@FindBy(css=".btn-danger")
	private WebElement Deletebutton;
//  locating the web Element Alert message by css selector  once you delete the product from product page.	
	@FindBy(css=".alert")
	private WebElement Alert;
//  Locating the WebElement AddNew button /icon in product page.	
	@FindBy(css=".fa-plus")
	private WebElement AddNew;
// locating the WebElement Product name as below by x path in web table.	
	@FindBy(xpath="//td[contains(text(),'quis venenatis est ultricies et')]")
	private WebElement FilteredProduct;
// locating the WebElement Product name as below by x path in web table.	
	@FindBy(xpath="//td[contains(text(),'Integer vitae iaculis massa')]")
	private WebElement FilteredProductByPrice;
// locating the WebElement Edit button by x path  on Action column of Web table. 	
	@FindBy(xpath="//table/tbody/tr[1]/td[8]/a")
	private WebElement Editbutton;
	
	
//  method to click on Edit button in Web table of products page.	
	public void ClickOnEdit() {
		this.Editbutton.click();
	}	
	
// method to click on Filtered button of products page.	
public void FilteredProduct() {
		this.FilteredProduct.click();
	}
// method to enter the product name in product lists page.
public void ProductName(String ProductName ) {
		this.ProductName.clear();
		this.ProductName.sendKeys(ProductName);
	}
//method to click on Filtered button of products page.	
public void FilterButtonClick() {
		this.Filterbutton.click();
	}
// method to select the Finger ring check box.		
public void checkbox() {
			this.Fingerring.click();
	}
// method to click on AddNew button/icon on product page.

public void AddNew() {
	this.AddNew.click();
}
// method to select on Ear Rings check box on product page web table.
public void EarRingscheckbox() {
	this.EarRings.click();
}
//method to select on Finger Ring check box on product page web table.
public void FingerRingcheckbox() {
	this.FingerRing.click();
}	
// method to click on delete button on product page.
public void DeleteButtonClick() {
			
			this.Deletebutton.click();
}
			
// method to display the product name based on product name input given & click on filter button.   			
public void DisplayProduct() {
				
this.ProductName.click();		
			
	}
// method to enter the price in product lists page.
public void InputPrice(String price) {
	
this.Price.sendKeys(price);
	}

// method to enter model in product lists page.
public void InputModel(String model) {
this.model.sendKeys(model);
	}
//  method to enter quantity in product lists page.
public void InputQuantity(String quantity) {
this.quantity.sendKeys(quantity);
	}

// method to accept(click OK)  the alert message once you delete the product from product page.
public  void AlertAccept() throws InterruptedException {
	
	Thread.sleep(3000);
	
	 driver.switchTo().alert().accept();
}
// method to get the success message text once the product is deleted from product page. 	 
public String  AlertSuccess() throws InterruptedException {
			
			Thread.sleep(2000);
			
			return this.Alert.getText();
}
// method to get the text once you filtered the product by price in webtable.
public String  Filtered() throws InterruptedException {
			
			Thread.sleep(2000);
			
return this.FilteredProductByPrice.getText();
}	
//  method to clear the entered text for product name.
public void  ClearTextProductName()  {
		driver.findElement(By.id("input-name")).clear();
}
	 
//method to clear the entered text for price.	 
	 public void  ClearTextProductPrice()  {
			driver.findElement(By.id("input-price")).clear();
	}
//method to clear the entered text for Model.	 
	 public void  ClearTextProductModel()  {
			driver.findElement(By.id("input-model")).clear();
	}	
//method to clear the entered text for quantity.	 	 
	 public void  ClearTextProductQuantity()  {
			driver.findElement(By.id("input-quantity")).clear();
	}	
//method to clear the selected option for the Status.	 
	 public void  StatusDrodown()  {
		 Select dropdown=new Select (driver.findElement(By.id("input-status")));
		 dropdown.selectByVisibleText("Enabled");
	}
//method to clear the selected option for the Image.	 
	 public void  ImageDrodown()  {
		 Select dropdown=new Select (driver.findElement(By.id("input-image")));
		 dropdown.selectByVisibleText("Enabled");
	}		 
// 	method to select the blank option for the Status. 
	 public void  StatusDrodownDeselect()  {
		 Select dropdown=new Select (driver.findElement(By.id("input-status")));
		 dropdown.selectByValue("*");
		
	}	
	 
//	method to select the blank option for the Image.	 
	 public void  ImageDrodownDeselect()  {
		 Select dropdown=new Select (driver.findElement(By.id("input-image")));
		 dropdown.selectByValue("*");
	}		 		

// method to get the text once you filter the product by price in Web table.
	 public String  FilteredByPrice()  {
		 
		 return this.FilteredByPrice.getText();
	}
//method to get boolean value once you filter the product by Status as Enabled in Web table.	 
 public String  FilteredByStatusEnabled()  {
		 
		 return this.FilteredByStatusEnabled.getText();
	}		 
//method to get the text once you filter the product by model in Web table.	 
 public String  FilteredByModel()  {
	 
	 return this.FilteredByModel.getText();
}
//method to get the text once you filter the product by quantity in Web table.	 
public String  FilteredByQuantity()  {
	 
	 return this.FilteredByQuantity.getText();
}	
//method to get boolean value once you filter the product by image as Enabled in Web table.
public  boolean  FilteredByImage()  {
	 
	 return this.FilteredByImage.isEnabled();
}	
 
	 
}
