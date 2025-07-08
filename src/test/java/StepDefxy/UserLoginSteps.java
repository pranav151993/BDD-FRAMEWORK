package StepDefxy;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import PageObject.LoginPage;
import PageObject.ProductPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserLoginSteps extends BaseClass {
      	 
	
	
	WebDriverWait wait ;
      	                        //we can use @Before & @After hooks multiple times & provide executions sequence by using order
      	 @Before (order=1)     //to run before each scenario...scenario hooks
      	 public void setup() {
      		 
      		  RF = new ReadConfig();
      		     		  
      		//initialise logger
     		log = LogManager.getLogger("UserLoginSteps");
      		 
     		String browsername = RF.getBrowser();     		 
     		//launch browser
    		switch(browsername.toLowerCase())
    		{
    		case "chrome":
    			WebDriverManager.chromedriver().setup();
    			ChromeOptions options = new ChromeOptions();
        		Map<String, Object> prefs = new HashMap<>();
        		prefs.put("credentials_enable_service", false);
        		prefs.put("profile.password_manager_leak_detect", false);
        		 prefs.put("profile.credentials_enable_service",false);
        		options.setExperimentalOption("prefs", prefs);
        		options.addArguments("password-store=basic");              // use basic password store
        		options.addArguments("--disable-infobars");                // disable info bars
        		options.addArguments("--reduce-security-for-testing");// suppress warning dialogs
        		options.addArguments("--guest");
    			driver = new ChromeDriver();
    			
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   			
    			new WebDriverWait(driver, Duration.ofSeconds(30))  //wait for page load
        	    .until(d -> ((JavascriptExecutor) d)
        	        .executeScript("return document.readyState")
        	        .equals("complete")
        	    );    			 
    			driver.manage().window().maximize();  //maximise window
    			
    			break;

    		case "msedge":
    			WebDriverManager.edgedriver().setup();
    			driver = new EdgeDriver();
    			break;

    		case "firefox":
    			WebDriverManager.firefoxdriver().setup();
    			driver = new FirefoxDriver();
    			break;
    		default:
    			driver = null;
    			break;
    		}    		
      		
      		log.info("setup1 executed...."); // can give any messege
      		     		
      	 }
      	 @Before(order=2)  
      	 public void setup2() {
      		 System.out.println("this will execute 2nd as per order sequence");
      		log.info("setup2 executed....");
      	 }
      	 
      	 
      	 
      	 @AfterStep
		public void afterstepdemo() {  
			
			System.out.println("this runs after each step..");  //step hooks
		}
      	 @BeforeStep
		public void beforestepdemo() {
			System.out.println("this runs before each step...");//step hooks
		}
      	 
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		
		lp = new LoginPage(driver);
		pp= new ProductPage(driver);
		
		log.info("user launched chrome browser");
	}
	
	@When("user opens url {string}")
	public void user_opens_url(String url) {
	    driver.get(url);	    
	    log.info("url is opened by user");
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
	   lp.setUserName(username);
		lp.setpassword(password);
		log.info("user entered username& password");
	}

	@When("click on login")
	public void click_on_login() {
	   lp.clicklogin();
	   log.info("user clicked login");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		 String actualTitle = driver.getTitle();	
		    Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
		   System.out.println(actualTitle);
	}
	@When("user clicks on menu")
	public void user_clicks_on_menu() {
	    lp.openmenu();
	}

	@When("click on logout")
	public void click_on_logout() {
	   lp.clicklogout();
	}
	
	
	@Then("user gets invalid login error messagem {string}")
	public void user_gets_invalid_login_error_messagem(String ExpectedErrormessege) {
	    String ActualErrormessege = lp.invalidcred();
	    Assert.assertEquals(ActualErrormessege, ExpectedErrormessege, "Epic sadface: Username and password do not match any user in this service");
		   System.out.println(ActualErrormessege);		  
	}
	@Then("user gets loginRequired error message as {string}")
	public void user_gets_login_required_error_message_as(String ExpectedLoginRequired) {
		String Actualloginreqmessege= lp.loginreqmessege();
		Assert.assertEquals(Actualloginreqmessege, ExpectedLoginRequired, "Epic sadface: Username is required");
		System.out.println(Actualloginreqmessege);
	}	
	
	@Then("product name {string} should be available in products.")
	public void product_name_should_be_available_in_products(String expectedprodctname) {
	   String actualprodctname = pp.productName();
	   if(actualprodctname.equals(expectedprodctname))
	    {
	    	Assert.assertTrue(true);
	    	log.warn("Test passed-login feature: product name matched");
	    }
	    else
	    {
	    	Assert.assertTrue(false);	
	    	log.warn("Test failed-login feature: product name not matched");
	    }	
	   System.out.println(actualprodctname);
	}
	@Then("price of the product should be {string}")
	public void price_of_the_product_should_be(String expectedprice) {
	    String actualprice = pp.cost();
	    if(actualprice.equals(expectedprice))
	    {
	    	Assert.assertTrue(true);	    	
	    }
	    else
	    {
	    	Assert.assertTrue(false);		    	
	    }		   
	}
	
	@Then("User clicks on product name.")
	public void user_clicks_on_product_name() {
	   pp.selectproduct();
	}

	@Then("User clicks on Add to cart.")
	public void user_clicks_on_add_to_cart() {
	  pp.clickaddcart();
	}

	@Then("User clicks on Cart")
	public void user_clicks_on_cart() {
	    pp.clickcart();
	}

	@Then("{string} of product is visible")
	public void of_product_is_visible(String expectedDISCRIPTIONTAB) {
	  String actualDiscription = pp.descrpt();
	  if(actualDiscription.equals(expectedDISCRIPTIONTAB))
	    {
	    	Assert.assertTrue(true);	    	
	    }
	    else
	    {
	    	Assert.assertTrue(false);		    	
	    }
	  System.out.println(actualDiscription);
	}

	@Then("Description of product is {string}")
	public void description_of_product_is(String expectedproductname) {
	 String actualprodname = pp.productdescription();
	 if(actualprodname.equals(expectedproductname))
	    {
	    	Assert.assertTrue(true);	    	
	    }
	    else
	    {
	    	Assert.assertTrue(false);		    	
	    }
		System.out.println("end");  
	}
	
	@Then("User clicks on Remove")
	public void user_clicks_on_remove() {
	    pp.removeclick();
	}
	@Then("Description of product {string} should not visible")
	public void description_of_product_should_not_visible(String productdescription) {
		 boolean absent = pp.isproductNotPresent();
		Assert.assertTrue(absent, "Element is unexpectedly present!");  
	}
	@Then("click on checkout")
	public void click_on_checkout() {
	   pp.clickcheckout();
	}

	@Then("enter {string} and {string} & {string}")
	public void enter_and(String FName, String LName, String PostCode) {
	   pp.enterFirstName(FName);
	   pp.enterLastName(LName);
	   pp.enterPostalCode(PostCode);	
	}

	@Then("Click Continue")
	public void click_continue() {
	   pp.clickContinue();
	}

	@Then("Verify Total Price is {string}")
	public void verify_total_price_is(String ExpectedTotalPrice) {
	   String ActualTotalPrice= pp.TotalPrice();
	   if(ActualTotalPrice.equals(ExpectedTotalPrice))
	    {
	    	Assert.assertTrue(true);	    	
	    }
	    else
	    {
	    	Assert.assertTrue(false);		    	
	    }	
	   System.out.println(ActualTotalPrice);
	}

	@Then("click on Finish")
	public void click_on_finish() {
	   pp.clickFinish();				
	}
	@Then("Verify the text {string}")
	public void verify_the_text(String ExpectedThankText) {
	   String ActualThankText = pp.thanktext();
	   
	   if (ExpectedThankText.equals(ActualThankText))
	   {
		 Assert.assertTrue(true);  		   
	   }
	   else {
		   Assert.assertTrue(false);
	   }	   
	}
	
	
	                 //in case of @After execution order sequence is reverse means higher order will execute 1st
	//@After(order=1)  //to run after each scenario.....scenario hooks	
	public void teardown(Scenario sc) throws IOException {
		if (sc.isFailed()==true) {	 //to take screenshot when scenario failed	
		System.out.println("this execute last due to lower order sequence");		
		//screen shot
		String filewithpath="H:\\pranavsoftwares\\SELENIUM\\ECLIPSE\\BDDc2\\Screenshot\\fullpage.png"	;	
		//step1 convert Webdriverobject into TakeScreenshot interface
		TakesScreenshot abcd = ((TakesScreenshot)driver);
		//call getScreenshotAs method to create image file	WHICH is  STORED IN OBJECT src of file class	
		File src = abcd.getScreenshotAs(OutputType.FILE);
		//copy above file to destination with file name
		File dest = new File(filewithpath);
		//step3 copy image file to destination
		FileUtils.copyFile(src, dest);
		
		}
		driver.quit();
	}
	@After (order=2)
	public void addSSafterEachSteps(Scenario scenario) {
			if (scenario.isFailed()) {		
			TakesScreenshot takeScreenshot =  (TakesScreenshot) driver;
			byte[] screenshot = takeScreenshot.getScreenshotAs(OutputType.BYTES);
			//attach image file to report
			scenario.attach(screenshot, "image/png",scenario.getName() );
			}
			System.out.println("this  execute 1st due to higher order sequence");
		}
	
}
