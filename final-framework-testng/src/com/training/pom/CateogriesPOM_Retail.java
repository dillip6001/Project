package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CateogriesPOM_Retail {
	private WebDriver driver; 
	
	public CateogriesPOM_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//td[contains(text(),'Ethnic')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement Ethnic;
	
	@FindBy(css=".btn-danger")
	private WebElement DeleteCategory;
	
		
	@FindBy(xpath="//h1[contains(text(),'Categories')]")
	private WebElement Text;
	
	@FindBy(css=".alert")
	private WebElement Alert;
	
	
	public void checkbox(){
		
		this.Ethnic.click();
	}
	
		
		
	public void  DeleteCategory() throws InterruptedException {
		
   
	     this.DeleteCategory.click();
	         
    driver.switchTo().alert().accept();
	     
	     
  
        
	}
	
	
	public String  AlertSuccess() throws InterruptedException {
		
		Thread.sleep(2000);
		
		return this.Alert.getText();
	
	
}
}
