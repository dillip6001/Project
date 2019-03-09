package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageEndUser_Retail {
	private WebDriver driver; 
	
	public HomePageEndUser_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//locating the WebElement catalog icon by css selector in HomePage.
	@FindBy(xpath="//span[contains(text(),'Shop Now')]")
	private WebElement SHOPNOW;
	
	
	// method to mouse hover on catalog icon & click on products link .
	public void  ClickOnEthnic() {
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Shop Now')]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Ethnic")).click();
	}
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement usericon;
	
	public void Clickonmyorders(){
		
		WebElement element = driver.findElement(By.xpath("//i[@class='fa fa-user-o']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//span[contains(text(),'MY ORDERS')]")).click();
		
		
	}
	
	@FindBy(css=".fa-eye")
	private WebElement viewicon;
	
	public void clickonview() {
		
		this.viewicon.click();
		
		
		
		
	}
	
	@FindBy(xpath="//a[@title='Return']")
	private WebElement returnicon;
	
	public void clickonreturn() {
		
		this.returnicon.click();
	}
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[1]//label[1]//input[1]")
	private WebElement returnreason;
	
public void  resasonforeturn() {
		
		this.returnreason.click();
	}
	
@FindBy(xpath="//label[@class='radio-inline']//input[@value='1']")
private WebElement productopen;

public void  productisopen() {
	
	this.productopen.click();
}

@FindBy(id="input-comment")
private WebElement comment;

public void  EnterComment() {
	
	this.comment.sendKeys("test");
}

@FindBy(xpath="//input[@value='Submit']")
private WebElement submit;

public void  clickonsubmit() {
	
	this.submit.click();
}

@FindBy(css=".tb_sep > p:nth-child(1)")
private WebElement message;

public String  getsuccessmessage() {
	
	return this.message.getText();
	
	
}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	

