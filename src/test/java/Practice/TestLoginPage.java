package Practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLoginPage {

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

	@Test(dataProvider = "testdata")
	public void Testloginpage(String username, String password) throws Throwable {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		// login
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
		// driver closing
		Thread.sleep(2000);
		driver.quit();

	}

	@DataProvider
	public Object testdata() throws Throwable {

		File file = new File("LoginPage.xlsx");

		FileInputStream xlreader = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(xlreader);

		Sheet sheet = wb.getSheet("Login");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		Object obj[][] = new Object[rowCount][colcount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = sheet.getRow(i).getFirstCellNum(); j < sheet.getRow(i).getLastCellNum(); j++) {

				DataFormatter dataFormatter = new DataFormatter();

				String formatCellValue = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));

				obj[i - 1][j] = formatCellValue;
			}
		}

		return obj;

	}


}
