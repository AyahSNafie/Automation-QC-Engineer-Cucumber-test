package StepsDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;

public class deleteUser {

    private WebDriver driver;

    public deleteUser() {
    	
        driver = driverFile.getDriver();
      	
    }
	
	@When("Search username for added user")
	public void search_username_for_added_user() {
	  
		WebElement username = driver.findElement(By.xpath("//label[starts-with(text(), 'Username')]/../following-sibling::div/input"));	
		username.sendKeys("Amina");
		username.sendKeys(Keys.RETURN);
		
	}

	@When("Delete the new user")
	public void delete_the_new_user() {
		
		WebElement deleteButton = driver.findElement(By.xpath("//div[contains(@class,'oxd-table-card')][2]//button[@type='button']/i[contains(@class,'oxd-icon bi-trash')]"));
		
		//WebElement deleteButton = driver.findElement(By.xpath("//button[@type='button']/i[contains(@class,'oxd-icon bi-trash')]"));
		deleteButton.click();
		
		WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete')]"));
		confirmButton.click();
	}

}
