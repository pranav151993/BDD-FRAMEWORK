package StepDefxy;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLoginSteps {
      
	public WebDriver driver;
	 WebDriverWait wait ;
	public LoginPage lp;
		
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
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
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp = new LoginPage(driver);
	}
	
	@When("user opens url {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
	   lp.setUserName(username);
		lp.setpassword(password);
		
	}

	@When("click on login")
	public void click_on_login() {
	   lp.clicklogin();
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
	@Then("close browser")
	public void close_browser() {
	    driver.close();
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
}
