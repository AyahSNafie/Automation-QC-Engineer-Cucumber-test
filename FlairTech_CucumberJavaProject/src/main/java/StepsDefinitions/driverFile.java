package StepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class driverFile {

	static WebDriver driver = null;


	public void driverInitialization() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();	

		driverFile.driver = driver;
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void driverDestory() {

		driver.close();
		driver.quit();
	}

}
