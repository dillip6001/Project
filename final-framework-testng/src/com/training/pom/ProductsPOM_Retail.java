package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
	
	@FindBy(id="button-filter")
	private WebElement Filterbutton; 
	
	@FindBy(xpath="//td[contains(text(),'finger ring2')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement Fingerring;
	
	@FindBy(css=".btn-danger")
	private WebElement Deletebutton;
	
	@FindBy(css=".alert")
	private WebElement Alert;
	
	@FindBy(xpath="//td[contains(text(),'quis venenatis est ultricies et')]")
	private WebElement FilteredProduct;
	
	@FindBy(xpath="//td[contains(text(),'Integer vitae iaculis massa')]")
	private WebElement FilteredProductByPrice;
	
	
	
	
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
		
public void DeleteButtonClick() {
			
			this.Deletebutton.click();
}
			
			
public void DisplayProduct() {
				
this.ProductName.click();		
			
	}

public void InputPrice() {
	
this.Price.sendKeys("805");


			
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
		

}
