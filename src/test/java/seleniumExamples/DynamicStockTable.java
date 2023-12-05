package seleniumExamples;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DynamicStockTable {
	
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
		
		driver.get("https://www.rediff.com/");
			driver.findElement(By.xpath("//div[@class=\"table\"]/div[2]/a[2]")).click();
			driver.findElement(By.xpath("//div[@id=\"moremoney\"]/ul/li[6]")).click();
			
			List<WebElement> findElements = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
					System.out.println(findElements.size());
				
				for( WebElement x: findElements) {
					System.out.println(x.getText());
				}
		
		
	}



}
