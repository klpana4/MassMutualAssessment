package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C://AssessmentProject_BDD_POM//AssessmentProject_BDD_POM_Final//feature//valuesVerification.Feature", glue = {
		"stepDefinition", "pages" }, monochrome = true, tags = { "@Functional" }, dryRun = false)

public class Runner {

}
