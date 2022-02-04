package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

public WebDriver driver;
	
	public WebDriver initializerBrowser() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("//Users//vineetraghava//Desktop//deepa//SeleniumTest//src//main//java//resource//data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		//When browser is set as chrome
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/vineetraghava/Downloads/chromedriver");
			driver= new ChromeDriver();
			System.out.println(driver);
		}
		
		//System.out.println(driver);
		
		return driver;
	}
}
