package testScriptSelenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTestAutomation {

	WebDriver driver;
	String browser = "chrome";
	
	
	@BeforeMethod
	public void BrowserOpening() {
		
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
	}
	
	@Test()
	public void Automotive1() throws Throwable {

		SoftAssert st = new SoftAssert();

		
		driver.get("https://www.amazon.com/");

		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();

		WebElement todaysdeal = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
		todaysdeal.click();

		driver.findElement(By.xpath("//input[@data-csa-c-element-id=\"filter-department-15684181\"]")).click();

		// click the firstelement

		driver.findElement(By.xpath("//div[@class=\"DealContent-module__truncate_sWbxETx42ZPStTc9jwySW\"]")).click();

		// click the subelement
		

		driver.findElement(By.xpath("//*[@id=\"octopus-dlp-asin-stream\"]/ul/li[1]/span/div/div[1]/a/div")).click();

		// add to the cart
		driver.findElement(By.id("add-to-cart-button")).click();

		// verify the messege

		String str = driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();

		st.assertEquals(str, "Added to Cart.....");

		st.assertAll();
		
		driver.close();
	}

}
