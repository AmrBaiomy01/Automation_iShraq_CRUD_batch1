package CRUDTests;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import CRUDPages.AnnualIncomeCRUDPage;
import Pages.LoginPage;
import Tests.TestBase;
import TestData.JsonDataReaderOnPage;

@Test(groups = {"AnnualIncomeCRUDTest"})
public class AnnualIncomeCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/main/java/testData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	//String moduleID = "2000000142";
	String moduleID = "2000000150";
	String ParentframeID="frame_2000000150";
	String filterAreaFrame="parentModuleID2000000150";


	//Updating data
	String latinNameValue="CRUD_Annual Income_Update";

	//public String ActualSectorCode;

	//@FindBy (id = "SEC_CODE")WebElement sectorCode;


	@Test (priority = 0)
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
		AnnualIncomeCRUDPage moduleHandlerObj = new AnnualIncomeCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		AnnualIncomeCRUDPage moduleHandlerObj = new AnnualIncomeCRUDPage(driver);
		moduleHandlerObj.updateData(latinNameValue);
	}
	@Test(dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		AnnualIncomeCRUDPage moduleHandlerObj = new AnnualIncomeCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test (dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		AnnualIncomeCRUDPage moduleHandlerObj = new AnnualIncomeCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}

	@Test (dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		AnnualIncomeCRUDPage moduleHandlerObj = new AnnualIncomeCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();

	}
	
}
