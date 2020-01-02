package Pages;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FundPage extends PageBase {

	public FundPage(WebDriver driver)

	{
		super(driver);
		driver1 = driver;
	}

	//public static WebDriver driver1;
	WebDriver driver1;

	String moduleID = "15002003";
	String settlementModule = "108";


	@FindBy (css = "#\\31 5002003 > div > span")
	WebElement actualModule;

	@FindBy (id = "txt_PlaceHolder")
	WebElement searchBox;

	@FindBy (id = "FFUND_NAME")
	WebElement fundName; 

	@FindBy (id = "FFUND_CRT_DT")
	WebElement fundCreationDate;

	@FindBy (id = "FFUND_MAT_DT")
	WebElement fundMaturityDate;

	@FindBy (id = "CUR_CODE_lovImage")
	WebElement currencyLOVIcon;

	@FindBy (id = "advancedFilter")
	WebElement curQuickSearch;

	@FindBy (css = "#filtergrid > div.k-grid-content > table > tbody > tr")
	WebElement curSearchResult;

	@FindBy (id = "CUR_CODE")
	WebElement curCodeBox;

	@FindBy (id = "V1TC_V7TP_V7AddButton")
	WebElement addNewDonor;

	@FindBy (id = "CUS_CODE_lovImage")
	WebElement donorCodeLOV;

	@FindBy (id = "V1TC_V7TP_V7LCRepeater_ctl00_CUS_CODE")
	WebElement donorCode;

	public static String actualDonorCode; 

	@FindBy (id = "V1TC_V7TP_V7LCRepeater_ctl00_FCNT_AMT")
	WebElement contributingAmo;

	@FindBy (id = "__tab_V1TC_V14TP")
	WebElement productClassTab;

	@FindBy (id = "V1TC_V14TP_V14LCRepeater_ctl00_PCL_CODE")
	WebElement classCode;

	@FindBy (id = "V1TC_V14TP_V14LCRepeater_ctl00_FPCLS_PERC")
	WebElement classPercentage;

	@FindBy (id = "V1TC_V14TP_V14AddButton")
	WebElement addNewProductClass;

	@FindBy (id = "SaveButton__Button")
	WebElement saveData;

	@FindBy (id = "V1ApproveButton")
	WebElement approveData;

	@FindBy (id = "ddlAppliedWorkflows")
	WebElement workFlowitems;

	@FindBy (id = "SaveButton")
	WebElement saveWorkflow;

	@FindBy (id = "V1TC_V0TP_WD_DECISION")
	WebElement approvalDecision;

	@FindBy (id = "SaveButton__Button")
	WebElement saveWorkflowDecision;

	@FindBy (id = "V1POSTButton")
	WebElement postRecord;

	@FindBy (id = "FFUND_CODE")
	public WebElement fundCode;

	public static String actualFundCode;

	@FindBy(id = "APPROVAL_STATUS")
	public WebElement approvalStatus;

	//String currentApprovalStatus = approvalStatus.getText();

	@FindBy (id = "V4Pagination__LastPage")
	WebElement getLastPage;

	@FindBy (id = "V4TC_V3TP_V3LCRepeater_ctl00_CST_TRX_CODE")
	WebElement getTransNumber;

	@FindBy (id = "V4POSTButton")
	WebElement postSettlement;

	@FindBy (id = "CS_STATUS")
	WebElement settleStatus;

	@FindBy (id = "#tabs-15002003 > a > span.tabTitle")
	WebElement programScreen;

	//main frame frame_15002003
	//sub frame parentModuleID15002003

	public void openFundMocule(String fundNameDetails ,
			String creationDate ,
			String matuarityDate,
			String ParentframeID,
			String SubFramesID,
			String curCode,
			String requiredDonorCode,
			String requiredContributorAmo,
			String classCodeNumber ,
			String classPercentageAmount) 
			throws InterruptedException, IOException
	{

		Thread.sleep(7000);
		searchBox.sendKeys(moduleID);
		waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		waitMethod(7);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		Thread.sleep(5000);
		switchFrame(ParentframeID);

		waitMethod(7);

		setTextElementText(fundName, fundNameDetails);
		setTextElementText(fundCreationDate, creationDate);
		setTextElementText(fundMaturityDate, matuarityDate);

		//setTextElementText(curCodeBox, curCode);
		waitMethod(3);
		clickButton(currencyLOVIcon);
		switchFrame(SubFramesID);
		waitMethod(3);
		setTextElementText(curQuickSearch, curCode);
		Thread.sleep(5000);
		DoubleClickonElement(curSearchResult);

		switchFrame(ParentframeID);
		waitMethod(2);
		clickButton(addNewDonor);
		waitMethod(2);
		setTextElementText(donorCode, requiredDonorCode);
		setTextElementText(contributingAmo, requiredContributorAmo);

		waitMethod(3);
		clickButton(productClassTab);
		waitMethod(2);
		clickButton(addNewProductClass);
		Thread.sleep(3000);
		setTextElementText(classCode, classCodeNumber);
		setTextElementText(classPercentage, classPercentageAmount);
		waitMethod(2);
		clickButton(saveData);
		waitMethod(5);

		//save fund code and donor code to use it in settlement
		Thread.sleep(5000);
		actualFundCode = StoreData(fundCode);
		Thread.sleep(5000);
		actualDonorCode = StoreData(donorCode);
		System.out.println("Actual Fund Code: " + actualFundCode);
		//System.out.println(actualDonorCode);

		Thread.sleep(7000);
		clickButton(approveData);
		waitMethod(3);

		switchFrame(SubFramesID);
		Thread.sleep(3000);
		DropListSelect(workFlowitems, "601");

		Thread.sleep(5000);
		clickButton(saveWorkflow);
		Thread.sleep(5000);
		switchFrame(ParentframeID);
		clickButton(approveData);

		waitMethod(3);

		switchFrame(SubFramesID);
		DropListSelect(approvalDecision, "APP");
		Thread.sleep(3000);
		clickButton(saveWorkflowDecision);

		waitMethod(3);

		switchFrame(ParentframeID);
		clickButton(postRecord);
		waitMethod(5);
		ConfirmAlert();
		waitMethod(5);

	}

}
