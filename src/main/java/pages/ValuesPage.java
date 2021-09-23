package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.ProjectMethods;

public class ValuesPage extends CommonMethods {

	public ValuesPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "lbl_val_1")
	private WebElement lbl_val_1;

	@FindBy(id = "lbl_val_2")
	private WebElement lbl_val_2;

	@FindBy(id = "lbl_val_3")
	private WebElement lbl_val_3;

	@FindBy(id = "lbl_val_4")
	private WebElement lbl_val_4;

	@FindBy(id = "lbl_ttl_val")
	private WebElement lbl_totalValue;

	@FindBy(id = "lbl_val_5")
	private WebElement lbl_val_5;

	@FindBy(id = "txt_val_1")
	private WebElement txt_val_1;

	@FindBy(id = "txt_val_2")
	private WebElement txt_val_2;

	@FindBy(id = "txt_val_3")
	private WebElement txt_val_3;

	@FindBy(id = "txt_val_4")
	private WebElement txt_val_4;

	@FindBy(id = "txt_val_5")
	private WebElement txt_val_5;

	@FindBy(id = "txt_ttl_val")
	private WebElement txt_totalValue;

	@FindBy(how = How.XPATH, using = "//label[starts-with(@id,'lbl_val_')]")
	private List<WebElement> labelFields;

	@FindBy(how = How.XPATH, using = "//input[starts-with(@id,'txt_val_')]")
	private List<WebElement> valueFields;

	public void validCountOfValues() {
		Assert.assertEquals(labelFields.size(), valueFields.size(),
				"Matching the count of label fields and value fields");
	}

	public List<String> fetchValues() {
		List<String> values = new ArrayList<>();
		for (WebElement ele : valueFields) {
			String value = ele.getText();
			values.add(value);
		}

		return values;

	}

	public void checkValueGreaterThanZero() {
		List<String> values = fetchValues();
		values.add(txt_totalValue.getText());
		for (String value : values) {
			Double amount = ProjectMethods.convertCurrencyToDouble(value);
			Assert.assertTrue(amount > 0.00, "Value Greater than Zero");
		}

	}

	public Double getTotalAmountValue() {
		Double totalValue = ProjectMethods.convertCurrencyToDouble(txt_totalValue.getText());
		return totalValue;

	}

	public void checkTotalBalanceAmount() {
		Double actual_totalAmount = this.getTotalAmountValue();
		List<String> values = this.fetchValues();
		Double expected_totalAmount = ProjectMethods.calculateSumOfValues(values);
		Assert.assertEquals(actual_totalAmount == expected_totalAmount,
				"Checking if Total Balance matches with sum of the values");

	}

	public void validateCurrencyFormatOfValues() {
		List<String> values = this.fetchValues();
		for (String value : values) {
			Assert.assertTrue(ProjectMethods.isValidAmount(value), "Amount is Valid");
		}

	}

}
