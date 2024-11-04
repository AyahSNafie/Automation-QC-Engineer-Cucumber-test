package StepsDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class formFilling {

	private WebDriver driver;

	public formFilling() {

		driver = driverFile.getDriver();
	}

	@When("Choose User Role")
	public void add_user_role() {

		//Wait until the element is visible
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("orangehrm-card-container"))));

		//Fill in DDL after userrole
		WebElement userRoleDDL = driver.findElement(By.xpath("//label[starts-with(text(), 'User Role')]/../following-sibling::div/div[@class='oxd-select-wrapper']/div[@class='oxd-select-text oxd-select-text--active']"));	
		userRoleDDL.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='oxd-select-text oxd-select-text--focus']"))));

		int value = HelpingMethods.RandomFormFiller.random1_2();

		if (value == 1)
		{
			WebElement DDL = driver.findElement(By.xpath("//label[starts-with(text(), 'User Role')]/../following-sibling::div/div[@class='oxd-select-wrapper']/div[contains(@class, 'oxd-select-dropdown')]/div[contains(@class,'oxd-select-option')]/span[text()='Admin']")); 
			DDL.click();		
		}
		if (value== 2)
		{
			WebElement DDL = driver.findElement(By.xpath("//label[starts-with(text(), 'User Role')]/../following-sibling::div/div[@class='oxd-select-wrapper']/div[contains(@class, 'oxd-select-dropdown')]/div[contains(@class,'oxd-select-option')]/span[text()='ESS']")); 		
			DDL.click();
		}

	}


	@When("Choose Status")
	public void choose_status() {


		//Fill in the DDL of status
		WebElement statusDDL = driver.findElement(By.xpath("//label[starts-with(text(), 'Status')]/../following-sibling::div/div[@class='oxd-select-wrapper']/div[@class='oxd-select-text oxd-select-text--active']"));	
		statusDDL.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='oxd-select-text oxd-select-text--focus']"))));
		int value = HelpingMethods.RandomFormFiller.random1_2();


		if (value == 1)
		{
			WebElement status = driver.findElement(By.xpath("//label[starts-with(text(), 'Status')]/../following-sibling::div/div[@class='oxd-select-wrapper']/div[contains(@class, 'oxd-select-dropdown')]/div[contains(@class,'oxd-select-option')]/span[text()='Enabled']")); 
			status.click();		
		}
		if (value== 2)
		{
			WebElement status = driver.findElement(By.xpath("//label[starts-with(text(), 'Status')]/../following-sibling::div/div[@class='oxd-select-wrapper']/div[contains(@class, 'oxd-select-dropdown')]/div[contains(@class,'oxd-select-option')]/span[text()='Disabled']")); 
			status.click();
		}

	}

	@When("Insert Employee Name")
	public void insert_employee_name() throws InterruptedException {

		
		WebElement name = driver.findElement(By.xpath("//label[starts-with(text(), 'Employee Name')]/../following-sibling::div//input"));	
		name.sendKeys("A8DCo 4Ys 010Z");
		
		try {
			driver.manage().wait(5000);
			
			WebElement clickElement = driver.findElement(By.xpath("//label[starts-with(text(), 'Employee Name')]/../following-sibling::div//input/../../div[contains(@class,'oxd-autocomplete-dropdown')]/div[contains(@class,'oxd-autocomplete-option')][1]"));	
			
			clickElement.click();
			//java.util.List<WebElement> clickElement = driver.findElements(By.xpath("//label[starts-with(text(), 'Employee Name')]/../following-sibling::div//input/../../div[contains(@class,'oxd-autocomplete-dropdown')]/div[contains(@class,'oxd-autocomplete-option')][1]"));

//			if(clickElement.size()>=0) {
//				clickElement.get(1).click();
				
	//	}

		} catch (IllegalMonitorStateException e) {
			System.out.println(e.getMessage());
		}


	}

	@When("Username")
	public void username() {
		//Fill in field after username
		WebElement usernameField = driver.findElement(By.xpath("//label[starts-with(text(), 'Username')]/../following-sibling::div/input"));	
		//String employeeName = HelpingMethods.RandomFormFiller.username();
		usernameField.sendKeys("Amina");

	}


	@When("Insert Password and Confirm Password")
	public void insert_password_and_confirm_password() {

		//Fill in field after Password
		String password = HelpingMethods.RandomFormFiller.password();
		WebElement passwordField = driver.findElement(By.xpath("//label[starts-with(text(), 'Password')]/../following-sibling::div/input"));	
		passwordField.sendKeys(password);

		//Fill in field after confirm Password
		WebElement confirmPasswordField = driver.findElement(By.xpath("//label[starts-with(text(), 'Confirm Password')]/../following-sibling::div/input"));
		confirmPasswordField.sendKeys(password);
		System.out.println("The password is "+password);

	}


	@And("Clicks save")
	public void clicks_save() {

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Save New User");
	}

}
