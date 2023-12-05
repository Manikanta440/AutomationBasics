package seleniumExamples;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkWithTabsAndWindows {
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
		driver.get("https://www.msn.com");
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		//open the flipkart
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector(\"body > fluent-design-system-provider > entry-point\").shadowRoot.querySelector(\"#entry-point-hp-wc-root-wrapper > div.content-container > div.me-stripe-container > me-stripe\").shadowRoot.querySelector(\"div > msft-horizontal-card-slider > me-stripe-tile:nth-child(1)\").shadowRoot.querySelector(\"div > a > div.me-stripe-title-container > div > div.me-stripe-title-main\").click()");
		
		Thread.sleep(4000);
		Set<String> allids = driver.getWindowHandles();
		Iterator<String> it = allids.iterator();
		String mid = it.next();
		String t1 = it.next();
		
		//switch driver ref to tab window
		driver.switchTo().window(t1);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("9972278770");
		//close tab window
		driver.close();
		//driver.switchTo().defaultContent();
		driver.switchTo().window(mid);
		//click on find tutor
		js.executeScript("document.querySelector(\"body > fluent-design-system-provider > entry-point\").shadowRoot.querySelector(\"#entry-point-hp-wc-root-wrapper > div.content-container > div.me-stripe-container > me-stripe\").shadowRoot.querySelector(\"div > msft-horizontal-card-slider > me-stripe-tile:nth-child(3)\").shadowRoot.querySelector(\"div > a > div.me-stripe-title-container > div > div\").click()");


	
	
	
	}

}
