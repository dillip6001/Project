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
	

	// locating the WebElement Ethnic check box by xpath in categories screen.
	@FindBy(xpath="//td[contains(text(),'Ethnic')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement Ethnic;
	
	// locating the WebElement delete button by css selector in categories screen.
	@FindBy(css=".btn-danger")
	private WebElement DeleteCategory;
	
		
	// locating the WebElement for Categories text in categories screen.
	@FindBy(xpath="//h1[contains(text(),'Categories')]")
	private WebElement Text;
	
// locating the WebElement for success message for deletion by css selector in categories screen.
	@FindBy(css=".alert")
	private WebElement Alert;
	
//  method to click on check box against the name Ethnic.
	public void checkbox(){
		
		this.Ethnic.click();
	}
	
//	 method to click o selected check box & click on OK button on alert pop up.
		
	public void  DeleteCategory() throws InterruptedException {
   
	     this.DeleteCategory.click();
	         
    driver.switchTo().alert().accept();
	     
        
	}
	
// method to get the text of the success message once you delete the categories.
	public String  AlertSuccess() throws InterruptedException {
		
		Thread.sleep(2000);
		
		return this.Alert.getText();
	
	
}
}
