package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatient {

	WebDriver driver ;
	
	By givenName = By.cssSelector("[name ='givenName']");
	By familyName = By.cssSelector("[name ='familyName']");
	By nextButton = By.cssSelector("[id='next-button']");
	By birthDay = By.id("birthdateDay-field");
	By birthYear = By.id("birthdateYear-field");
	By address = By.id("address1");
	By cityVillage = By.id("cityVillage");
	By state = By.id("stateProvince");
	By country = By.id("country");
	By postalCode = By.id("postalCode");
	By contactNumber= By.name("phoneNumber");
	By confirmButton = By.id("submit");
	
	public RegisterPatient (WebDriver driver)
	{
		this.driver= driver;
	}
	
	public WebElement getGivenName()
	{
		
		return driver.findElement(givenName);
		
	}
	public WebElement getFamilyName()
	{
		
		return driver.findElement(familyName);
		
	}
	public WebElement getNextButton()
	{
		
		return driver.findElement(nextButton);
		
	}
	public void getFemaleGender()
	{
		Select drop = new Select (driver.findElement(By.id("gender-field")));
	      drop.selectByVisibleText("Female");;
		
	}
	public WebElement getBirthDay()
	{
		
		return driver.findElement(birthDay);
		
	}
	public void getBirthMonth()
	{
		Select drop = new Select (driver.findElement(By.id("birthdateMonth-field")));
	      drop.selectByVisibleText("March");;
		
	}
	public WebElement getBirthYear()
	{
		
		return driver.findElement(birthYear);
		
	}
	public WebElement getAddress()
	{
		
		return driver.findElement(address);
		
	}
	public WebElement getCityVillage()
	{
		
		return driver.findElement(cityVillage);
		
	}
	public WebElement getState()
	{
		
		return driver.findElement(state);
		
	}
	public WebElement getCountry()
	{
		
		return driver.findElement(country);
		
	}
	public WebElement getPostalCode()
	{
		
		return driver.findElement(postalCode);
		
	}
	public WebElement getPhoneNumber()
	{
		
		return driver.findElement(contactNumber);
		
	}
	public WebElement getConfirmButton()
	{
		
		return driver.findElement(confirmButton);
		
	}

}
