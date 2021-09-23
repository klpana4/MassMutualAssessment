package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods extends Reporter {

	public static Properties prop;
	public static WebDriver driver;
	public static ChromeOptions opt;
	public static WebDriverWait wait;

	public CommonMethods() {
		prop = new Properties();
		try {
			InputStream input = new FileInputStream(
					"C://AssessmentProject_BDD_POM//AssessmentProject_BDD_POM_Final//src//main//java//configs//config.properties");
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void chromeSetUp() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			opt = new ChromeOptions();
			opt.addArguments("start-maximized");
			driver = new ChromeDriver(opt);
		}

		else {

			System.out.println("browser is not supoorted");
		}
	}

	public void invokeUrl() {
		String url = prop.getProperty("url");
		try {
			driver.manage().timeouts().pageLoadTimeout(ProjectMethods.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(ProjectMethods.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(url);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed", "pass");
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser", "fail");
		}
	}

}
