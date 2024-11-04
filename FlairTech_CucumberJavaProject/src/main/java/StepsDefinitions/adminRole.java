package StepsDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;

public class adminRole{

	private WebDriver driver;

	public adminRole() {

		driver = driverFile.getDriver();
	}


	@When("Click on Admin tab")
	public void click_on_admin_tab() 
	{

		driver.findElement(By.linkText("Admin")).click();
		System.out.println("Inside method - Click on admin tab");
	}

	@When("User clicks Add")
	public void user_clicks_add() {

		driver.findElement(By.xpath("//button[@type='button' and contains(., 'Add')]")).click();
		System.out.println("Inside method - click Add button");


	}

}
