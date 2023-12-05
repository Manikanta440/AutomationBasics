package robotclassAndManagewindows;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SikuliImages {

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
		driver.get("https://pdf2doc.com/\r\n" + "");
		
		driver.findElement(By.xpath("//span[text()='UPLOAD FILES']")).click();
		 
		//Filepath
		String filepath = "C:\\Users\\localadmin\\Desktop\\Sikuli\\LoginPage.xlss";
		
			Screen s = new Screen();

				
			s.type("C:\\Users\\localadmin\\Desktop\\Sikuli\\Sikuli1.png", filepath);
			s.click("C:\\Users\\localadmin\\Desktop\\Sikuli\\Sikuli2.png");
		
	}
			

}
