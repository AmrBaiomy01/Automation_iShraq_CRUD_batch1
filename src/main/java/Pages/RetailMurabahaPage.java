package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetailMurabahaPage extends PageBase {

	public RetailMurabahaPage(WebDriver driver) {
		super(driver);
		driver1=driver;

	}

	//Global Variables
	WebDriver driver1;

	@FindBy (id = "txt_PlaceHolder")WebElement searchBox;

	@FindBy(css="#FCON_CONTRACT_DATE") WebElement RequestedDateTxt;
	@FindBy(css="#FCON_VALUE_DATE")	WebElement ValueDateTxt;
	@FindBy(css="#CUS_CODE")WebElement CustomerIDTxt;
	@FindBy(css="#CUS_NAME")WebElement CustomerNameTxt;
	@FindBy(css="#FPROD_CODE1")WebElement ProductCodeTxt;
	@FindBy(css = "#FPROD_LATIN_NAME") WebElement ProductNameTxt;
	@FindBy(css="#NL_VND_NAME")	WebElement NonListedVendorTxt;
	@FindBy (css="#CUR_CODE2")WebElement CurrencyCodeTxt;
	@FindBy(css="#V18TC_V8TP_V8AddButton")WebElement addNewRowbBtn;
	@FindBy(xpath="//*[@id=\"V18TC_V8TP_V8LCRepeater_ctl00_AddButton\"]")WebElement ViewItemBtn;
	@FindBy(css="#ITE_NAME") WebElement ItemNameTxt;
	@FindBy(id="IC_CODE") WebElement ItemCategoryDropdownSelect;
	@FindBy(css="#ITE_PRICE") WebElement PriceTxt;
	@FindBy(css="#ITE_COST") WebElement CostTxt;
	@FindBy(css="#SaveButton__Button") WebElement SaveAndCloseBtn;

	@FindBy(css="#V18NewButton") WebElement addNewButton;

	@FindBy(css="#V18SaveButton") WebElement MasterSaveBtn;

	@FindBy(css="#FCON_CODE") WebElement ContractCodeTxt;
	//Request for approv

	@FindBy(css= "#V18ApproveButton") WebElement RequestBtn;

	//Status
	@FindBy(css= "#APPROVAL_STATUS_NAME") WebElement StatusTxt;

	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn")
	WebElement saveConfirmationMsg;

	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-footer.text-center > button")
	WebElement saveConfirmationBtn;


	@FindBy(css="#Body1 > div:nth-child(5)")
	WebElement approvalConfirmationMsg;


	@FindBy(css="#Body1 > div:nth-child(5) > div.lobibox-footer.text-center > button")
	WebElement approvalConfirmationBtn;


	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn")
	WebElement objectReferenceConfirmationMsg;


	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-footer.text-center > button")
	WebElement objectReferenceConfirmationBtn;

	@FindBy(xpath = "//*[@id=\"ddlAppliedWorkflows\"]")
	WebElement workFlowDropList;
	
	@FindBy(xpath = "//*[@id=\"SaveButton\"]")
	WebElement saveWorkFlow;
	
	
	@FindBy(xpath = "//*[@id=\"V1TC_V0TP_WD_DECISION\"]")
	WebElement selectApprovalCycle;
	
	@FindBy(xpath = "//*[@id=\"SaveButton__Button\"]")
	WebElement saveApprovalCycle;
	
	@FindBy(xpath = "//*[@id=\"FIN_DEC\"]")
	WebElement selectFinalDecisionMaintained;
	
	public static  String MurabahaCode;


	@FindBy(css="#CUS_NAME")
	WebElement customerName;

	@FindBy(css="#FPROD_LATIN_NAME")
	WebElement productSetupName;

	@FindBy(id="CUS_CODE_lovImage")
	WebElement customerLOVIcon;

	@FindBy(xpath ="//*[@id=\"advancedFilter\"]")
	WebElement LOVQuickSearchField;

	String SubLovFrame = "parentModuleID1500900011";

	@FindBy(css="#filtergrid > div.k-grid-content > table > tbody > tr")
	WebElement LOVSearchResult;

	@FindBy(id="FPROD_CODE1_lovImage")
	WebElement productLOVIcon;

	//Change the repayment details from repayment tab
	@FindBy (xpath = "//*[@id=\"__tab_V18TC_V17TP\"]")
	WebElement repaymentTab;

	@FindBy (xpath = "//*[@id=\"V18TC_V17TP_REP_TENURE\"]")
	WebElement tenureEntry;

	@FindBy (xpath = "//*[@id=\"V18TC_V17TP_FST_INSTALLMENT_DATE\"]")
	WebElement firstInstallmentDate;

	//Check the Generated Installments from Installments tab
	@FindBy (xpath = "//*[@id=\"__tab_V18TC_V5TP\"]")
	WebElement installmentsTab;
	
	

	
	@FindBy (xpath = "//*[@id=\"V18PostButton\"]")
	WebElement postButton;

	//Search on RetailMurabahamoduleID and open it for RetailMurabahaTest

	public void OpenRetailMurabaha(String ParentframeID, 
			String RetailMurabahamoduleID) 
					throws InterruptedException
	{

		Thread.sleep(7000);
		driver1.switchTo().defaultContent();
		//waitMethod(5);
		waitForElement(searchBox);
		searchBox.clear();
		//Thread.sleep(7000);
		searchBox.sendKeys(RetailMurabahamoduleID);
		//waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		//waitMethod(7);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		//Thread.sleep(5000);
		waitForFrame(ParentframeID);
		//switchFrame(ParentframeID);

		waitMethod(7);
	}

	//Search on RetailMurabahamoduleID and open it for RetailMurabahaCRUD
	public void OpenRetailMurabahaCrud(String ParentframeID, 
			String RetailMurabahamoduleID) 
					throws InterruptedException
	{
		//Thread.sleep(7000);
		waitForElement(searchBox);
		searchBox.sendKeys(RetailMurabahamoduleID);
		//waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		//waitMethod(7);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		Thread.sleep(5000);
		switchFrame(ParentframeID);

		waitMethod(7);
	}
	public void FillRequiredFields(String RequestedDateValue,
			String ValueDateValue,
			String CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID,
			String TenuresCount,
			String FirstInstallmentDate)
					throws InterruptedException, IOException
	{
		fluentWaitMethod(RequestedDateTxt);

		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);

		openLOVAndSearch(customerLOVIcon, SubLovFrame, LOVQuickSearchField, CustomerIDValue, LOVSearchResult, ParentframeID);
		//waitForFrame(ParentframeID);
		Thread.sleep(5000);

		openLOVAndSearch(productLOVIcon, SubLovFrame, LOVQuickSearchField, ProductCodeValue, LOVSearchResult, ParentframeID);
		//waitForFrame(ParentframeID);
		Thread.sleep(5000);

		waitForElement(NonListedVendorTxt);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		waitForElement(addNewRowbBtn);
		clickButton(addNewRowbBtn);
		//Thread.sleep(3000);
		//waitMethod(3);
		waitForElement(ViewItemBtn);
		clickButton(ViewItemBtn);
		//Thread.sleep(7000);
		//switchFrame(SubFrameID);
		waitForFrame(SubFrameID);
		waitForElement(ItemNameTxt);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		//Thread.sleep(3000);
		waitForElement(SaveAndCloseBtn);
		clickButton(SaveAndCloseBtn);
		//Thread.sleep(8000);
		waitForFrame(ParentframeID);
		//Change the Tenures and first installment date from Rapayment Tab
		JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		waitMethod(3);
		clickButton(repaymentTab);
		//clickButton(tenureEntry);
		waitForSelection(tenureEntry);

		deleteValueFromControl(tenureEntry);
		
		setTextElementText(tenureEntry,TenuresCount);
		//waitForElement(firstInstallmentDate);
		//clickButton(firstInstallmentDate);
		
		//select all on a textbox and delete the text 
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		setTextElementText(firstInstallmentDate, selectAll);
		firstInstallmentDate.sendKeys(Keys.BACK_SPACE);
		
		
		//setTextElementText(firstInstallmentDate,"");
		setTextElementText(firstInstallmentDate,FirstInstallmentDate);
		firstInstallmentDate.sendKeys(Keys.TAB);
		waitMethod(5);
		clickButton(installmentsTab);

	}

	public void FillRequiredFieldsByCustomer1(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		waitForElement(CustomerIDTxt);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("M_004_Appr"));
		Boolean state = waitForCheckResult(CustomerNameTxt, StoreData(CustomerNameTxt));
		if (state)
		{
			waitForElement(ProductCodeTxt);
			setTextElementText(ProductCodeTxt, ProductCodeValue);
			state = waitForCheckResult(ProductNameTxt, StoreData(ProductNameTxt));
			if (state)
			{

				waitForElement(NonListedVendorTxt);
				setTextElementText(NonListedVendorTxt, NonListedVendorValue);
				setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
				waitForElement(addNewRowbBtn);
				clickButton(addNewRowbBtn);
				//Thread.sleep(3000);
				//waitMethod(3);
				waitForElement(ViewItemBtn);
				clickButton(ViewItemBtn);
				Thread.sleep(7000);
				switchFrame(SubFrameID);
				waitForElement(ItemNameTxt);
				setTextElementText(ItemNameTxt, ItemNameValue);
				//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
				DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
				setTextElementText(PriceTxt, PriceValue);
				setTextElementText(CostTxt, CostValue);
				//Thread.sleep(3000);
				waitForElement(SaveAndCloseBtn);
				clickButton(SaveAndCloseBtn);
				Thread.sleep(8000);
				switchFrame(ParentframeID);
			}
		}
	}

	public void FillRequiredFieldsByCustomer2(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("F_004_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}

	public void FillRequiredFieldsByCustomer3(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("M_002_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer4(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("F_002_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer5(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("M_010_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer6(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("F_010_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer7(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("M_007_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer8(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("F_007_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer9(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("BBC_M_003_Reje"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void SaveRetailMurabaha() throws InterruptedException
	{
		waitForElement(MasterSaveBtn);
		clickButton(MasterSaveBtn);
		//checkPageIsReady();
		Thread.sleep(5000);
		MurabahaCode = StoreData(ContractCodeTxt);
		System.out.println(MurabahaCode);
	}

	public void CheckRequestApproval() throws InterruptedException {

		fluentWaitMethod(RequestBtn);
		//waitForElement(RequestBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver1;

		//This will scroll the web page till top.		
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		
		checkPageIsReady();
		waitForElement(RequestBtn);
		Thread.sleep(5000);
		clickButton(RequestBtn);		
		//waitForGeneratedValue(StatusTxt);
		Thread.sleep(3000);
		assertEquals(StatusTxt.getAttribute("Value"), "Entry");
		System.out.println(StatusTxt);
		
		Thread.sleep(5000);
		DropListSelect(workFlowDropList, "791");
		clickButton(saveWorkFlow);
		checkPageIsReady();
		assertEquals(StatusTxt.getAttribute("Value"), "Request");
		clickButton(RequestBtn);
		
		
		Thread.sleep(3000);
		DropListSelect(selectApprovalCycle, "APP");
		clickButton(saveApprovalCycle);
		checkPageIsReady();
		assertEquals(StatusTxt.getAttribute("Value"), "Approved");
		
		Thread.sleep(3000);	
		clickButton(selectFinalDecisionMaintained);
		checkPageIsReady();
		clickButton(MasterSaveBtn);
		checkPageIsReady();
		
		Thread.sleep(3000);
		assertEquals(StatusTxt.getAttribute("Value"), "Ready");
		checkPageIsReady();

	}
	public void CheckPosting() throws InterruptedException {

		waitForElement(postButton);
		//waitForElement(RequestBtn);
		clickButton(postButton);		
		//waitForGeneratedValue(StatusTxt);
		Thread.sleep(3000);
		assertEquals(StatusTxt.getAttribute("Value"), "Active");
		
		System.out.println(StatusTxt);

	}

}
