package actionskeyword;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DragAndDrop {
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
	
		driver.get("https://jqueryui.com/droppable/"); //openurl
		driver.manage().window().maximize(); // maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//switch driver ref to frame
		driver.switchTo().frame(0);
		//Drag and drop
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement tar = driver.findElement(By.id("droppable"));
		
		Actions action=new Actions(driver);
		//action.dragAndDrop(src, tar).build().perform();
		action.clickAndHold(src).moveToElement(tar).release().build().perform();
}



}
