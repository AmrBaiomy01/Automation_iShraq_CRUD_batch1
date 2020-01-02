package CRUDPages;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Code;
import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;

import Pages.FundPage;

public class IndividualProspectPage extends FundPage {

	public IndividualProspectPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}


	//public static WebDriver driver1;
	WebDriver driver1;
	Faker fakeData = new Faker();
	String moduleID = "150027331";
	String IndividualCustomersmoduleID = "15002711";
	Code CIF = fakeData.code();
	public static String customerName = "Omdaxx";
	String Nationality = "1";
	public static String generatedProspectCode;
	
	
	String subModuleID = "parentModuleID"+IndividualCustomersmoduleID;
	@FindBy (css = "#contact_01 > div > div.col-lg-11 > div.row > div:nth-child(2) > div > div.VisitedModules > ul")
	WebElement lastVisitedModules;

	@FindBy (id = "txt_PlaceHolder")
	WebElement searchBox;

	@FindBy (css = "#\\31 50027331 > div > span")
	WebElement searchResult;


	@FindBy (id = "LE_CIF_CODE")
	WebElement textCIF;

	@FindBy (css = "LE_CIF_CODE")
	WebElement customerActualCIF;

	@FindBy (id = "IND_L_FIRST_NAME1")
	WebElement cusFirstName;

	@FindBy (id = "LE_PAYMENT_METHOD")
	WebElement paymentMethod;


	@FindBy (id = "P_0000002000000209")
	WebElement userDefinedText;

	@FindBy (id = "__tab_V33TC_V22TP")
	WebElement customerEmployeesTab;

	@FindBy (id = "V33TC_V22TP_V22AddButton")
	WebElement addNewCusEmp;

	@FindBy (id = "V33TC_V22TP_V22LCRepeater_ctl00_EMP_CODE1")
	WebElement employeeCode;

	@FindBy (id = "V33TC_V22TP_V22LCRepeater_ctl00_CUS_EMP_ROLE")
	WebElement employeeRole;

	@FindBy (id = "V33TC_V22TP_V22LCRepeater_ctl00_CAM_IS_DEFAULT")
	WebElement isDefault;

	@FindBy (id = "V33SaveButton")
	WebElement saveBtn;

	@FindBy (id = "CUS_PROSPECT_CODE")
	WebElement prospectCode;


	@FindBy (id = "V33WorkFlowButton")
	WebElement forwardWorkflowBtn;

	@FindBy (id = "V33POSTButton")
	WebElement postBtn;


	@FindBy (id = "V33Pagination__LastPage")
	WebElement lastRecordBtn;


	@FindBy (css = "#FilterAreaContainer > input[type=\"image\"]")
	WebElement customersFilterIcon;



	@FindBy (css = "#filtergrid > div.k-grid-header > div > table > thead > tr:nth-child(2) > th:nth-child(3) > input")
	WebElement SearchFilterArea;


	@FindBy (css = "#filtergrid > div.k-grid-content > table > tbody")
	WebElement SearchFilterResult;


	@FindBy (id = "filterBtn")
	WebElement SelectFilter;


	@FindBy (css = "#CUS_PROSPECT_CODE")
	WebElement filteredProspectCode;

	@FindBy(css = "#V33Pagination__FirstPage")
	WebElement firstRecord;

	@FindBy(xpath = "#UpdatePanel1_UpdateProgress1 > div.UpdaingImg")
	WebElement loadIcon;

	
	@FindBy(css = "#P_0000000000010022")
	WebElement customerGenderUD;

	@FindBy(css = "#P_0000000000010012")
	WebElement customerEmployementUD;
	
	@FindBy(css = "#P_0000000000010030")
	WebElement customerFinanceAmountUD;
	
	@FindBy(css = "#P_0000000000010028")
	WebElement customerSalaryUD;
	
	@FindBy(css = "#__tab_V33TC_V43TP1")
	WebElement customerPersonalTab;
	
	@FindBy(css = "#V33TC_V43TP1_IND_DATE_OF_BIRTH1")
	WebElement customerBirthDate;
	
	
	@FindBy(css = "#V33SaveButton")
	WebElement saveIndividualCustomer;
	
	@FindBy (css = "#LE_CODE")
	WebElement CustomerCode;
	public static String generatedCustomerCode;
	

	public void OpenIndividualProspect(String ProspectParentframeID , String CustomersParentFrameID) throws InterruptedException 
	{
		Thread.sleep(5000);
		waitForElement(lastVisitedModules);
		waitForElement(searchBox);
		setTextElementText(searchBox, moduleID);
		//waitForElement(searchResult);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		waitForElement(searchResult);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		waitForFrame(ProspectParentframeID);
		
		setTextElementText(textCIF, fakeData.code().isbn10());
		
		System.out.println("CIF Code Is :" + textCIF.getText().toString());
		setTextElementText(cusFirstName, customerName);
		DropListSelect(paymentMethod, "CASH");
		setTextElementText(userDefinedText, "8998");
		clickButton(customerEmployeesTab);
		waitForElement(addNewCusEmp);
		clickButton(addNewCusEmp);
		waitForElement(employeeCode);
		setTextElementText(employeeCode, "10");
		employeeCode.sendKeys(Keys.TAB);
		waitForCheckResult(employeeRole, "Account Manager");
		clickButton(isDefault);
		clickButton(saveBtn);
		waitForGeneratedCode(prospectCode);
		System.out.println("Prospect Code Is :" + StoreData(prospectCode));
		generatedProspectCode = StoreData(prospectCode);
		clickButton(forwardWorkflowBtn);
		waitForConfirmationMsg();
		ConfirmAlert();
		waitForElement(postBtn);
		clickButton(postBtn);
		waitForConfirmationMsg();
		ConfirmAlert();
		waitForElement(cusFirstName);
		////////////////////////////////////Open Individual Customer module and post the created prospect//////////////////////////////
		driver1.switchTo().defaultContent();
		waitForElement(searchBox);
		searchBox.clear();
		setTextElementText(searchBox, IndividualCustomersmoduleID);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		waitForElement(searchResult);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		//Thread.sleep(5000);
		waitForFrame(CustomersParentFrameID);
		clickButton(lastRecordBtn);
		waitForElement(firstRecord);
		System.out.println("Actual Prospect Code Is :" + StoreData(filteredProspectCode));
		//waitForLoading(cusFirstName);
		assertEquals(StoreData(filteredProspectCode), generatedProspectCode);
		generatedCustomerCode = StoreData(CustomerCode);


	}
	public void EditIndividualCustomerData(Hashtable<String,String> customerData) throws InterruptedException
	{
		//use the hashtable to read data from Json file with the exact key defined in json file UserName and UserPass
		/*setTextElementText(LoginName, loginData.get("UserName"));
		setTextElementText(Loginpassword, loginData.get("UserPass"));
		Checkingcheckbox(Rememberme);
		clickButton(Loginbtn);*/
		DropListSelect(customerGenderUD, customerData.get("Gender"));
		DropListSelect(customerEmployementUD, customerData.get("Employement"));
		setTextElementText(customerFinanceAmountUD, customerData.get("Finance Amount"));
		setTextElementText(customerSalaryUD, customerData.get("Salary"));
		clickButton(customerPersonalTab);
		setTextElementText(customerBirthDate, customerData.get("Birth Date"));
		clickButton(saveIndividualCustomer);
		waitForElement(cusFirstName);
		
	}


}
