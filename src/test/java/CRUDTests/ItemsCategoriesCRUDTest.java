package CRUDTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.ItemsCategoriesCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CustomerTitlesCRUDTest"})
public class ItemsCategoriesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "150012";
	String ParentframeID="frame_150012";
	String filterAreaFrame="parentModuleID150012";


	//Filling Data
	
	String FirstValue = "Items Categories CRUD";

	//Updating data
	String latinNameValue= "Items Categories CRUD Update";

	/*@Test (priority = 0)
	public void CheckLogin()
			throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}


	@Test (priority=1)
	public void checkDeleteTestCase() throws InterruptedException
	{
		CATEGORIESCRUDPage moduleHandlerObj = new CATEGORIESCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	
	
	@Test(priority = 2)
	public void checkFilterArea() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		CATEGORIESCRUDPage moduleHandlerObj = new CATEGORIESCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.fillDataToGrid(FirstValue);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);
		
	}

	@Test(priority = 3)
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CATEGORIESCRUDPage moduleHandlerObj = new CATEGORIESCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();
	}

}*/
	@Test (priority = 1)
	public void CheckLogin() 
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}
	
	@Test (dependsOnMethods = {"CheckLogin"})	
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		ItemsCategoriesCRUDPage moduleHandlerObj = new ItemsCategoriesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		ItemsCategoriesCRUDPage moduleHandlerObj = new ItemsCategoriesCRUDPage(driver);
		moduleHandlerObj.updateData(latinNameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"},priority=4)
	public void checkDeleteTestCase() throws InterruptedException
	{
		ItemsCategoriesCRUDPage moduleHandlerObj = new ItemsCategoriesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"},priority=5)
	public void checkFilterArea() throws InterruptedException {
		ItemsCategoriesCRUDPage moduleHandlerObj = new ItemsCategoriesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"},priority=6)
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		ItemsCategoriesCRUDPage moduleHandlerObj = new ItemsCategoriesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}
}