package TestRunnerxy;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		 //run selective feature files
	    features = {"H:\\pranavsoftwares\\SELENIUM\\ECLIPSE\\BDDc2\\src\\test\\java\\feature2\\PlaceOrder.feature",
	    		    "H:\\pranavsoftwares\\SELENIUM\\ECLIPSE\\BDDc2\\src\\test\\java\\feature2\\login2.feature"},  
	      
	    		//to run all feature files, give pkg path
	   // features= "H:\\pranavsoftwares\\SELENIUM\\ECLIPSE\\BDDc2\\src\\test\\java\\feature2",  
	    
	    glue = "StepDefxy",
	   dryRun = false,                      //true-to check weteher all steps of feature file are mapped with step def class.
	   monochrome= true,                    //to get output in readable format
	  
	    //tags= "@sanity",                      //to run sanity tag scenarios
	    //tags = "@sanity or @regression",     // to run  scenarios tagged with sanity or regression
	    //tags = "@sanity and @regression",    // to run  scenarios tagged with both sanity & regression
	      tags = "@sanity and not @regression",   //to run scenarios tagged only sanity 
	    
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
	)

public class Runnerab extends AbstractTestNGCucumberTests{

}
