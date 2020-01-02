package CRUDTests;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import CRUDPages.CurrenciesCRUDPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"CurrenciesCRUDTest"})
public class CurrenciesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "19";
	String ParentframeID="frame_19";
	String filterAreaFrame="parentModuleID19";


	//Filling Data
	String codeValue="0asf" ;
	String ISOCodeValue="MMAA";
	String latinNameValue="CurreCRUD";
	String otherNameValue="CurCRUDAMR";
	String MinorNameValue="3";
	String MUValue="CRUD";

	//Updating data
	String updateNameValue ="CurCRUDAMRUpdate";

	public String ActualSectorCode;

	//@FindBy (id = "SEC_CODE")WebElement sectorCode;


	/*@Test (priority = 0)
	public void CheckLogin()
			throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/

	@Test(dependsOnGroups = {"CorporateFinanciersCRUDTest"})
	//@Test (dependsOnMethods= {"CheckLogin"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		CurrenciesCRUDPage moduleHandlerObj = new CurrenciesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.fillDataToGrid(codeValue, ISOCodeValue, latinNameValue,
				otherNameValue, MinorNameValue, MUValue);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		CurrenciesCRUDPage moduleHandlerObj = new CurrenciesCRUDPage(driver);
		moduleHandlerObj.updateData(updateNameValue);
	}
	
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		CurrenciesCRUDPage moduleHandlerObj = new CurrenciesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	
	@Test (dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		CurrenciesCRUDPage moduleHandlerObj = new CurrenciesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}

	@Test (dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CurrenciesCRUDPage moduleHandlerObj = new CurrenciesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();
	}
}
