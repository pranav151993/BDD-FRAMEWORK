package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;	
	public LoginPage(WebDriver driver) {
    this.driver = driver;
	PageFactory.initElements(driver,this);				
	}
	
	@FindBy(id="user-name")
	WebElement uname;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[normalize-space()='Open Menu']") 
	WebElement menu;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logoutbtn;
	
	@FindBy(xpath = "//h3[@data-test='error']") 
	WebElement invalidcredmessege;
	
	@FindBy(tagName="h3")
	WebElement loginreq;
	
	
	public void setUserName(String user) {	
		uname.sendKeys(user);	
		}	
	public void  setpassword(String passwd) {
		pwd.sendKeys(passwd);
	}
	public void clicklogin() {
		loginbtn.click();		
	}
	public void openmenu() {
		menu.click();
	}
	public void clicklogout() {
		logoutbtn.click();
	}
	
	public String invalidcred() {
		return invalidcredmessege.getText();
	}
    public String loginreqmessege() {
    	return loginreq.getText();
    }
	
}
