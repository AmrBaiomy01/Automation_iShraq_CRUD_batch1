package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import TestData.JsonDataReaderOnPage;
import TestData.JsonDataWriterOnPage;
import Tests.TestBase;

public class LoginTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String JsonWriterFile = System.getProperty("user.dir") + "/src/test/java/TestData/WriteData.json";
	

	@Test (priority = 0) 
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

		JsonDataWriterOnPage jsonFileWriter = new JsonDataWriterOnPage();
		String [] x = {"adminstartor"};
		String [] y = {"admin12"};
		jsonFileWriter.JsonWriteData(JsonWriterFile, "LoginData", x, y);
	
	}
	

}
