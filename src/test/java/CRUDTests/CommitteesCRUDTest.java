package CRUDTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.CommitteesCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CommitteesCRUDTest"})
public class CommitteesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "15004";
	String ParentframeID="frame_15004";
	String filterAreaFrame="parentModuleID15004";
	
	
	
	//Updating data
	String updateNameValue="CRUD_Committee_Update";
	
	public String ActualCommitteeCode;
	
	@FindBy (id = "CMT_CODE")WebElement CommitteeCode;
	
	
	/*@Test (priority = 0)
	public void CheckLogin() 
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/
	
	@Test (dependsOnGroups = {"BusinessPartiesCRUDTest"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		CommitteesCRUDPage moduleHandlerObj = new CommitteesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		
		//ActualCommitteeCode = CommitteeCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		CommitteesCRUDPage moduleHandlerObj = new CommitteesCRUDPage(driver);
		moduleHandlerObj.updateData(updateNameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		CommitteesCRUDPage moduleHandlerObj = new CommitteesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		CommitteesCRUDPage moduleHandlerObj = new CommitteesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CommitteesCRUDPage moduleHandlerObj = new CommitteesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
