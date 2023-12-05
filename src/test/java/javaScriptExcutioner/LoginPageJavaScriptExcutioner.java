package javaScriptExcutioner;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageJavaScriptExcutioner {
	WebDriver driver;
	static String browser;

	@BeforeClass
	public static void Propertiesofile() throws Throwable {

		Properties prop = new Properties();
		prop.load(new FileInputStream("src\\test\\java\\properties\\Application.properties"));

		browser = prop.getProperty("browser");
		

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

	@Test
	public void Testloginpage() throws Throwable {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SoftAssert st = new SoftAssert();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
			js.executeScript("document.getElementById('login1').value='manager' ");
		
		
		js.executeScript("document.getElementById('password').value='manager'");
		
		js.executeScript("document.querySelector(\"body > div.wrapper > div.lft_wrap > div.top_bar > div:nth-child(2) > form > div.floatL.leftwidth > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > input.signinbtn\").click()");
		
		js.executeScript("window.history.go(0)");
		
		
	}
	
}
