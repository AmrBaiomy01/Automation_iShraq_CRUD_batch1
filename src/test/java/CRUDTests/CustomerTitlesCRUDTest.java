package CRUDTests;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.CustomerTitlesCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CustomerTitlesCRUDTest"})
public class CustomerTitlesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "239";
	String ParentframeID="frame_239";
	String filterAreaFrame="parentModuleID239";


	//Filling Data
	
	String Typevalue = "AMR";
	String MalenameValue = "AAAA";
	String FemaleNameValue= "AABB";

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

	@Test(dependsOnGroups = {"CustomersCRUDTest"})
	//@Test(dependsOnMethods= {"CheckLogin"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		CustomerTitlesCRUDPage moduleHandlerObj = new CustomerTitlesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.fillDataToGrid(MalenameValue, FemaleNameValue, Typevalue);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		CustomerTitlesCRUDPage moduleHandlerObj = new CustomerTitlesCRUDPage(driver);
		moduleHandlerObj.updateData(updateNameValue);
	}
	
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		CustomerTitlesCRUDPage moduleHandlerObj = new CustomerTitlesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		CustomerTitlesCRUDPage moduleHandlerObj = new CustomerTitlesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}

	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CustomerTitlesCRUDPage moduleHandlerObj = new CustomerTitlesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
