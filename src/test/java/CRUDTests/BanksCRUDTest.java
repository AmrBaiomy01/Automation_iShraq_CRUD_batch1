package CRUDTests;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import CRUDPages.BanksCRUDPage;
import Pages.LoginPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"BanksCRUDTest"})
public class BanksCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "15002423";
	String ParentframeID="frame_15002423";
	String filterAreaFrame="parentModuleID15002423";
	
	
	
	//Updating data
	String latinNameValue="CRUD_Banks_Update";
	
	public String ActualSectorCode;
	
	@FindBy (id = "SEC_CODE")WebElement sectorCode;
	
	
	/*@Test (priority = 1)
	public void CheckLogin() 
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/
	
	//@Test(dependsOnGroups = {"BusinessPartiesCRUDTest"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		BanksCRUDPage moduleHandlerObj = new BanksCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		BanksCRUDPage moduleHandlerObj = new BanksCRUDPage(driver);
		moduleHandlerObj.updateData(latinNameValue);
	}
	
	@Test (dependsOnMethods= {"checkUpdateTestCase"},priority=4)
	public void checkDeleteTestCase() throws InterruptedException
	{
		BanksCRUDPage moduleHandlerObj = new BanksCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	
	@Test(dependsOnMethods= {"checkDeleteTestCase"},priority=5)
	public void checkFilterArea() throws InterruptedException {
		BanksCRUDPage moduleHandlerObj = new BanksCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"},priority=6)
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		BanksCRUDPage moduleHandlerObj = new BanksCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
