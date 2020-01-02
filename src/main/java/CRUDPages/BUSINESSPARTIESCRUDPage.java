package CRUDPages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.PageBase;


public class BUSINESSPARTIESCRUDPage extends PageBase {

	public BUSINESSPARTIESCRUDPage(WebDriver driver1) {
		super(driver1);
		driver11 = driver1;
	}

	WebDriver driver11;
	public CRUDMainPage CRUDMainObject;

	

	//Master Page Elements 
		
	@FindBy(css= "#V33SaveButton")public static WebElement master_SaveButton;
	@FindBy(id="V33RefreshButton") WebElement refreshBtn;
	//@FindBy(id="V0LCRepeater_ctl00_V0RowDeleteButton") WebElement deleteBtn;
	//@FindBy(id="V0LCRepeater_ctl00_V0RRowSelection") WebElement selectRowCheckBox;
	
	//Retrieve All and Paging
	@FindBy(id="V33ResetButton") WebElement retrieveAllBtn;
	@FindBy(id="V33Pagination__NextPage") WebElement nextPageBtn;
	@FindBy(id="V33Pagination__PreviousPage") WebElement previousPageBtn;
	@FindBy(id="V33Pagination__LastPage") WebElement lastPageBtn;
	@FindBy(id="V33Pagination__FirstPage") WebElement firstPageBtn;
	
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
		//CRUDMainObject.clickNewRowOnGrid(newRowBtn);
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
		master_SaveButton.click();
	}
	
	// Special case to fill data
	/*public void fillDataToGrid(String MalenameValue,String FemaleNameValue, String Typevalue)
					throws InterruptedException {
		
		setTextElementText(Type, Typevalue);
		setTextElementText(MaleNametxt, MalenameValue);
		setTextElementText(Femalenametxt,FemaleNameValue);
		master_SaveButton.click();
		Thread.sleep(5000);
		
	}*/
}