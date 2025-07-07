package StepDefxy;

import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import PageObject.ProductPage;
import Utilities.ReadConfig;

import java.util.Properties;

import org.apache.logging.log4j.*;
public class BaseClass {

	public static WebDriver driver;
	public LoginPage lp;
	public ProductPage pp;
	public static Logger log;
	public ReadConfig RF;
}
