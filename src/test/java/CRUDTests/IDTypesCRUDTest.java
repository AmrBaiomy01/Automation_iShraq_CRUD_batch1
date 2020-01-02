package CRUDTests;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import CRUDPages.IDTypesCRUDPage;
import Pages.LoginPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"IDTypesCRUDTest"})
public class IDTypesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "6523";
	String ParentframeID="frame_6523";
	String filterAreaFrame="parentModuleID6523";
	
	
	//Updating data
	String latinNameValue="CRUD_IDTypes_Update";
	
	//public String ActualSectorCode;
	
	//@FindBy (id = "SEC_CODE")WebElement sectorCode;
	
	
	/*@Test (priority = 0)
	public void CheckLogin() 
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/
	
  	@Test(dependsOnGroups = {"DocumentTypesCRUDTest"})
	//@Test (dependsOnMethods = {"CheckLogin"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		IDTypesCRUDPage moduleHandlerObj = new IDTypesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		IDTypesCRUDPage moduleHandlerObj = new IDTypesCRUDPage(driver);
		moduleHandlerObj.updateData(latinNameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		IDTypesCRUDPage moduleHandlerObj = new IDTypesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		IDTypesCRUDPage moduleHandlerObj = new IDTypesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		IDTypesCRUDPage moduleHandlerObj = new IDTypesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
