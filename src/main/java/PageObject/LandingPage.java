package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver ;
	
	By registerPatient = By.cssSelector("[class='icon-user']");
	By findPatientRecord = By.cssSelector("[class='icon-search']");

	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getRegisterPatient()
	{
		
		return driver.findElement(registerPatient);
		
	}
	public WebElement getPatientRecord()
	{
		
		return driver.findElement(findPatientRecord);
		
	}
}
