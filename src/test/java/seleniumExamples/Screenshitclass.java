package seleniumExamples;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Screenshitclass {
	
	WebDriver driver;
	String browser = "chrome";

	@Test()
	public void Screenshot() throws Throwable {
		

			SoftAssert st = new SoftAssert();

			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");

				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
			}

			else if (browser.equalsIgnoreCase("edge"))
				driver = new EdgeDriver();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get("https://www.drikpanchang.com/");
			
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileHandler.copy(f, new File("Testdata.png"));
			
		
		
	}

}
