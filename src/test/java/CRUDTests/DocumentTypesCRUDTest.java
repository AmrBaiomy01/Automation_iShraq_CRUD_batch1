package CRUDTests;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import CRUDPages.DocumentTypesCRUDPage;
import Pages.LoginPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"DocumentTypesCRUDTest"})

public class DocumentTypesCRUDTest extends TestBase {
	
	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "150018";
	String ParentframeID="frame_150018";
	String filterAreaFrame="parentModuleID150018";
	
	//Update_Data
	String updateNameValue = "Amr_CRUD_TEST";
	
	//Start Point
	
	/*@Test (priority = 0)
	public void CheckLogin() 
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/
	
	//@Test (dependsOnMethods= {"CheckLogin"})
	@Test(dependsOnGroups = {"CurrenciesCRUDTest"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		DocumentTypesCRUDPage moduleHandlerObj = new DocumentTypesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	//5-Update 
	public void updateData() throws InterruptedException
	{
		
		DocumentTypesCRUDPage modulehandlerobj = new DocumentTypesCRUDPage(driver);
		modulehandlerobj.updateData(updateNameValue);
	}
	
	@Test (dependsOnMethods= {"updateData"})
	//6- Delete 
	public void deleteData() throws InterruptedException
	{
		DocumentTypesCRUDPage modulehandlerobj = new DocumentTypesCRUDPage(driver);
		modulehandlerobj.deleteData();
	}
	
	@Test (dependsOnMethods= {"deleteData"})
	//7- Open filter area and filter by any record
	public void filterByRecords()
			throws InterruptedException {
	
		DocumentTypesCRUDPage modulehandlerobj = new DocumentTypesCRUDPage(driver);
		modulehandlerobj.filterByRecords(filterAreaFrame, ParentframeID);
	}
	
	@Test (dependsOnMethods= {"filterByRecords"})
	// 8- Retrieve All and Paging
	public void retrieveAllAndPaging() throws InterruptedException {
		
		DocumentTypesCRUDPage modulehandlerobj = new DocumentTypesCRUDPage(driver);
		modulehandlerobj.retrieveAllAndPaging();
	}
}