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
	
	//locating the WebElement catalog icon by css selector in HomePage.
	@FindBy(css=".fa-tags")
	private WebElement catalog;
	//locating the WebElement categories  by LinkText in HomePage.
	@FindBy(linkText="Categories")
	private WebElement Categories;
	//locating the WebElement products by LinkText in HomePage.
	@FindBy(linkText="Products")
	private WebElement Products;
	//locating the WebElement shopping cart icon by css selector in HomePage.
	@FindBy(css=".fa-shopping-cart")
	private WebElement ShopingCart;
	
// method to mouse hover on catalog icon & click on categories link .	
	public void  ClickonOnCategories() throws InterruptedException {
	
		WebElement element = driver.findElement(By.cssSelector(".fa-tags"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Categories")).click();
	}
	
	// method to mouse hover on catalog icon & click on products link .
	public void  ClickonOnProducts() {
		
		WebElement element = driver.findElement(By.cssSelector(".fa-tags"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Products")).click();
	}

	// method to mouse hover on shopping cart icon & click on orders link .	
public void  ShoppingCartOrders() {
		
		WebElement element = driver.findElement(By.cssSelector(".fa-shopping-cart"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Orders")).click();
	}
	
	
	
	
	
	
	
	
	
	
}
