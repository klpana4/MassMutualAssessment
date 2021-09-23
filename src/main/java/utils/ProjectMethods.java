package utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectMethods extends CommonMethods {

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 10;

	public static Double convertCurrencyToDouble(String value) {
		String str = null;
		try {
			str = DecimalFormat.getCurrencyInstance().parse(value).toString();
		}

		catch (ParseException e) {
			e.getMessage();
		}

		Double amount = Double.parseDouble(str);
		return amount;
	}

	public static boolean isValidAmount(String value) {
		String regex = "^$?([1-9]{1}[0-9]{0,2}(\\,[0-9]{3})*(\\.[0-9]{0,2})?|[1-9]{1}[0-9]{0,} (\\.[0-9]{0,2})?|0(\\.[0-9]{0,2})?|(\\.[0-9]{1,2})?)$";
		Pattern p = Pattern.compile(regex);
		if (value == null) {
			return false;
		}
		Matcher m = p.matcher(value);
		return m.matches();
	}

	public static Double calculateSumOfValues(List<String> values) {
		Double amount_sum = 0.00;
		for (String val : values) {
			Double amount = convertCurrencyToDouble(val);
			amount_sum += amount;
		}

		return amount_sum;

	}
}
