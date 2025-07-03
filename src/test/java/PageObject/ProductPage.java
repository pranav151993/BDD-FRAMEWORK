package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

     WebDriver ldriver;	
     
	public ProductPage (WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);		
	}
	
	@FindBy (xpath= "//div[normalize-space()='Sauce Labs Bolt T-Shirt']")
	WebElement prodctname; 
    
	@FindBy (xpath = "(//div[@class='inventory_item_price'][normalize-space()='$15.99'])[1]")
	WebElement price;	
	
	@FindBy (xpath = "//button[normalize-space()='ADD TO CART']")
	WebElement addcart;
    
	@FindBy (xpath="//*[name()='path' and contains(@fill,'currentCol')]")
	WebElement cart;
    
	@FindBy (xpath= "//div[@class='cart_desc_label']")
	WebElement description;
    
	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement ProductDescrpt;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	 private List<WebElement> productZ;
	
	@FindBy(xpath = "//button[normalize-space()='REMOVE']")
	WebElement Remove;
	
	@FindBy(xpath="//a[@class='btn_action checkout_button']")
	WebElement checkout;
	
	@FindBy(id="first-name")
	WebElement FirstName;
	
	@FindBy(id="last-name")
	WebElement LastName;
	
	@FindBy(id="postal-code")
	WebElement PostalCode;
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	WebElement Continu;
	
	@FindBy(xpath="(//div[@class='summary_total_label'])")
	WebElement Tprice;
	
	@FindBy (xpath="//a[normalize-space()='FINISH']")
	WebElement Finish;
	
	@FindBy(xpath="//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
	WebElement Thankstext;
	
	public String productName() {
		return prodctname.getText();		
	}
	public String cost() {
		return price.getText();		
	}
	public void selectproduct() {
		prodctname.click();
	}
	public void clickaddcart() {
		addcart.click();
	}
	public void clickcart() {
		cart.click();
	}
	public String descrpt() {
		return description.getText();
	}
	public String productdescription() {
		return ProductDescrpt.getText();
	}
	
	public void removeclick() {
		Remove.click();
	}
	 public boolean isproductNotPresent() {
	        return productZ.isEmpty();
	    }	
	
	 public void clickcheckout() {
		 checkout.click();
	 }
	public void enterFirstName(String Name) {
		 FirstName.sendKeys(Name);;
	}
	public void enterLastName(String LName) {
		LastName.sendKeys(LName);
	}
	public void enterPostalCode(String PostCode) {
		PostalCode.sendKeys(PostCode);
	}	
	public void clickContinue() {
		Continu.click();		
	}
	public String TotalPrice() {
		return Tprice.getText();		
	}
	public void clickFinish() {
		Finish.click();		
	}
	public String thanktext() {
		return Thankstext.getText();
	}	
	}
