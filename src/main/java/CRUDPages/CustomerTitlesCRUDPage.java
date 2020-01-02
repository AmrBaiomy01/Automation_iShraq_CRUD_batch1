package CRUDPages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.PageBase;


public class CustomerTitlesCRUDPage extends PageBase {

	public CustomerTitlesCRUDPage(WebDriver driver1) {
		super(driver1);
		driver11 = driver1;
	}

	WebDriver driver11;
	public CRUDMainPage CRUDMainObject;

	

	//Master Page Elements 
	@FindBy(id="V0AddButton") WebElement newRowBtn;
	@FindBy(id="V0LCRepeater_ctl00_TIT_TYPE") WebElement Type;
	@FindBy(id="V0LCRepeater_ctl00_TIT_MALE_LATIN_NAME") WebElement MaleNametxt;
	@FindBy(id="V0LCRepeater_ctl00_TIT_FEMALE_LATIN_NAME") WebElement Femalenametxt;	
	@FindBy(id="V0SaveButton")public static WebElement master_SaveButton;
	@FindBy(id="V0RefreshButton") WebElement refreshBtn;
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
	
	@FindBy (id="V1LCRepeater_ctl00_V0RowDeleteButton")	WebElement deleteRowBtn;
	@FindBy (id="filterBtn") WebElement filterBtn;
	
	

	//Start Point
	public void FillModuleFields(String moduleID,String ParentframeID)
			throws InterruptedException, FileNotFoundException, IOException, ParseException 

	{
		CRUDMainObject = new CRUDMainPage(driver1);
		//1- Navigate To Module
		CRUDMainObject.NavigateToModuleWebPage(moduleID, ParentframeID);
		CRUDMainObject.clickNewRowOnGrid(newRowBtn);
		
	}
	//5-Update 
	public void updateData(String updateNameValue) throws InterruptedException
	{
		CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.updateData(MaleNametxt, updateNameValue);
		master_SaveButton.click();
		Thread.sleep(5000);
	}
	//6- Delete 
	public void deleteData() throws InterruptedException
	{
		CRUDMainObject = new CRUDMainPage(driver1);
		clickButton(refreshBtn);
		waitMethod(2);
		clickButton(deleteBtn);
		waitMethod(10);
		//Thread.sleep(2000);
		//CRUDMainObject.deleteData(deleteBtn);
		ConfirmAlert();
		Thread.sleep(1000);
		//master_SaveButton.click();
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
	public void fillDataToGrid(String MalenameValue,String FemaleNameValue, String Typevalue)
					throws InterruptedException {
		
		setTextElementText(Type, Typevalue);
		setTextElementText(MaleNametxt, MalenameValue);
		setTextElementText(Femalenametxt,FemaleNameValue);
		master_SaveButton.click();
		Thread.sleep(5000);
		
	}
}