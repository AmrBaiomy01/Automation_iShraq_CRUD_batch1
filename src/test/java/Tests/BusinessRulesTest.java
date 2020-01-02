package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessRulesPage;
import Pages.LoginPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

public class BusinessRulesTest extends TestBase {


	//Global Variables
	WebDriver driver1;
	BusinessRulesPage BusinessRulesObject;
	//For Login
	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	//For Business Module Number
	String BusinessRulesModuleID= "2100000031";
	String ParentFrameIDValue="frame_2100000031";
	String SubFrameValue="parentModuleID2100000031";

	//Variables for Condition Builder
	String ModuleIDValue = "15002711";
	String NameValue="Test CompositeRule cycle";
	String FactorTypeValue="Module Fields";
	String AmountValue="Ahmed M G";
	
	// Call Rule Code
	
	public static String ActualRuleCode;
	


	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

	@Test (dependsOnMethods = {"CheckLogin"})
	public void OpenBusinessRules() throws InterruptedException
	{
		BusinessRulesObject = new BusinessRulesPage(driver);
		BusinessRulesObject.OpenBussinessRule(BusinessRulesModuleID,ParentFrameIDValue);
		BusinessRulesObject.InsertAllMandatoryFields(NameValue, ParentFrameIDValue,
				SubFrameValue, ModuleIDValue, FactorTypeValue, AmountValue);

	}
	
	@Test (dependsOnMethods = {"OpenBusinessRules"})
	public void SaveBusinessRules() throws InterruptedException {
		Thread.sleep(2000);
		BusinessRulesObject.CheckSaveBusinessRule();
		Thread.sleep(2000);
		//RuleCode = BusinessRulesPage.ActualRuleCode;
		System.out.println(ActualRuleCode);
		
	}
	

}



