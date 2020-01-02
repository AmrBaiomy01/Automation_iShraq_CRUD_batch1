package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	public static Properties repaymentName =loadProperties(System.getProperty("user.dir")+
			"\\src\\test\\java\\Properties\\repaymentDescriptionName.properties");
	
	private static Properties loadProperties(String path)
	{
		Properties propertiesObject= new Properties();
		//Stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			propertiesObject.load(stream);
			
		} catch (FileNotFoundException e) {
			System.out.println("Error1 "+ e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Error2 "+ e.getMessage());
		}
		return propertiesObject;
	}

}
