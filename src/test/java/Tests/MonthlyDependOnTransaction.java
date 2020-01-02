package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.RepaymentPlanTemplatesPage;
import TestData.JsonDataReaderOnPage;
import Tests.TestBase;

@Test(groups = {"MonthlyDependOnTransaction"})
public class MonthlyDependOnTransaction extends TestBase {

	//String parentFrame= "frame_150017";

	//Global Variables
	WebDriver driver1;
	//For Login
	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	//Object from Repayment Plan Page
	RepaymentPlanTemplatesPage RepaymentPlanTemplatesObj;

	String DateValue="01012018";
	String PeriodBase="M";
	String ReptDescriptionString= "Monthly+PresentValue+Fixed+DependOnTransaction";
	String RoundToNeares="2";
	String parentFrameValue="frame_150017";
	String subFrameValue="parentModuleID150017";
	String RepaymentPlanModID= "150017";
	String SettlmentType="CASH";
	String ProfitRecognition="A";
	String RemainingValueLocation="F";

	// Repayment Plan Options Parameters
	String MinTuner="2";
	String MaxTuner="24";
	String collectionPriority="RR";
	
	//Profit Rate Parameters
	String PresentValue="1";
	String Diminishing="2";
	String Straight="3";
	String AllStraight="4";
	String profitPeriodNo="12";
	
	//Intervals Parameters 
	String UpTo="24";
	//AT Parameters
	String LastDay="T";	
	String SpecificDay="F";
	String MonthOnValue="5";
	String WeekOnValue="3";
	String OnDayValue="1";	
	String DependOnTransaction="R";
	String IgnorWeekEnd="I";
	String IgnorVacation="I";
	String PrincipalAndProfit="PNP";
	String Fixed="FI";
	String percentage="10";
	String Ratio="100";
	
	
	//Frames
	String ParentFrame="frame_150017";
	String SubFrame="parentModuleID150017";
	String SubFrame2="parentModuleID1500172";
	
	public String repaymentPlanCode;
	
	JsonDataReaderOnPage jsonFileReader = new JsonDataReaderOnPage();

	@Test (priority = 0)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{

		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);
		
	}
	@Test (dependsOnMethods = {"CheckLogin"})
	public void OpenRepaymentPlanModule() throws InterruptedException 
	{
		RepaymentPlanTemplatesObj= new RepaymentPlanTemplatesPage(driver);
		RepaymentPlanTemplatesObj.OpenRepaymentPlanTemplates(parentFrameValue, RepaymentPlanModID);
	}
	@Test(dependsOnMethods = {"OpenRepaymentPlanModule"})
	public void fillRepaymentPlanMasterData() throws InterruptedException {
		RepaymentPlanTemplatesObj= new RepaymentPlanTemplatesPage(driver);
		RepaymentPlanTemplatesObj.InsertMasterData(DateValue, PeriodBase,
				               ReptDescriptionString,subFrameValue,
				               RoundToNeares, SettlmentType, ProfitRecognition,
				               RemainingValueLocation,parentFrameValue);

	}
	@Test (dependsOnMethods = {"fillRepaymentPlanMasterData"})
	public void fillRepaymentsOptionsData()
	{
		RepaymentPlanTemplatesObj= new RepaymentPlanTemplatesPage(driver);
		RepaymentPlanTemplatesObj.InsertRepaymentsOptionsData(MinTuner, MaxTuner, collectionPriority);
	}
	@Test (dependsOnMethods = {"fillRepaymentsOptionsData"})
	public void fillProfitRateData()
	{
		RepaymentPlanTemplatesObj.InsertProfitRateData(PresentValue, profitPeriodNo);
	}
	
	@Test(dependsOnMethods = {"fillProfitRateData"})
	public void fillIntervalsDataWithSpecificDay() throws InterruptedException 
	/*{
		RepaymentPlanTemplatesObj.InsertIntervalsDataWithSpecificDay(UpTo, subFrameValue,
				SubFrame2, SpecificDay, MonthOnValue,OnDayValue, IgnorWeekEnd,PrincipalAndProfit, 
				Fixed, percentage, Ratio, ParentFrame);
	}*/
	{
		RepaymentPlanTemplatesObj.InsertIntervalsData(UpTo, SubFrame, SubFrame2, DependOnTransaction,
				IgnorWeekEnd, IgnorVacation, PrincipalAndProfit, Fixed, percentage, Ratio, ParentFrame);
		repaymentPlanCode = RepaymentPlanTemplatesPage.repaymentCode;
			
	}
	
	
}
