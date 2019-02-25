package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartOrdersPOM_Retail {
	private WebDriver driver; 
	
	public ShoppingCartOrdersPOM_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table/tbody/tr[5]/td[8]/a")
	private WebElement view; 
	
	@FindBy(id="button-invoice")
	private WebElement invoicebutton; 
	
	@FindBy(xpath="//td[contains(text(),'INV')]")
	private WebElement invoicenumber; 
	
	
	public String invoicenumber() {
		
     return this.invoicenumber.getText();

	}
	
		
	public void ClickonView() {
		this.view.click();
		
	}
	
	public void Clickoninvoicebutton() {
		this.invoicebutton.click();
		
	}	
	
	
	
}
