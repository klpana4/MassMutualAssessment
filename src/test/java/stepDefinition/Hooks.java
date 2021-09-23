package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

	@Before
	public void beforeScenario(Scenario sc) {
		System.out.println(sc.getName());
		System.out.println(sc.getId());
		beginResult();
		testCaseName = sc.getName();
		testCaseDesc = sc.getId();
		category = "Functional";
		author = "Kalpana";
		startTestCase();
		chromeSetUp();

	}

	@After
	public void afterScenario(Scenario sc) {
		closeAllBrowsers();
		endResult();
	}

}
