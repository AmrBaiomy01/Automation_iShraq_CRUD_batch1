package CRUDTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.CorporateFinanciersCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CorporateFinanciersCRUDTest"})
public class CorporateFinanciersCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "15002732";
	String ParentframeID="frame_15002732";
	String filterAreaFrame="parentModuleID15002732";
	//Filling Data
	
	String FirstValue = "AAATTTT";

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

	//@Test (dependsOnMethods = {"CheckLogin"})
	@Test(dependsOnGroups= {"CompaniesCRUDTest"})
	public void checkFilterArea() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		CorporateFinanciersCRUDPage moduleHandlerObj = new CorporateFinanciersCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.fillDataToGrid(FirstValue);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);
	}

	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CorporateFinanciersCRUDPage moduleHandlerObj = new CorporateFinanciersCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();
	
	}

}
