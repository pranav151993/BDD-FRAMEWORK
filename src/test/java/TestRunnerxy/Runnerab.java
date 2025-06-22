package TestRunnerxy;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = "H:\\pranavsoftwares\\SELENIUM\\ECLIPSE\\BDDc2\\src\\test\\java\\feature2\\VendorSearch.feature",
	    glue = "StepDefxy",
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
	)

public class Runnerab extends AbstractTestNGCucumberTests{

}
