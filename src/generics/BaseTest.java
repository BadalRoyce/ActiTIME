package generics;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pom.HomePage;
import pom.LoginPage;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;	
	
	@BeforeSuite
	public void executionstart()
	{
		System.out.println("execution started");
	}
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String browser)
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.logfile", "./logfile/chromelog.txt");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(chrome_key, chrome_value);
			driver=new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		}
		
		else
		{
			System.setProperty(gecko_key, gecko_value);
			driver=new FirefoxDriver();
		}	
		
		driver.manage().window().maximize();
		driver.get(url);
	}	
		
	@AfterClass
	public void teardown()
	{
		//driver.quit();
	}
	
	@AfterSuite
	public void executioncomplete()
	{
		System.out.println("execution completed");
	}
}