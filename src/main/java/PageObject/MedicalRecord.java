package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MedicalRecord {

	WebDriver driver;
	//By givenName = By.xpath("//*[contains(@class,'givenName')]");
	By givenName = By.cssSelector("");
	By homeButton = By.xpath("//a[@href='/openmrs/index.htm']");
	By deletePatient = By.id("org.openmrs.module.coreapps.deletePatient");
	By reason = By.id("delete-reason");
	By confirmButton = By.cssSelector("button[class='confirm.right']");
	
	public MedicalRecord(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getGivenName()
	{
		
		return driver.findElement(givenName).getText();
		
		
	}
	public WebElement getHomeButton()
	{
		
		return driver.findElement(homeButton);
		
	}
	public WebElement deletePatientrecord()
	{
		
		return driver.findElement(deletePatient);
		
	}
	public WebElement giveReason()
	{
		
		return driver.findElement(reason);
		
	}
	public WebElement getConfirmButton()
	{
		
		return driver.findElement(confirmButton);
		
	}
}
