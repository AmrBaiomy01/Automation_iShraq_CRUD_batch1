package CRUDTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.CommitteesmeetingsCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CommitteesMeetingsCRUDTest"})
public class CommitteesMeetingsCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "150073";
	String ParentframeID="frame_150073";
	String filterAreaFrame="parentModuleID150073";
	
	
	
	//Updating data
	String update_Committeedate_Value="25082018";
	
	public String ActualCommitteeCode;
	
	@FindBy (id = "CMTT_CODE")WebElement CommitteeCode;
	
	
	/*@Test (priority = 0)
	public void CheckLogin() 
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/
	
	@Test (dependsOnGroups= {"CommitteesCRUDTest"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		CommitteesmeetingsCRUDPage moduleHandlerObj = new CommitteesmeetingsCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		
		//ActualCommitteeCode = CommitteeCode.getAttribute("value");
	}
	@Test(dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		CommitteesmeetingsCRUDPage moduleHandlerObj = new CommitteesmeetingsCRUDPage(driver);
		moduleHandlerObj.updateData(update_Committeedate_Value);
	}
	@Test(dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		CommitteesmeetingsCRUDPage moduleHandlerObj = new CommitteesmeetingsCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test (dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		CommitteesmeetingsCRUDPage moduleHandlerObj = new CommitteesmeetingsCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);
	}
	
	@Test (dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CommitteesmeetingsCRUDPage moduleHandlerObj = new CommitteesmeetingsCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();
	}


}
