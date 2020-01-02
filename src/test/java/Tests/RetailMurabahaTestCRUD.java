package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductSetupPage;
import Pages.RetailMurabahaPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;


//@Test (groups = { "RetailMurabahaTest"})
public class RetailMurabahaTestCRUD extends TestBase {

	
	//object from product setup testcase to call generated product code
	//ProductSetupTest productSetupObj = new ProductSetupTest();
	
	
	//Objects from RetailMurabahaPage
	
	
	RetailMurabahaPage RetailMurabahaObject ;
	//Global Variables
	WebDriver driver1;
	//For Login
	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	//For Retail Murabaha Filling  Data
	String RequestedDate = "01012018";
	String ValueDate ="01022018";
	//String CustomerID="194";
	
	//String Cust1="M_004_Appr";
	//String Cust2="F_004_Appr";
	//String Cust3="M_002_Appr";
	//String Cust4="F_002_Appr";
	//String Cust5="M_010_Appr";
	//String Cust6="F_010_Appr";
	//String Cust7="M_007_Appr";
	//String Cust8="F_007_Appr";
	//String Cust9="M_003_Reje";
	
	//ProductCodeID="514">>two rules on the product
	String ProductCodeID="Medo#1234514";
	String NonListedVendor="Non Listed Item";
	String CurrencyCode="EGP";
	String ItemName="Test Item";
	String ItemCategory="47";
	String Price ="10000";
	String Cost="12000";
	String ParentframeID = "frame_1500900011";
	String SubFramesID = "parentModuleID1500900011";
	
	String RetailMurabahamoduleID= "1500900011";
	
	String RMurabahaCode;

	String [] jCustomerkeys = {"M_004_Appr", "F_004_Appr", "M_002_Appr", "F_002_Appr", "M_010_Appr", "F_010_Appr", "M_007_Appr", "F_007_Appr", "BBC_M_003_Reje" };
	String [] customerTestCaseInputs = {"M_004_Appr", "F_004_Appr", "M_002_Appr", "F_002_Appr", "M_010_Appr", "F_010_Appr", "M_007_Appr", "F_007_Appr", "BBC_M_003_Reje" };
	
	
	JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();

	@Test (priority = 0)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

	@Test(dependsOnMethods = {"CheckLogin"})
	public void CheckOpenRetailMurabah() throws InterruptedException {
	
		RetailMurabahaObject = new RetailMurabahaPage(driver);
		RetailMurabahaObject.OpenRetailMurabahaCrud(ParentframeID, RetailMurabahamoduleID);
	}
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah"})
	public void CheckInsertAllMandatoryFieldsA() throws InterruptedException, IOException, ParseException
	{
		//System.out.println("x" + ProductSetupPage.ActualProductCode);
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData(jsonFilePath, "Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer1(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
	}
	

	/*
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsA"})
	public void CheckInsertAllMandatoryFieldsB() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer4(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsB"})
	public void CheckInsertAllMandatoryFieldsD() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer5(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsD"})
	public void CheckInsertAllMandatoryFieldsX() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer9(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	
	
	/*
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsB"})
	public void CheckInsertAllMandatoryFieldsC() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer3(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsC"})
	public void CheckInsertAllMandatoryFieldsD() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer4(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsD"})
	public void CheckInsertAllMandatoryFieldsE() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer5(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsE"})
	public void CheckInsertAllMandatoryFieldsF() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer6(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsF"})
	public void CheckInsertAllMandatoryFieldsG() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer7(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah", "CheckInsertAllMandatoryFieldsG"})
	public void CheckInsertAllMandatoryFieldsH() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jCustomerData = jsonFileReader.JsonReaderData("Customer" , jCustomerkeys, customerTestCaseInputs);
		RetailMurabahaObject.FillRequiredFieldsByCustomer8(RequestedDate, ValueDate, 
															jCustomerData, ProductCodeID,
															NonListedVendor, CurrencyCode,
															ItemName, ItemCategory, Price,
															Cost, ParentframeID,SubFramesID);
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		
	}
	*/

	
}
