package CRUDPages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.PageBase;


public class CustomerScoringAttributesCRUDPage extends PageBase {

	public CustomerScoringAttributesCRUDPage(WebDriver driver1) {
		super(driver1);
		driver11 = driver1;
	}

	WebDriver driver11;
	public CRUDMainPage CRUDMainObject;

	

	//Master Page Elements 
	@FindBy(id="V0AddButton") WebElement newRowBtn;
	@FindBy(id="V0LCRepeater_ctl00_CAT_LATIN_NAME") WebElement latinNameTxt;
	@FindBy(id="V0LCRepeater_ctl00_CAT_ARABIC_NAME") WebElement otherNameTxt;
	@FindBy(id="V0LCRepeater_ctl00_CAT_TYPE") WebElement customerTypeDropList;
	
	@FindBy(css= "#V0SaveButton")public static WebElement master_SaveButton;

	@FindBy(id="V0LCRepeater_ctl00_V0RowDeleteButton") WebElement deleteBtn;
	@FindBy(id="V0LCRepeater_ctl00_V0RRowSelection") WebElement selectRowCheckBox;
	
	//Retrieve All and Paging
	@FindBy(id="V0ResetButton") WebElement retrieveAllBtn;
	@FindBy(id="V0Pagination__NextPage") WebElement nextPageBtn;
	@FindBy(id="V0Pagination__PreviousPage") WebElement previousPageBtn;
	@FindBy(id="V0Pagination__LastPage") WebElement lastPageBtn;
	@FindBy(id="V0Pagination__FirstPage") WebElement firstPageBtn;
	
	//Filter Area
	@FindBy(css="#FilterAreaContainer > input[type=image]") WebElement filterAreaBtn;
	
	@FindBy (css="#filtergrid > div.k-pager-wrap.k-grid-pager.k-widget > a.k-link.k-pager-nav.k-pager-last > span")
	WebElement goToLastPageBtn;
	@FindBy(css="#filtergrid > div.k-grid-content > table > tbody > tr")
	WebElement selectRowBtn;
	@FindBy (id="V0LCRepeater_ctl00_V0RowDeleteButton")	WebElement deleteRowBtn;
	@FindBy (id="filterBtn") WebElement filterBtn;
	
	

	//Start Point
	
	public void FillModuleFields(String moduleID,String ParentframeID)
			throws InterruptedException, FileNotFoundException, IOException, ParseException 

	{
		CRUDMainObject = new CRUDMainPage(driver1);
		//1- Navigate To Module
		CRUDMainObject.NavigateToModuleWebPage(moduleID, ParentframeID);
		CRUDMainObject.clickNewRowOnGrid(newRowBtn);
		

		//2- Read Fields and Values from Json file
		//JSONArray jsonObjects = JsonDataReader.ReadFromJsonCustomerScoringAttributes(moduleID);

		//3- Add modules values to fields
		/*Boolean dataAdded = false;
		for (int i = 0; i < jsonObjects.size(); i++) {
			dataAdded = CRUDMainObject.AddModuleFieldsValues(moduleID, jsonObjects, i);
		}

		//4- Save module when dataAdded;
		if (dataAdded) {
			//JavascriptExecutor jse = (JavascriptExecutor) driver1;
			//jse.executeScript("document.getElementById('V1SaveButton').focus();");

			Thread.sleep(2000);
			master_SaveButton.click();
			Thread.sleep(5000);
		}*/
	}
	//5-Update 
	public void updateData(String updateNameValue) throws InterruptedException
	{
		CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.updateData(latinNameTxt, updateNameValue);
		master_SaveButton.click();
		Thread.sleep(5000);
	}
	//6- Delete 
	public void deleteData() throws InterruptedException
	{
		CRUDMainObject = new CRUDMainPage(driver1);
		clickButton(deleteBtn);
		waitMethod(2);
		//CRUDMainObject.deleteData(deleteBtn);
		ConfirmAlert();
		Thread.sleep(1000);
		master_SaveButton.click();
		Thread.sleep(5000);
	}
	//7- Open filter area and filter by any record
	public void filterByRecords(String filterAreaFrame,String ParentframeID)
			throws InterruptedException {
	
		CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.filterByRecords(filterAreaBtn, filterAreaFrame, goToLastPageBtn, 
				selectRowBtn, filterBtn, ParentframeID);
	}
	
	// 8- Retrieve All and Paging
	public void retrieveAllAndPaging() throws InterruptedException {
		
		CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.retrieveAllAndPaging(retrieveAllBtn, nextPageBtn, previousPageBtn, lastPageBtn, firstPageBtn);
	}
	
	// Special case to fill data
	public void fillDataToGrid(String latinNameValue,String otherNameValue,String customerTypeValue) throws InterruptedException {
		setTextElementText(latinNameTxt, latinNameValue);
		setTextElementText(otherNameTxt, otherNameValue);
		DropListSelect(customerTypeDropList, customerTypeValue);
		master_SaveButton.click();
		Thread.sleep(5000);
		
	}
}