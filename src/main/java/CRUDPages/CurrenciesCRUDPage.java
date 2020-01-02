package CRUDPages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.PageBase;


public class CurrenciesCRUDPage extends PageBase {

	public CurrenciesCRUDPage(WebDriver driver1) {
		super(driver1);
		driver11 = driver1;
	}

	WebDriver driver11;
	public CRUDMainPage CRUDMainObject = new CRUDMainPage(driver1);


	//Master Page Elements 
	@FindBy(id="V1AddButton") WebElement newRowBtn;
	@FindBy(id="V1LCRepeater_ctl00_CUR_CODE") WebElement codeTxt;
	@FindBy(id="V1LCRepeater_ctl00_CUR_ISO_CODE") WebElement ISOTxt;
	@FindBy(id="V1LCRepeater_ctl00_CUR_LATIN_NAME") WebElement latinNameTxt;
	@FindBy(id="V1LCRepeater_ctl00_CUR_ARABIC_NAME") WebElement otherNameTxt;
	@FindBy(id="V1LCRepeater_ctl00_CUR_MINOR_UNITS") WebElement minorTxt;
	@FindBy(id="V1LCRepeater_ctl00_CUR_MINOR_UNIT_LATIN_NAME") WebElement MUTxt;
	
	@FindBy(id= "V1SaveButton")   public static WebElement master_SaveButton;
	@FindBy(id="V1RefreshButton") WebElement refreshBtn;
	@FindBy(id="V1LCRepeater_ctl00_V1RowDeleteButton") WebElement deleteBtn;
	@FindBy(id="V1LCRepeater_ctl00_V0RRowSelection") WebElement selectRowCheckBox;
	
	//Retrieve All and Paging
	@FindBy(id="V1ResetButton") WebElement retrieveAllBtn;
	@FindBy(id="V1Pagination__NextPage") WebElement nextPageBtn;
	@FindBy(id="V1Pagination__PreviousPage") WebElement previousPageBtn;
	@FindBy(id="V1Pagination__LastPage") WebElement lastPageBtn;
	@FindBy(id="V1Pagination__FirstPage") WebElement firstPageBtn;
	
	//Filter Area
	@FindBy(css="#FilterAreaContainer > input[type=image]") WebElement filterAreaBtn;
	
	@FindBy (css="#filtergrid > div.k-pager-wrap.k-grid-pager.k-widget > a.k-link.k-pager-nav.k-pager-last > span")
	WebElement goToLastPageBtn;
	@FindBy(css="#filtergrid > div.k-grid-content > table > tbody > tr")
	WebElement selectRowBtn;
	@FindBy (id="V1LCRepeater_ctl00_V0RowDeleteButton")	WebElement deleteRowBtn;
	@FindBy (id="filterBtn") WebElement filterBtn;
	

	//Start Point
	
	public void FillModuleFields(String moduleID,String ParentframeID)
			throws InterruptedException, FileNotFoundException, IOException, ParseException 

	{
		//CRUDMainObject = new CRUDMainPage(driver1);
		//1- Navigate To Module
		CRUDMainObject.NavigateToModuleWebPage(moduleID, ParentframeID);
		CRUDMainObject.clickNewRowOnGrid(newRowBtn);
		
	}
	//5-Update 
	public void updateData(String updateNameValue) throws InterruptedException
	{
		//CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.updateData(latinNameTxt, updateNameValue);
		Thread.sleep(5000);
		master_SaveButton.click();
		Thread.sleep(5000);
	}
	//6- Delete 
	public void deleteData() throws InterruptedException
	{
		
		clickButton(deleteBtn);
		waitMethod(10);
		ConfirmAlert();
		Thread.sleep(3000);
		master_SaveButton.click();
		Thread.sleep(5000);
		
	}
	
	//7- Open filter area and filter by any record
	public void filterByRecords(String filterAreaFrame,String ParentframeID)
			throws InterruptedException {
	
		//CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.filterByRecords(filterAreaBtn, filterAreaFrame, goToLastPageBtn, 
				selectRowBtn, filterBtn, ParentframeID);
	}
	
	// 8- Retrieve All and Paging
	public void retrieveAllAndPaging() throws InterruptedException {
		
		//CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.retrieveAllAndPaging(retrieveAllBtn, nextPageBtn, previousPageBtn, lastPageBtn, firstPageBtn);
	}
	
	// Special case to fill data
	public void fillDataToGrid(String codeValue,String ISOCodeValue,String latinNameValue,
			String otherNameValue,String MinorNameValue,String MUValue)
					throws InterruptedException {
		setTextElementText(codeTxt, codeValue);
		setTextElementText(ISOTxt, ISOCodeValue);
		setTextElementText(latinNameTxt,latinNameValue);
		setTextElementText(otherNameTxt,otherNameValue);
		setTextElementText(minorTxt, MinorNameValue);
		setTextElementText(MUTxt, MUValue);
		master_SaveButton.click();
		Thread.sleep(5000);
		
	}
}