package CRUDTests;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import CRUDPages.RegionsCRUDPage;
import Pages.LoginPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"RegionsCRUDTest"})
public class RegionsCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "44";
	String ParentframeID="frame_44";
	String filterAreaFrame="parentModuleID44";



	//Updating data
	String NameValue="Regions CRUD Update";

	public String ActualSectorCode;

	@FindBy (id = "SEC_CODE")WebElement sectorCode;


	@Test (priority = 0)
	public void CheckLogin() 
			throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

  	@Test(dependsOnGroups = {"DocumentTypesCRUDTest"}) 	
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		RegionsCRUDPage moduleHandlerObj = new RegionsCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		RegionsCRUDPage moduleHandlerObj = new RegionsCRUDPage(driver);
		moduleHandlerObj.updateData(NameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		RegionsCRUDPage moduleHandlerObj = new RegionsCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		RegionsCRUDPage moduleHandlerObj = new RegionsCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}

	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		RegionsCRUDPage moduleHandlerObj = new RegionsCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
