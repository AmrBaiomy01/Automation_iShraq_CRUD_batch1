package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessRulesPage extends PageBase {

	public BusinessRulesPage(WebDriver driver) {
		super(driver);
	}

	//Global Variables
	WebDriver driver1;
	String ConditionBuilderFram="parentModuleID2100000031";
	//Search Area Text 
	@FindBy (css="#txt_PlaceHolder") WebElement searchBox;
	//Business Rule Elements
	@FindBy(id="BR_NAME") WebElement RuleNameTxt;
	@FindBy(css="#NOTE") WebElement RuleNoteTxt;
	@FindBy(css="#BTN_EDIT_EQ__Button") WebElement EditBtn;

	//Find elements for Condition Builder
	@FindBy(css="#txtModuleID") WebElement ModuleIDTxt;
	@FindBy(css="#txtModuleID_lovImage") WebElement ModuleLOVBtn;
	@FindBy(id="ddlTypes") WebElement FactorTypeDropdownSelect;	
	/*//i50Dev
	@FindBy(css="#grdColumns > tbody > tr:nth-child(3) > td:nth-child(1)") WebElement AmountFiledBtn;
	@FindBy(id="grdColumns_ctl03_txtField") WebElement name;
	*/

	//i50QC
	@FindBy(css="#grdColumns > tbody > tr:nth-child(2) > td:nth-child(1)") WebElement NameFiledBtn;
	@FindBy(css="#grdColumns_ctl02_txtField") WebElement NameTxt;
	

	@FindBy(id="btnBetween__Button") WebElement BetweenBtn;
	@FindBy(id="btnEqual__Button") WebElement EqualBtn;
	@FindBy(id="btnAnd__Button") WebElement AndBtn;
	@FindBy(id="") WebElement OrBtn;
	@FindBy(id="btnAdd__Button") WebElement AddBtn;
	@FindBy(id="btnClear__Button") WebElement ClearBtn;
	@FindBy(id="txtFormula") WebElement TextAreatxt;
	@FindBy(id="btnValidate__Button") WebElement ValidateBtn;
	@FindBy(css="body > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn")
	WebElement ConfirmationMsg;
	@FindBy(css="body > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-footer.text-center > button")
	WebElement ConfirmationBtn;
	@FindBy(css="#btnAccept__Button") WebElement SaveBtn;	
	@FindBy(id="btnCancel__Button") WebElement CancelBtn;
	@FindBy(css="#txtModuleID_lovImage") WebElement ModuleLOVBtn2;
	@FindBy (css="#V0SaveButton") WebElement MasterSaveBtn; 
	@FindBy(css="#V0DeleteButton") WebElement DeleteBtn;
	//i50Dev
	/*@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-body > div.lobibox-body-text-wrapper")
	WebElement ConfirmationSaveMsg;
	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-footer.text-center > button")
	WebElement ConfirmationSaveBtn;*/
	
	//Rule Code
	
	@FindBy (id = "BR_CODE")
	public WebElement RuleCode;

	public static String ActualRuleCode;


	public void OpenBussinessRule(String BusinessRulesModuleID,String ParentFram) 
			throws InterruptedException
	{
		Thread.sleep(3000);
		searchBox.sendKeys(BusinessRulesModuleID);
		waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.SHIFT,Keys.ENTER);
		Thread.sleep(7000);
		switchFrame(ParentFram);
		waitMethod(7);
	}

	public void InsertAllMandatoryFields(String NameText,String FrameID,
			String SubFrame,String ModuleID, String FactorType, String NameValue)
					throws InterruptedException {
		setTextElementText(RuleNameTxt, NameText);
		
		//Open Config Builder
		clickButton(EditBtn);
		Thread.sleep(2000);
		switchFrame(SubFrame);
		Thread.sleep(1000);
		ModuleIDTxt.sendKeys(ModuleID);
		Thread.sleep(1500);
		DropListSelect(FactorTypeDropdownSelect, FactorType);
		//DoubleClickonElement(AmountFiledBtn);
		DoubleClickonElement(NameFiledBtn);
		clickButton(EqualBtn);
		//AmountTxt.sendKeys(Amount);
		NameTxt.sendKeys(NameValue);
		Thread.sleep(4000);
		clickButton(AddBtn);
		clickButton(ValidateBtn);
		Thread.sleep(2000);
		if (ConfirmationMsg.isDisplayed()) {

			clickButton(ConfirmationBtn);

		}
		Thread.sleep(2000);
		clickButton(SaveBtn);
		Thread.sleep(2000);
		switchFrame(FrameID);


	}

	public void CheckSaveBusinessRule() throws InterruptedException {

		clickButton(MasterSaveBtn);
		Thread.sleep(2000);
		ActualRuleCode=StoreData(RuleCode);
		
	}

	public void CheckUpdate(String UpdateNameTxtValue,String NotesTxtValue) throws InterruptedException {

		RuleNameTxt.clear();
		setTextElementText(RuleNameTxt, UpdateNameTxtValue);
		setTextElementText(RuleNoteTxt, NotesTxtValue);
		CheckSaveBusinessRule();
		Thread.sleep(1000);
	}
	public void CheckDelete() throws InterruptedException {
		clickButton(DeleteBtn);
		ConfirmAlert();
		Thread.sleep(1000);
		
	}


}
