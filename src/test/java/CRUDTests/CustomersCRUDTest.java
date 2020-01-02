package CRUDTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.CustomersCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CustomersCRUDTest"})
public class CustomersCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "1500271";
	String ParentframeID="frame_1500271";
	String filterAreaFrame="parentModuleID1500271";


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

	//@Test(dependsOnGroups = {"CustomerScoringAttributesCRUDTest"})
	/*@Test(dependsOnMethods= {"CheckLogin"})
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
	}*/
	
	/*@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		CustomerTitlesCRUDPage moduleHandlerObj = new CustomerTitlesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}*/
	
	@Test(dependsOnGroups= {"CustomerScoringAttributesCRUDTest"})
	public void checkFilterArea() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		CustomersCRUDPage moduleHandlerObj = new CustomersCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);
	}

	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CustomersCRUDPage moduleHandlerObj = new CustomersCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();
	}


}
