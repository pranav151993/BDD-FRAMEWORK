package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BstackdemoPage {

WebDriver driver;
	
	public BstackdemoPage(WebDriver driver) {
		   this.driver = driver;
	        PageFactory.initElements(driver, this);				
	}    
	@FindBy(xpath = "(//p[@class='shelf-item__title'])[1]") 
	WebElement producttitle;	
	public void selectVendor(String vendor) {             //can not use @findby for dynamic xpath
	driver.findElement(By.xpath("//span[text()='"+ vendor +"']")).click(); //dynamic xpath	
	}	
	public String ActualProductTitle() {
		return producttitle.getText();		
	}	
}


