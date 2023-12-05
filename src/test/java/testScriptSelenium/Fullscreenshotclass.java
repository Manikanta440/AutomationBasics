package testScriptSelenium;
import java.io.File;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class Fullscreenshotclass {
	
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
			
			//Shutterbug.shootPage(driver, Capture.FULL).withName("Manikanta").save();
			
			
			  WebElement logo = driver.findElement(By.xpath("/html/body/header/a[2]/img"));
			  //Shutterbug.shootElement(driver, logo).withName("ExpectedLogo").save();
			 
			
			boolean equals = Shutterbug.shootElement(driver, logo).equals(ImageIO.read( new File("screenshots\\ExpectedLogo.png")));
			
				st.assertEquals(equals, true);
				
				st.assertAll();
			



	}
	}


