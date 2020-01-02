package CRUDPages;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.PageBase;
import TestData.JsonDataReaderOnPage;


public class ItemsCategoriesCRUDPage extends PageBase {

	public ItemsCategoriesCRUDPage(WebDriver driver1) {
		super(driver1);
		driver11 = driver1;
	}

	WebDriver driver11;
	public CRUDMainPage CRUDMainObject;

	

	//Master Page Elements 
		
	@FindBy(id ="IC_LATIN_NAME") WebElement First;
	@FindBy(id = "V33NewButton") WebElement newRowBtn;
	@FindBy(id="IC_LATIN_NAME")WebElement latinNameTxt;
	
	@FindBy(css= "#V1SaveButton") public static WebElement master_SaveButton;
	@FindBy(id="V33RefreshButton") WebElement refreshBtn;
	@FindBy(css="#V1DeleteButton") WebElement deleteBtn;
	//@FindBy(id="V0LCRepeater_ctl00_V0RRowSelection") WebElement selectRowCheckBox;
	
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
			CRUDMainObject = new CRUDMainPage(driver1);
			//1- Navigate To Module
			CRUDMainObject.NavigateToModuleWebPage(moduleID, ParentframeID);

			//2- Read Fields and Values from Json file
			JSONArray jsonObjects = JsonDataReaderOnPage.ReadFromJsonSector(moduleID);

			//3- Add modules values to fields
			Boolean dataAdded = false;
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
		
			}
		}
		//5-Update 
		public void updateData(String updateNameValue) throws InterruptedException
		{
			CRUDMainObject = new CRUDMainPage(driver1);
			CRUDMainObject.updateData(latinNameTxt, updateNameValue);
		}
		//6- Delete 
		public void deleteData() throws InterruptedException
		{
			CRUDMainObject = new CRUDMainPage(driver1);
			CRUDMainObject.deleteData(deleteBtn);
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
}