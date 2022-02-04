package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver ;
	
	By userName = By.cssSelector("[id='username']");
	By password = By.cssSelector("[id='password']");
	By isolationWard = By.cssSelector("[id='Isolation Ward']");
	By login = By.cssSelector("[id='loginButton']");
	By errorMessage = By.cssSelector("[id='error-message']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getUserName()
	{
		
		return driver.findElement(userName);
		
	}
	public WebElement getPassword()
	{
		
		return driver.findElement(password);
		
	}
	public WebElement getIsolationWard()
	{
		
		return driver.findElement(isolationWard);
		
	}
	public WebElement getLogin()
	{
		
		return driver.findElement(login);
		
	}
	public WebElement getErrorMessage()
	{
		
		return driver.findElement(errorMessage);
		
	}
}
