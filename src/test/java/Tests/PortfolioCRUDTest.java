package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.PortfoliosModuleHandler;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

public class PortfolioCRUDTest extends TestBase {
	
	String moduleID = "24";
	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	

	
	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}
	
	@Test (dependsOnMethods = {"CheckLogin"})	
	public void CheckSaveTestCase () throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		PortfoliosModuleHandler moduleHandlerObj = new PortfoliosModuleHandler(driver);
		moduleHandlerObj.FillModuleFields(moduleID);
		
		//ActualSectorCode = sectorCode.getAttribute("Value");
		
	}
	

}
