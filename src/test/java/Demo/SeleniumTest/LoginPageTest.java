package Demo.SeleniumTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PageObject.FindPatient;
import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.MedicalRecord;
import PageObject.RegisterPatient;
import resource.BaseClass;

public class LoginPageTest extends BaseClass{
	
	public static Logger log= LogManager.getLogger(BaseClass.class.getName()); 
	
	@BeforeMethod
	public void BeforeMethod() throws IOException
	{
		driver=initializerBrowser();
		log.info("Driver is initialized");
		
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		log.info("Application Url launched");
		System.out.println(driver.getTitle());
	}
	
	@Parameters({ "username", "password" })
	@Test
	public void scenario1Test(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUserName().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getIsolationWard().click();
		loginPage.getLogin().click();
		
		AssertJUnit.assertEquals(driver.getTitle(), "Home");
	}
	
	@Parameters({ "username", "invalidPassword" })
	@Test
	public void scenario2Test(String username, String invalidPassword)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUserName().sendKeys(username);
		loginPage.getPassword().sendKeys(invalidPassword);
		loginPage.getIsolationWard().click();
		loginPage.getLogin().click();
		
		String errorMessage = loginPage.getErrorMessage().getText();
		
		AssertJUnit.assertEquals(errorMessage, "Invalid username/password. Please try again.");
	}
	
	@Parameters({ "username", "password" })
	@Test
	public void scenario3Test(String username, String invalidPassword)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUserName().sendKeys(username);
		loginPage.getPassword().sendKeys(invalidPassword);
		loginPage.getIsolationWard().click();
		loginPage.getLogin().click();
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getRegisterPatient().click();
		
		RegisterPatient registerPatient= new RegisterPatient(driver);
		registerPatient.getGivenName().sendKeys("Deepa3");
		registerPatient.getFamilyName().sendKeys("Rana3");
		registerPatient.getNextButton().click();
		
		registerPatient.getFemaleGender();
		registerPatient.getNextButton().click();
		
		registerPatient.getBirthDay().sendKeys("18");
		registerPatient.getBirthMonth();
		registerPatient.getBirthYear().sendKeys("1996");
		registerPatient.getNextButton().click();
		
		registerPatient.getAddress().sendKeys("address1");
		registerPatient.getCityVillage().sendKeys("city");
		registerPatient.getState().sendKeys("state");
		registerPatient.getCountry().sendKeys("India");
		registerPatient.getPostalCode().sendKeys("12345");
		registerPatient.getNextButton().click();
		
		registerPatient.getPhoneNumber().sendKeys("12344");
		registerPatient.getNextButton().click();
		registerPatient.getNextButton().click();
		
		registerPatient.getConfirmButton().click();
		
		MedicalRecord medicalRecord = new MedicalRecord(driver);
		//String givenName = medicalRecord.getGivenName();
		//System.out.println("GivenName="+givenName);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		//Assert.assertEquals(givenName, "Deepa3");
		
		medicalRecord.getHomeButton().click();
		
		landingPage.getPatientRecord().click();
		
		FindPatient findPatient = new FindPatient(driver);
		findPatient.searchPatient().sendKeys("deepa3");
		findPatient.findPatientInTable().click();
		
		medicalRecord.deletePatientrecord().click();
		medicalRecord.giveReason().sendKeys("For testing Purpose");
		medicalRecord.getConfirmButton().click();
		
		findPatient.searchPatient().sendKeys("deepa3");
		System.out.println(findPatient.noRecordFoundMessage());
		
		
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
}
