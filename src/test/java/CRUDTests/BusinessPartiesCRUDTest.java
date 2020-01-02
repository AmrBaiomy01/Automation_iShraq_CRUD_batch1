package CRUDTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.BUSINESSPARTIESCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"BusinessPartiesCRUDTest"})
public class BusinessPartiesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "150032";
	String ParentframeID="frame_150032";
	String filterAreaFrame="parentModuleID150032";


	//Filling Data
	
	String Typevalue = "M";
	String MalenameValue = "AAAA";
	String FemaleNameValue= "AAAABBBB";

	//Updating data
	String updateNameValue= "Customers CRUD Update";

	/*@Test (priority = 0)
	public void CheckLogin() 
			throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/

	
	@Test(dependsOnGroups = {"AnnualIncomeCRUDTest"})
	public void checkFilterArea() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		BUSINESSPARTIESCRUDPage moduleHandlerObj = new BUSINESSPARTIESCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);
		
	}

	@Test (dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		BUSINESSPARTIESCRUDPage moduleHandlerObj = new BUSINESSPARTIESCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
