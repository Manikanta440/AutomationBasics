package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Propertiesjavaclass {

	@Test
	public void ReadProperies() throws FileNotFoundException, IOException {
		Properties prop =new Properties();
		prop.load(new FileInputStream("src\\test\\java\\properties\\Application.properties"));
		
		System.out.println(prop.getProperty("browser"));
	}
	

}
