package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ValuesPage;
import utils.ProjectMethods;

public class StepsDefinition extends ProjectMethods {

	ValuesPage valuepage = new ValuesPage();

	@Given("User is on Values Page")
	public void user_is_logged_in() {
		valuepage.invokeUrl();
	}

	@Then("Verify the Count of Values")
	public void verify_the_Count_of_Values() {
		valuepage.validCountOfValues();

	}

	@When("User fetches all values from webpage")
	public void user_gets_the_values() {
		valuepage.fetchValues();
	}

	@Then("Verify values are greater than zero")
	public void verify_values_are_greater_than_zero() {
		valuepage.checkValueGreaterThanZero();

	}

	@When("User fetch the value of total Amount")
	public void user_fetch_the_value_of_total_Amount() {
		valuepage.getTotalAmountValue();

	}

	@Then("Verify the total balance is correct")
	public void verify_the_total_balance_is_correct() {
		valuepage.checkValueGreaterThanZero();

	}

	@Then("Verify values are formated as currencies")
	public void verify_values_are_formated_as_currencies() {
		valuepage.validateCurrencyFormatOfValues();
	}

}
