package StepsDefinitions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HelpingMethods.TextExtractor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {

	private driverFile driverManager = new driverFile();
	private WebDriver driver;

	@Given("Browser is open")
	public void openAdminPage() {
		driverManager.driverInitialization();
		driver = driverFile.getDriver();
	}


	@When("User navigates to Opensource website")
	public void user_navigates_to_opensource_website() {

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}


	@And("User inserts Admin and admin123")
	public void user_inserts_admin_and_admin123() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

	}

	@And("User clicks login")
	public void user_clicks_login() {

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Inside method - click login");

	}

	@Then("Return number of rows")
	public void return_number_of_rows() throws InterruptedException {

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait until the element is visible
		//		wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("orangehrm-container"))));


		Thread.sleep(20);

		String recordCountText = "";
		try {

			// Using XPath to locate an element by partial inner HTML
			String partialInnerHTML = "Records Found";

			//WebElement recordCountLabel = driver.findElement(By.xpath("//span[@contains(text(),'Records Found']"));
			WebElement recordCountLabel = driver.findElement(By.xpath("//*[contains(., '" + partialInnerHTML + "')]"));
			// Get the text from the label
			recordCountText = recordCountLabel.getText();
		}
		catch(NoSuchElementException e)
		{
			String partialInnerHTML = "Record Found";
			WebElement recordCountLabel = driver.findElement(By.xpath("//*[contains(., '" + partialInnerHTML + "')]"));
			// Get the text from the label
			recordCountText = recordCountLabel.getText();
		}

		// Locate the position of "Records Found" and extract the surrounding text
		String phrase = "Records Found";
		int recordCount = TextExtractor.extractRecordCount(recordCountText, phrase);

		System.out.println("Number of records available in the table are "+recordCount);

	}
		
		

	@Then("User is navigated to landing page")
	public void user_is_navigated_to_landing_page() {

		driver.getPageSource().contains("Dashboard");
		System.out.println("Inside method - happy landing");

	}

	@Then("Close Browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}
}

