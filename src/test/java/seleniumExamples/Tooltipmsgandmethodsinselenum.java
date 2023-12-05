package seleniumExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tooltipmsgandmethodsinselenum {

	
	WebDriver driver;
	String Browser="edge";
	@Test
	public void testCase1() throws Throwable{
		SoftAssert st=new SoftAssert();
		if(Browser.equalsIgnoreCase("chrome")){
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--incognito");
			driver=new ChromeDriver(option);//openBrowser
		}
		else if(Browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
	
		driver.get("https://www.rediff.com/"); //openurl
		driver.manage().window().maximize(); // maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Home page title ="+driver.getTitle());
		//click on signin
		driver.findElement(By.linkText("Sign in")).click(); //Login page
		Thread.sleep(3000);
		System.out.println("Login page title ="+driver.getTitle());
		//navigate back to home page
		driver.navigate().back(); //Homepage
		Thread.sleep(3000);
		//naviage forward to login page
		driver.navigate().forward(); // Login page
		Thread.sleep(3000);
		driver.findElement(By.id("login1")).sendKeys("tester");
		//driver.navigate().refresh(); //Refresh
		driver.get(driver.getCurrentUrl()); //Refresh
		
		driver.navigate().to("https://www.drikpanchang.com/");
		
		String tooltipmsg = driver.findElement(By.xpath("/html/body/div[3]/div[3]/a[1]/img")).getAttribute("alt");
		System.out.println("Tool tip msg ="+tooltipmsg);
		driver.navigate().back();
		
		//driver.manage().deleteAllCookies();
		
		driver.quit();
}


}
