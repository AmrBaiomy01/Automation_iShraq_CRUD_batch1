package CRUDTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import CRUDPages.CompaniesCRUDPage;
import Pages.LoginPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CompaniesCRUDTest"})
public class CompaniesCRUDTest extends TestBase{

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "1500300";
	String ParentframeID="frame_1500300";
	String filterAreaFrame="parentModuleID1500300";
	
	
	
	//Updating data
	String latinNameValue="CRUD Companies Update";
	
	public String ActualSectorCode;
	
	@FindBy (id = "SEC_CODE")WebElement sectorCode;
	
	
	/*@Test (priority = 0)
	public void CheckLogin() 
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/
	
  	@Test(dependsOnGroups = {"CommitteesMeetingsCRUDTest"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		CompaniesCRUDPage moduleHandlerObj = new CompaniesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		CompaniesCRUDPage moduleHandlerObj = new CompaniesCRUDPage(driver);
		moduleHandlerObj.updateData(latinNameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		CompaniesCRUDPage moduleHandlerObj = new CompaniesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		CompaniesCRUDPage moduleHandlerObj = new CompaniesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CompaniesCRUDPage moduleHandlerObj = new CompaniesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}

}
