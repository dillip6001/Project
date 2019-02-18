package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePOM_Retail {
	private WebDriver driver; 
	
	public HomePOM_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".fa-tags")
	private WebElement catalog;
	
	@FindBy(linkText="Categories")
	private WebElement Categories;
	
	@FindBy(linkText="Products")
	private WebElement Products;
	
			

	
	public void  ClickonOnCategories() throws InterruptedException {
	
		WebElement element = driver.findElement(By.cssSelector(".fa-tags"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Categories")).click();
	}
	
	public void  ClickonOnProducts() {
		
		WebElement element = driver.findElement(By.cssSelector(".fa-tags"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Products")).click();
	}
	
	
	
	
	
	
	
	
	
	
}
