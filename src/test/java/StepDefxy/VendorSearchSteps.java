package StepDefxy;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import PageObject.BstackdemoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VendorSearchSteps {

	
	 public WebDriver driver;  
	 WebDriverWait wait ;
	   public BstackdemoPage bst;	  
	  
	   
	@When("user choose {string}")
	public void user_choose(String vendor) {			
		driver = new ChromeDriver();
		bst = new BstackdemoPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      bst.selectVendor(vendor);	   
	}
	@Then("mobile of respective {string} should show")
	public void mobile_of_respective_should_show(String vendorBrand) {
		String abcActualProductTitle = bst.ActualProductTitle();
	    Assert.assertEquals(abcActualProductTitle, vendorBrand);
		   System.out.println(abcActualProductTitle);				
	}		
}
