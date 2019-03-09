package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EthincProdcts_Retail {
	private WebDriver driver; 
	
	public EthincProdcts_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//locating the WebElement catalog icon by css selector in HomePage.
	@FindBy(xpath="//a[@href='http://retail.upskills.in/ethnic/integer-vitae-iaculis-massa']//span//span//img[contains(@class,'lazyloaded')]")
	private WebElement EthnicIntegerProduct;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement AddtoCart;
		
	@FindBy(css="#cart > ul > li > h3 > a > i")
	private WebElement AddtoCartShoppingCart;
	
	@FindBy(xpath="//*[@id='cart']/ul/li/div/div/div[3]/a[1]")
	private WebElement ViewCart;
	
	@FindBy(xpath="//input[@value='guest']")
	private WebElement RadiobuttonGuestCheckout;
	
	@FindBy(xpath="//input[@id='button-account']")
	private WebElement Continue;
	
	
	
	
	
	
	
	
	
	// method to mouse hover on catalog icon & click on products link .
	public void  ClickOnProduct() {
		
		this.EthnicIntegerProduct.click();
		
		
	}
public void  ClickOnAddtoCart() {
	
	for(String winHandle : driver.getWindowHandles())
	   driver.switchTo().window(winHandle);
		this.AddtoCart.click();
	}

public void  ClickOnViewCart() {
	
	WebElement element = driver.findElement(By.cssSelector("#cart > ul > li > h3 > a > i"));
    Actions action = new Actions(driver);
    action.moveToElement(element).build().perform();
    driver.findElement(By.xpath("//*[@id='cart']/ul/li/div/div/div[3]/a[1]")).click();
	
	
}
public void  GuestCheckOut() {
	
	this.RadiobuttonGuestCheckout.click();

	
	}
public void  ClickOnContinue() {
	
	this.Continue.click();

	
	}
}
	
	
	
	
	
	
	
	

