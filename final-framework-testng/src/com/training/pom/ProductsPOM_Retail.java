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
	
	@FindBy(id="input-name")
	private WebElement ProductName; 
	
	@FindBy(id="input-price")
	private WebElement Price;
	
	@FindBy(id="input-status")
	private WebElement status;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(id="input-image")
	private WebElement image;

	@FindBy(id="button-filter")
	private WebElement Filterbutton; 
	
	@FindBy(xpath="//td[contains(text(),'finger ring2')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement Fingerring;
	
	@FindBy(xpath="//td[contains(text(),'Ear Rings')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement EarRings;
	
	@FindBy(xpath="//td[contains(text(),'Finger Ring')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement FingerRing;
	
	@FindBy(xpath="//tr[1]/td[contains(text(),'500')]")
	 private WebElement FilteredByPrice;
	
	@FindBy(xpath="//tr[1]/td[contains(text(),'Enabled')]")
	 private WebElement FilteredByStatusEnabled;
	
	@FindBy(xpath="//tr[1]/td[contains(text(),'SKU-003')]")
	 private WebElement FilteredByModel;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[6]/span")
	 private WebElement FilteredByQuantity;
	
	@FindBy(xpath="//tbody//img")
	 private WebElement FilteredByImage;
	
	@FindBy(css=".btn-danger")
	private WebElement Deletebutton;
	
	@FindBy(css=".alert")
	private WebElement Alert;
	
	@FindBy(css=".fa-plus")
	private WebElement AddNew;
	
	@FindBy(xpath="//td[contains(text(),'quis venenatis est ultricies et')]")
	private WebElement FilteredProduct;
	
	@FindBy(xpath="//td[contains(text(),'Integer vitae iaculis massa')]")
	private WebElement FilteredProductByPrice;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[8]/a")
	private WebElement Editbutton;
	
	
	
	public void ClickOnEdit() {
		this.Editbutton.click();
	}	
	

	
public void FilteredProduct() {
		this.FilteredProduct.click();
	}

public void ProductName(String ProductName ) {
		this.ProductName.clear();
		this.ProductName.sendKeys(ProductName);
	}
	
public void FilterButtonClick() {
		this.Filterbutton.click();
	}
		
public void checkbox() {
			this.Fingerring.click();
	}

public void AddNew() {
	this.AddNew.click();
}

public void EarRingscheckbox() {
	this.EarRings.click();
}

public void FingerRingcheckbox() {
	this.FingerRing.click();
}		
public void DeleteButtonClick() {
			
			this.Deletebutton.click();
}
			
			
public void DisplayProduct() {
				
this.ProductName.click();		
			
	}

public void InputPrice(String price) {
	
this.Price.sendKeys(price);
	}


public void InputModel(String model) {
this.model.sendKeys(model);
	}
public void InputQuantity(String quantity) {
this.quantity.sendKeys(quantity);
	}


public  void AlertAccept() throws InterruptedException {
	
	Thread.sleep(3000);
	
	 driver.switchTo().alert().accept();
}
	 
public String  AlertSuccess() throws InterruptedException {
			
			Thread.sleep(2000);
			
			return this.Alert.getText();
}

public String  Filtered() throws InterruptedException {
			
			Thread.sleep(2000);
			
return this.FilteredProductByPrice.getText();
}	

public void  ClearTextProductName()  {
		driver.findElement(By.id("input-name")).clear();
}
	 
	 
	 public void  ClearTextProductPrice()  {
			driver.findElement(By.id("input-price")).clear();
	}
	 
	 public void  ClearTextProductModel()  {
			driver.findElement(By.id("input-model")).clear();
	}	
		 	 
	 public void  ClearTextProductQuantity()  {
			driver.findElement(By.id("input-quantity")).clear();
	}	
	 
	 public void  StatusDrodown()  {
		 Select dropdown=new Select (driver.findElement(By.id("input-status")));
		 dropdown.selectByVisibleText("Enabled");
	}
	 
	 public void  ImageDrodown()  {
		 Select dropdown=new Select (driver.findElement(By.id("input-image")));
		 dropdown.selectByVisibleText("Enabled");
	}		 
	 
	 public void  StatusDrodownDeselect()  {
		 Select dropdown=new Select (driver.findElement(By.id("input-status")));
		 dropdown.selectByValue("*");
		
	}	
	 
	 
	 public void  ImageDrodownDeselect()  {
		 Select dropdown=new Select (driver.findElement(By.id("input-image")));
		 dropdown.selectByValue("*");
	}		 		

	 public String  FilteredByPrice()  {
		 
		 return this.FilteredByPrice.getText();
	}		 
 public String  FilteredByStatusEnabled()  {
		 
		 return this.FilteredByStatusEnabled.getText();
	}		 
	 
 public String  FilteredByModel()  {
	 
	 return this.FilteredByModel.getText();
}
 
public String  FilteredByQuantity()  {
	 
	 return this.FilteredByQuantity.getText();
}	

public  boolean  FilteredByImage()  {
	 
	 return this.FilteredByImage.isEnabled();
}	
 
	 
}
