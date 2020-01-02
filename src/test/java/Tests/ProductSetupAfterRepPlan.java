package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.ProductSetupPage;
import Pages.RepaymentPlanTemplatesPage;

@Test(groups = {"ProductSetupAfterRepPlan"})
public class ProductSetupAfterRepPlan extends TestBase {
	
	ProductSetupPage productSetupObj;
	
	//Master Data
	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	String productsetupTypeValue = "R";
	String ClassCodevalue = "1000";
	String Namevalue = "TestProductSetupCrud";
	String curCode = "OMR";
	String DateValue = "01/01/2018";
	
	//Repayment Data
	RepaymentPlanTemplatesPage repaymentPlanObj = new RepaymentPlanTemplatesPage(driver);
	//MonthlyDependOnTransaction MonthlyDependOnTransactionobj = new MonthlyDependOnTransaction();
	
	
	//String repaymentcode="1060";
	//Business Rules
	
	String Rulecode = "3";
	String RuleActionValue="APP";
	String ProductFactor="MAXT";
	
	//OverRide
	String ProdFactValue="MAXT";
	String OverRideOptionsValue="MIN";
		
	//Switches between frames
	String ParentframeID = "frame_150082";
	String SubFramesID = "parentModuleID150082";

	public String repaymentcode;
	public static String ProductCode;
	

	@Test(dependsOnGroups = {"MonthlyDependOnTransaction"}) 
	public void FillData() throws InterruptedException, IOException
	{
		repaymentcode = MonthlyDependOnTransactionTest.repaymentPlanCode;
		System.out.println(repaymentcode);
		productSetupObj = new ProductSetupPage(driver);
		System.out.println("the repayment plan code is " + repaymentcode );
		//productSetupObj.ProductSetupModuleCrud(productsetupTypeValue, ClassCodevalue ,curCode,DateValue, Namevalue, ParentframeID, SubFramesID, repaymentcode);
		productSetupObj.ProductSetupModule(productsetupTypeValue, ClassCodevalue, curCode,
				DateValue, Namevalue, ParentframeID, SubFramesID, repaymentcode);
		//productSetupObj.BusinessRules(SubFramesID, Rulecode, RuleActionValue, ProductFactor, ParentframeID);
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
