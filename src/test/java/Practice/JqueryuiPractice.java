package Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JqueryuiPractice {
	
	WebDriver driver;
	static String browser;
	
	@BeforeClass
	public static void Propertiesofile() throws  Throwable {
		
		Properties prop = new Properties();
		 prop.load(new FileInputStream("src\\test\\java\\properties\\Application.properties"));
		 
		browser =  prop.getProperty("browser");
		System.out.println(browser);
		
		
	}

	

	@BeforeMethod
	public void BrowserOpening() {
		
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();

		

	}

	@Test()
	public void Automotive1() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		SoftAssert st = new SoftAssert();

		driver.get("https://jqueryui.com/");
		
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[4]/a")).click();
		
			//switching the frames
		
		System.out.println(driver.findElements(By.xpath("//iframe")).size());
		
			driver.switchTo().frame(0);
				
				driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[4]")).click();
				
					driver.switchTo().defaultContent();
					driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a")).click();
				
				driver.quit();
			
				
		
		
		
		

	}

}
