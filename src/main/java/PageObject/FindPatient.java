package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindPatient {
	WebDriver driver;
	
	By findPatient = By.id("patient-search");
	By findPatientTable=By.xpath("//tbody/tr/td[3]");
	By noRecordFoundMessage= By.xpath("//td[@class='dataTables_empty']");
	
	public FindPatient(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement searchPatient()
	{
		
		return driver.findElement(findPatient);
		
	}
	public WebElement findPatientInTable()
	{
		
		return driver.findElement(findPatientTable);
		
	}

	public String noRecordFoundMessage()
	{
		
		return driver.findElement(noRecordFoundMessage).getText();
		
	}
}
