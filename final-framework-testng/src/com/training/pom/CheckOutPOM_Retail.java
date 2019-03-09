package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPOM_Retail {
	private WebDriver driver; 
	
	public CheckOutPOM_Retail(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//input[@value='guest']")
	private WebElement RadiobuttonGuestCheckout;
	
	@FindBy(xpath="//input[@id='button-account']")
	private WebElement Continue;
	
	@FindBy(id="input-payment-firstname")
	private WebElement EnterFirstname;
	
	@FindBy(id="input-payment-lastname")
	private WebElement Enterlastname;
	
	@FindBy(id="input-payment-email")
	private WebElement Enteremail;
	
	@FindBy(id="input-payment-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-payment-address-1")
	private WebElement address1;
	
	@FindBy(id="input-payment-city")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='button-guest']")
	private WebElement ClickContinue;
	
	@FindBy(xpath="//label[@class='checkbox']//input[@value='1']")
	private WebElement Checkbox;
	
	@FindBy(name="postcode")
	private WebElement postcode;
	
	@FindBy(name="comment")
	private WebElement comment;
	
	public void  EnterComment(String comment) {
		
		this.comment.sendKeys(comment);

		
		}
	@FindBy(id="button-shipping-method")
	private WebElement continue3;
	
	public void  ClickOnContinue3() {
		
		this.continue3.click();

		
		}
	
	@FindBy(id="button-payment-method")
	private WebElement continue4;
	
public void  ClickOnContinue4() {
		
		this.continue4.click();

		
		}
	
	
	@FindBy(xpath="//*[@id='collapse-payment-method']/div/div[2]/div[1]/label/input")
	private WebElement agree;
	
public void  checkonagree() {
	
	   		
		this.agree.click();
		
		}


@FindBy(id="button-confirm")
private WebElement confirm;

public void  ClickOnConfirm() {
	
	this.confirm.click();

	
	}
	
	
	
	
	
	
	public void SelectCountry(){
Select dropdown=new Select (driver.findElement(By.id("input-payment-country")));
	 dropdown.selectByVisibleText("India");
	
	}
	
	public void SelectRegion(){
		Select dropdown=new Select (driver.findElement(By.id("input-payment-zone")));
			 dropdown.selectByVisibleText("Karnataka");
			
			}
	
	
	public void Scorlldown(){
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,150)");
		 
		 
	}
	
	

public void  GuestCheckOut() {
	
	this.RadiobuttonGuestCheckout.click();

	
	}
public void  ClickOnContinue() {
	
	this.Continue.click();

	
	}

public void  ClickContinue() {
	
	this.ClickContinue.click();

	
	}

public void  SelectCheckbox() {
	
	
	this.Checkbox.click();

	
	}

public void  SendFirstName(String username) {
	
	this.EnterFirstname.sendKeys("username");

	
	}

public void  SendLastName(String lastname) {
	
	this.Enterlastname.sendKeys(lastname);

	
	}

public void  SendEmail(String email) {
	
	this.Enteremail.sendKeys(email);

	
	}

public void  Sendphone(String telephone) {
	
	this.telephone.sendKeys(telephone);

	
	}

public void  SendAddress(String address1) {
	
	this.address1.sendKeys(address1);
}
	
	public void  SendPostCode(String postcode) {
		
		this.postcode.sendKeys(postcode);	
	
	
		
	}

public void  SendCity(String city) {
	
	this.city.sendKeys(city);
	
		
	}

public void OpenAdminURL(){
	
	String url="http://retail.upskills.in/admin/";
	((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);


}

public void newwindow(){
	for(String winHandle : driver.getWindowHandles())
		   driver.switchTo().window(winHandle);
}

}
	
	
	
	
	
	
	
	

