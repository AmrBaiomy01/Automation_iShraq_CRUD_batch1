package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import Pages.FundPage;
import Pages.LoginPage;
import Pages.SettlementPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

public class FundTest extends TestBase {


	FundPage fundPageObj;
	SettlementPage settlePage;

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};


	String FundName = "bbc-cnn-automated-script22";
	String CreationDate = "01/01/2019";
	String MaturityDate = "01/01/2020";
	String CurrencyName = "EGP";
	String RequiredDonorCode = "201";
	String RequiredContributorAmo = "100000";
	String classCodeNumber = "1000";
	String classPercentageAmount = "100";
	String ParentframeID = "frame_15002003";
	String SubFramesID = "parentModuleID15002003";
	String SettlementFrame = "frame_108";
	//create two var of already posted fund code and donor code from checkAddFund() TC
	String postedFundCode;
	String postedDonorCode;


	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{

		JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

	@Test (dependsOnMethods = {"CheckLogin"})	
	public void checkAddFund() throws InterruptedException, IOException 
	{

		fundPageObj = new FundPage(driver);
		fundPageObj.openFundMocule(FundName, CreationDate, MaturityDate,ParentframeID,SubFramesID, CurrencyName, RequiredDonorCode, RequiredContributorAmo,classCodeNumber,classPercentageAmount);
		//retreieve the fund code generated and pass it to postedFundCode variable then pass it as paramater to the needed TC
		postedFundCode = FundPage.actualFundCode;
	}


	
	@Test (dependsOnMethods = {"checkAddFund"})
	public void checkSettlement() throws InterruptedException
	{
		settlePage = new SettlementPage(driver);
		System.out.println("Posted Fund Code: " + postedFundCode);
		settlePage.checkSettlement(SettlementFrame,postedFundCode);
	}
	


}
