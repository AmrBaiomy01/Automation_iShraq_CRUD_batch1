package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductSetupPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test (groups = { "ProductSetupTest"})
public class ProductSetupTest extends TestBase {

	//Master Data

	String jsonFilePath = "/src/test/java/TestData/Login.json";

	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	ProductSetupPage productSetupObj;
	String productsetupTypeValue = "R";
	String ClassCodevalue = "1000";
	String Namevalue = "TestcompositerulesA,B&D";
	String curCode = "USD";
	String DateValue = "01/01/2018";

	//Repayment Data

	String repaymentcode="937";

	//Business Rules

	//String Rulecode = "61";
	//String RuleActionValue1="APP";
	String ProductFactor="MAXT";
	String ValueTypeValue="FIX";

	//OverRide
	String ProdFactValue="MAXT";
	String OverRideOptionsValue="MIN";

	//Switches between frames
	String ParentframeID = "frame_150082";
	String SubFramesID = "parentModuleID150082";
	public static String ProductCode;

	String [] jRuleskeys = {"Employment Salary Approv", "Employment Salary Reje", "Table B_Approve", "Table B_Reje", "Fin Amount Up To 3000"};
	String [] RulesTestCaseInputs = {"Employment Salary Approv", "Employment Salary Reje", "Table B_Approve", "Table B_Reje", "Fin Amount Up To 3000"};

	String [] jActionskeys = {"Salary Approv", "Salary Reje", "B_Approve","B_Reje","Up To 3000"};
	String [] ActionsTestCaseInputs = {"Salary Approv", "Salary Reje", "B_Approve","B_Reje","Up To 3000"};

	JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();

	/*@Test (priority = 0)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath,"CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);
	}*/

	@Test (dependsOnGroups = {"IndividualProspectTest"})
	//@Test (dependsOnMethods = {"CheckLogin"})
	public void FillData() throws InterruptedException, IOException, ParseException
	{
		productSetupObj = new ProductSetupPage(driver);
		//System.out.println("x" + BusinessRulesPage.ActualRuleCode);

		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs "Rules"
		Hashtable<String,String> jRulesData = jsonFileReader.JsonReaderData(jsonFilePath,"Rules" , jRuleskeys, RulesTestCaseInputs);

		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs "RulesActions"
		Hashtable<String,String> jActionsData = jsonFileReader.JsonReaderData(jsonFilePath,"RulesActions" , jActionskeys, ActionsTestCaseInputs);
		
		productSetupObj.ProductSetupModule(productsetupTypeValue, ClassCodevalue,curCode, DateValue, Namevalue, ParentframeID, SubFramesID, repaymentcode);
		productSetupObj.BusinessRule1(SubFramesID, jRulesData, jActionsData, ProductFactor, ParentframeID);
		productSetupObj.BusinessRule2(SubFramesID, jRulesData, jActionsData, ProductFactor, ParentframeID);
		productSetupObj.BusinessRule3(SubFramesID, jRulesData, jActionsData, ProductFactor, ParentframeID);
		productSetupObj.BusinessRule4(SubFramesID, jRulesData, jActionsData, ProductFactor, ParentframeID);
		productSetupObj.BusinessRuleD(SubFramesID, jRulesData, jActionsData, ProductFactor, ValueTypeValue, ParentframeID);
		//productSetupObj.OverRideTab(ProdFactValue, OverRideOptionsValue);
	}

	@Test (dependsOnMethods = {"FillData"})
	public void SaveProductSetup() throws InterruptedException {

		productSetupObj.SaveButton();

		//Call Product Code
		ProductCode=ProductSetupPage.ActualProductCode;
		System.out.println(ProductCode);


	}

	@Test (dependsOnMethods = {"SaveProductSetup"})
	public void PostButton() throws InterruptedException {

		productSetupObj.PostButton();
	}

}
