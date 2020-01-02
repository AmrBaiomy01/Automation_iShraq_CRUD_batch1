package CRUDTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.IndividualGuarantorsCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CustomerTitlesCRUDTest"})
public class IndividualGuarantorsCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "15002721";
	String ParentframeID="frame_15002721";
	String filterAreaFrame="parentModuleID15002721";


	//Filling Data
	
	String FirstValue = "AAaUpdateTT";

	//Updating data
	String updateNameValue= "Customers CRUD Update";

	@Test (priority = 0)
	public void CheckLogin() 
			throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

	
	@Test (priority = 1) //(dependsOnMethods= {"CheckLogin"})
	public void checkFilterArea() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		IndividualGuarantorsCRUDPage moduleHandlerObj = new IndividualGuarantorsCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.fillDataToGrid(FirstValue);
				
	}
	
	@Test (priority = 2) //(dependsOnMethods= {"checkFilterArea"})
	public void checkdelete() throws InterruptedException {
		IndividualGuarantorsCRUDPage moduleHandlerObj = new IndividualGuarantorsCRUDPage(driver);
		moduleHandlerObj.delete();
		
	}

	@Test (priority = 3) //(dependsOnMethods= {"checkdelete"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		IndividualGuarantorsCRUDPage moduleHandlerObj = new IndividualGuarantorsCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);
		moduleHandlerObj.retrieveAllAndPaging();
	}


}
