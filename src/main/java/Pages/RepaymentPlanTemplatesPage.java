package Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepaymentPlanTemplatesPage extends PageBase{

	public RepaymentPlanTemplatesPage(WebDriver driver) {
		super(driver);
		driver1=driver;

	}

	//Global Variables
	WebDriver driver1;
	@FindBy (id = "txt_PlaceHolder")WebElement searchBox;

	//WebElements Declaration for Master Block 
	@FindBy(id="REPT_DATE1") WebElement ReptDateTxt;
	@FindBy(id="PER_CODE_TENURE_UNIT") WebElement PeriodBaseDropDown;
	@FindBy(id="REPT_DESCRIPTION1") WebElement ReptDescTxt;
	@FindBy(id="V0NewButton") WebElement NewButton;
	//@FindBy(id="PDY_CODE_lovImage") WebElement DayCountConvLOVBtn;
	@FindBy(xpath="//*[@id=\"PDY_CODE_lovImage\"]") WebElement DayCountConvLOVBtn;
	@FindBy(id="REPT_ROUND_TO_NEAREST1") WebElement RoundToNearestTxt;
	@FindBy (css="#filtergrid > div.k-grid-content > table > tbody > tr:nth-child(2)")
	WebElement SelectDayCountDC;
	@FindBy(id="REPT_SETTLEMENT_TYPE1") WebElement SettTypeDropList;
	@FindBy(id="REPT_ACCRUAL_BASE1") WebElement ProfitRecognitionDropList;	
	@FindBy(id="REPT_REMAINING_VALUE_LOCATION") WebElement RemainingValueLocationDropList;
	@FindBy(id="REPT_ALLOW_PARTIAL_PAYMENT") WebElement AllowPartialPaymentCheckBox;
	
	//WebElements Declaration for Details Block 
	//1-Repayments Options
	@FindBy(id="__tab_V0TC_V1TP1") WebElement RepOptionBtn;
	@FindBy(id="V0TC_V1TP1_REPT_MIN_TENURE") WebElement MinTenureTxt;
	@FindBy(id="V0TC_V1TP1_REPT_MAX_TENURE") WebElement MaxTenursTxt;
	//Collection Priority Options 
	@FindBy(id="V0TC_V1TP1_REPT_COLLECTION_PRIORITY") WebElement ProfitPriorityDropList;
	@FindBy(id="V0TC_V1TP1_REPT_COLLECTION_PRIORITY") WebElement ProratePriorityDropList;
	@FindBy(id="V0TC_V1TP1_REPT_COLLECTION_PRIORITY") WebElement PrinciplePriorityDropList;
	//Grace Days Options
	@FindBy(id="V0TC_V1TP1_REPT_GRACE_PERIOD_ALLOWED") WebElement GracePeriodbtn;
	@FindBy(id="V0TC_V1TP1_REPT_GRACE_OPTION") WebElement WithProfitDropList;
	@FindBy(id="V0TC_V1TP1_REPT_GRACE_OPTION") WebElement WithoutProfitDropList;
	@FindBy(id="V0TC_V1TP1_REPT_GRACE_OPTION") WebElement AccruedProfitDropList;
	@FindBy(id="V0TC_V1TP1_REPT_GRACE_DAYS") WebElement GRaceDaystxt;
	//Save & Post
	@FindBy (id="SaveButton__Button") WebElement SaveBtn;
	@FindBy(xpath="//*[@id=\"POSTButton\"]") WebElement PostBtn;
	
	//2-Profit Rate Tab
	@FindBy(id="__tab_V0TC_V2TP1") WebElement ProfitRatebtn;
	@FindBy(id="V0TC_V2TP1_REPT_PROFIT_PER_NO") WebElement profitPeriodNoTxt;
	@FindBy(id="V0TC_V2TP1_PCM_CODE") WebElement PresentValueDropList;
	@FindBy(id="V0TC_V2TP1_PCM_CODE") WebElement DiminishingDropList;
	@FindBy(id="V0TC_V2TP1_PCM_CODE") WebElement StraightDropList;
	@FindBy(id="V0TC_V2TP1_PCM_CODE") WebElement AllStraightDropList;

	//4- Intervals Tab
	@FindBy (id="__tab_V0TC_V4TP1") WebElement IntervalsBtn;
	@FindBy (id="V0TC_V4TP1_V4AddButton") WebElement AddBtn;
	@FindBy (id="V0TC_V4TP1_V4LC1Repeater_ctl00_RETN_UP_TO1") WebElement UpToTxt;
	
	@FindBy(xpath="//*[@id=\"V0TC_V4TP1_V4LC1Repeater_ctl00_EditButton\"]") WebElement DetailsBtn;
	//Frmae2
	@FindBy (id="RPTI_INS_TIMING_0") WebElement FirstInstallmentBtn;
	@FindBy (id="RPTI_INS_TIMING_1") WebElement ShiftedBtn;
	@FindBy(id="RPTI_INS_TIMING_2") WebElement OnDateBtn;
	@FindBy(id="RPTI_INS_TIMING_3") WebElement BalloonBtn;
	@FindBy(xpath="//*[@id=\"PI_NAME_FLD_DIV\"]/img[2]") WebElement ImgBtn;
	@FindBy(id="PER_CODE_0") WebElement DailyBtn;
	@FindBy(id="PER_CODE_1") WebElement WeeklyBtn;
	@FindBy(id="PER_CODE_2") WebElement MonthlyBtn;
	@FindBy(id="PER_CODE_3") WebElement QuarterlyBtn;
	@FindBy(id="PER_CODE_4") WebElement HalfYearlyBtn;
	@FindBy(id="PER_CODE_5") WebElement YearlyBtn;
	@FindBy(id="PI_LAST_DAY") WebElement AtDropList;
	@FindBy(id="PI_MONTH_DAY_MONTHLY")WebElement MonthOnTxt;
	@FindBy (id="PI_WEEK_NO") WebElement WeekNoOnTxt;
	@FindBy (id="PI_WEEK_DAY_MONTHLY") WebElement OnDayDropList;
	@FindBy(id="PI_WEEKEND_OPTION")WebElement WeekEndDropList;
	@FindBy(id="PI_VACATION_OPTION") WebElement VacationDropList;
	@FindBy(id="RPTI_MAX_INS") WebElement MaxInstallmentCheckBox;
	@FindBy(id="RPTI_INS_TYPE") WebElement InstallmentTypeDropList;
	@FindBy(id="RPTI_PROFIT_RATE_TYPE") WebElement ProfitRateTypeDropList;
	@FindBy(id="RPTI_PROFIT_PER") WebElement PercentageTxt;
	@FindBy(id="RPTI_PAYMENT_TYPE_0") WebElement RatioBtn;
	@FindBy(id="RPTI_RATIO_OF_TOTAL_AMOUNT") WebElement RatioTxt;
	@FindBy (xpath = "//*[@id=\"REPT_CODE2\"]") WebElement actualRepaymentCode;            
	
	 public static String repaymentCode;
	

	public void OpenRepaymentPlanTemplates(String ParentframeID,String RepaymentPlanModuleID) 
					throws InterruptedException
	{

		//Thread.sleep(7000);

		driver1.switchTo().defaultContent();
		//waitMethod(5);
		waitForElement(searchBox);
		searchBox.clear();
		//Thread.sleep(7000);
		searchBox.sendKeys(RepaymentPlanModuleID);
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


	public void InsertMasterData(String ReptDateValue,String PeriodBaseDropDownValue,
			String ReptDescValue, String SubFrame,String RoundToNearestValue,
			String SettlmentTypeValue,String ProfitRecognitionValue,
			String RemainingValueLocationValue, String parentFrameValue) throws InterruptedException
	{
		
		setTextElementText(ReptDateTxt, ReptDateValue);
		DropListSelect(PeriodBaseDropDown, PeriodBaseDropDownValue);
		//setTextElementText(PeriodBaseDropDown, PeriodBaseDropDownValue);
		setTextElementText(ReptDescTxt, ReptDescValue);
		//Thread.sleep(4000);
		clickButton(DayCountConvLOVBtn);
		Thread.sleep(5000);
		switchFrame(SubFrame);	
		Thread.sleep(4000);
		DoubleClickonElement(SelectDayCountDC);
		Thread.sleep(3000);
		switchFrame(parentFrameValue);		
		setTextElementText(RoundToNearestTxt, RoundToNearestValue);
		DropListSelect(SettTypeDropList, SettlmentTypeValue);
		DropListSelect(ProfitRecognitionDropList, ProfitRecognitionValue);
		DropListSelect(RemainingValueLocationDropList, RemainingValueLocationValue);
		clickButton(AllowPartialPaymentCheckBox);
	}

	public void InsertRepaymentsOptionsData(String MinTunerValue,String MaxTunerValue,
			                           String ProrateValue  )
	{
		clickButton(RepOptionBtn);
		waitMethod(10);
		setTextElementText(MinTenureTxt, MinTunerValue);
		setTextElementText(MaxTenursTxt, MaxTunerValue);
		DropListSelect(ProratePriorityDropList, ProrateValue);
	}
	public void InsertProfitRateData(String CalcMethodValue,String ProfitPeriodNoValue)
	{
		clickButton(ProfitRatebtn);
		waitMethod(5);
		DropListSelect(AllStraightDropList, CalcMethodValue);
		setTextElementText(profitPeriodNoTxt,ProfitPeriodNoValue);
	}
	
	//1-Intervals with AT =Last Day or Depend on Transaction
	public void InsertIntervalsData(String UpToValue,String SubFrameValue,
			                         String SubFrame2Value, String AtValue,
			                          String WeekEndValue,String VacationValue,
			                          String InstallmentTypeDropValue,String ProfitRateTypeDropValue,
			                          String PercentageValue,String RatioValue,String ParentFrameValue) throws InterruptedException
	{
		clickButton(IntervalsBtn);
		waitMethod(10);
		clickButton(AddBtn);
		waitMethod(3);
		setTextElementText(UpToTxt, UpToValue);
		clickButton(SaveBtn);
		Thread.sleep(8000);
		clickButton(DetailsBtn);
		Thread.sleep(8000);
		driver1.switchTo().defaultContent();
		switchFrame(SubFrameValue);
		clickButton(FirstInstallmentBtn);
		clickButton(ImgBtn);
		Thread.sleep(3000);
		driver1.switchTo().defaultContent();
		switchFrame(SubFrame2Value);
		clickButton(MonthlyBtn);
		DropListSelect(AtDropList, AtValue);
		DropListSelect(WeekEndDropList, WeekEndValue);
		DropListSelect(VacationDropList, VacationValue);
		clickButton(SaveBtn);
		driver1.switchTo().defaultContent();
		switchFrame(SubFrameValue);
		clickButton(MaxInstallmentCheckBox);
		DropListSelect(InstallmentTypeDropList, InstallmentTypeDropValue);
		DropListSelect(ProfitRateTypeDropList, ProfitRateTypeDropValue);
		setTextElementText(PercentageTxt, PercentageValue);
		clickButton(RatioBtn);
		setTextElementText(RatioTxt, RatioValue);
		clickButton(SaveBtn);
		driver1.switchTo().defaultContent();
		switchFrame(ParentFrameValue);
		clickButton(SaveBtn);
		Thread.sleep(6000);
		repaymentCode = StoreData(actualRepaymentCode);
		System.out.println("InsertIntervalsData" + repaymentCode);
		Thread.sleep(7000);
		clickButton(PostBtn);
		waitMethod(200);
		ConfirmAlert();
		waitMethod(200);
	}
	
	//2-Intervals with AT = Specific Day
 
		public void InsertIntervalsDataWithSpecificDay(String UpToValue,String SubFrameValue,
				                         String SubFrame2Value, String AtValue,String MonthOnValue,
				                         String WeekEndValue,String VacationValue,String InstallmentTypeDropValue,
				                         String ProfitRateTypeDropValue,String PercentageValue,
				                         String RatioValue,String ParentFrameValue)
				                         throws InterruptedException
		{
			clickButton(IntervalsBtn);
			waitMethod(10);
			clickButton(AddBtn);
			waitMethod(3);
			setTextElementText(UpToTxt, UpToValue);
			clickButton(SaveBtn);
			Thread.sleep(6000);
			clickButton(DetailsBtn);
			Thread.sleep(5000);
			driver1.switchTo().defaultContent();
			switchFrame(SubFrameValue);
			//Thread.sleep(5000);
			clickButton(FirstInstallmentBtn);
			clickButton(ImgBtn);
			Thread.sleep(3000);
			driver1.switchTo().defaultContent();
			switchFrame(SubFrame2Value);
			clickButton(MonthlyBtn);			
			//setTextElementText(OnDayDropList, OnDayValue);
			DropListSelect(AtDropList, AtValue);
			setTextElementText(MonthOnTxt, MonthOnValue);
			DropListSelect(WeekEndDropList, WeekEndValue);
			DropListSelect(VacationDropList, VacationValue);
			clickButton(SaveBtn);
			driver1.switchTo().defaultContent();
			switchFrame(SubFrameValue);
			clickButton(MaxInstallmentCheckBox);
			DropListSelect(InstallmentTypeDropList, InstallmentTypeDropValue);
			DropListSelect(ProfitRateTypeDropList, ProfitRateTypeDropValue);
			setTextElementText(PercentageTxt, PercentageValue);
			clickButton(RatioBtn);
			setTextElementText(RatioTxt, RatioValue);
			clickButton(SaveBtn);
			driver1.switchTo().defaultContent();
			switchFrame(ParentFrameValue);
			clickButton(SaveBtn);
			Thread.sleep(6000);
			//repaymentCode = StoreData(actualRepaymentCode);
			System.out.println("InsertIntervalsDataWithSpecificDay" + repaymentCode);
			Thread.sleep(6000);
			clickButton(PostBtn);
			waitMethod(70);
			ConfirmAlert();
		    waitMethod(200);
			
		}
		
		public void clickNewButton() throws InterruptedException {
			Thread.sleep(4000);
			clickButton(NewButton);
		}
}
