package seleniumExamples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTable {
	WebDriver driver1;
	String Browser1 = "edge";

	@Test
	public void testCase11() throws Throwable {
		SoftAssert st = new SoftAssert();
		if (Browser1.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			driver1 = new ChromeDriver(option);// openBrowser
		} else if (Browser1.equalsIgnoreCase("firefox"))
			driver1 = new FirefoxDriver();
		else if (Browser1.equalsIgnoreCase("edge"))
			driver1 = new EdgeDriver();

		driver1.get("https://mail.rediff.com/cgi-bin/login.cgi"); // openurl
		driver1.manage().window().maximize(); // maximize browser window
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// signin
		driver1.findElement(By.name("proceed")).click();
		Thread.sleep(2000);
		// Alert
		Alert alert = driver1.switchTo().alert();
		System.out.println("Alert text =" + alert.getText());
		alert.accept(); // Ok button
		// alert.dismiss(); //Cancel button

		// Enter username
		driver1.findElement(By.id("login1")).sendKeys("tester");

		driver1.quit();

	}

	WebDriver driver;
	String Browser = "edge";

	@Test
	public void testCase1() throws Throwable {
		SoftAssert st = new SoftAssert();
		if (Browser1.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			driver1 = new ChromeDriver(option);// openBrowser
		} else if (Browser1.equalsIgnoreCase("firefox"))
			driver1 = new FirefoxDriver();
		else if (Browser1.equalsIgnoreCase("edge"))
			driver1 = new EdgeDriver();

		driver1.get("https://money.rediff.com/gainers"); // openurl
		driver1.manage().window().maximize(); // maximize browser window
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// webTable
		List<WebElement> li = driver1.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td"));
		System.out.println("Total rowcount=" + li.size());

		for (WebElement x : li) {
			System.out.println(x.getText());
			/*
			 * if(x.getText().contains("HB Portfolio")){
			 * System.out.println("HB Portpolio exists"); break; }
			 */
		}

	}

}
