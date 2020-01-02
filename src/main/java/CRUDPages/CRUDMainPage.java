package CRUDPages;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Strings;

import Pages.PageBase;

public class CRUDMainPage extends PageBase{

	public CRUDMainPage(WebDriver driver) {
		super(driver);

	}

	@FindBy (id = "txt_PlaceHolder")WebElement searchBox;
	@FindBy(id = "V0AddButton") WebElement newRowBtn;

	//1
	public void NavigateToModuleWebPage(String moduleID,String ParentframeID) throws InterruptedException {

		driver1.switchTo().defaultContent();
		waitForElement(searchBox);
		searchBox.clear();
		searchBox.sendKeys(moduleID);
		waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);		
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		waitForFrame(ParentframeID);
		waitMethod(7);

	}

	//2
	public Boolean AddModuleFieldsValues(String moduleID, JSONArray blockJsonObjects, 
			int blockIndex) throws InterruptedException 

	{
		List<String> webElements = GetModuleWebPageElements(driver1);

		JSONObject object = (JSONObject) blockJsonObjects.get(blockIndex);
		JSONArray fields = (JSONArray) object.get("Fields");

		//Add data for Master Block
		if (object.containsValue("Master Block")) 
		{
			SetDataForMasterBlock(driver1, fields, webElements);
			return true;
		} 
		else //Add data for Detail Block
		{
			String blockMinifiedName = object.get("MinifiedName").toString();
			String tabName = "[id$=" + blockMinifiedName + "TP_tab]"; // V11TC_V12TP_tab
			if (driver1.findElements(By.cssSelector(tabName)).size() != 0) 
			{
				WebElement element = driver1.findElement(By.cssSelector(tabName));
				if (element.isDisplayed()) 
				{
					element.click();
					webElements = GetModuleWebPageElements(driver1);
				}
			}
			SetDataForDetailBlock(driver1, object, webElements, blockMinifiedName);
			return true;
		}
	}

	//3
	private static List<String> GetModuleWebPageElements(WebDriver driver1) throws InterruptedException 
	{

		List<WebElement> webElements = driver1.findElements(By.cssSelector("input[type=\"text\"]:not([disabled]),"
				+ "												input[type=\"checkbox\"]:not([disabled]),"
				+ "												input[type=\"image\"]:not([disabled]),"
				+ "												select:not([disabled]),"
				+ "												textarea:not([disabled])"));


		List<String> elementIDs = new ArrayList<String>();
		for (WebElement webElement : webElements) 
		{
			if (webElement.getAttribute("name") != null && !webElement.getAttribute("name").endsWith("Filter")
					&& !webElement.getAttribute("name").contains("Pagination")) 
			{
				elementIDs.add(webElement.getAttribute("name"));
			}

		}
		return elementIDs;
	}

	//4 Set data for Json Object to a detail block
	private static void SetDataForDetailBlock(WebDriver driver1,JSONObject jsonObject,
			List<String> blockElements,String blockMinifiedName) throws InterruptedException {

		JSONArray jsonFields = (JSONArray) jsonObject.get("Fields");
		String blockLayoutType = jsonObject.get("BlockType").toString();
		boolean recordAdded = false;

		for (int j = 0; j < jsonFields.size(); j++) {
			String fieldName = ((JSONObject) jsonFields.get(j)).get("Field").toString();
			String fieldValue = ((JSONObject) jsonFields.get(j)).get("Value").toString();

			//In case a new tabular record is not added, add it and reload module elements 
			if (blockLayoutType.equals("T") && !recordAdded && !Strings.isNullOrEmpty(fieldValue)) 
			{
				
				AddTabullarRecord(driver1, blockMinifiedName);
				blockElements = GetModuleWebPageElements(driver1);
				recordAdded = true;
			}
			//Fill tabular fields
			for (String blockElement : blockElements) 
			{
				if (blockElement.matches(".*\\$" + fieldName + "[0-9]*") && blockElement.contains(blockMinifiedName)) 
				{
					WebElement element = driver1.findElement(By.name(blockElement));
					if (element.isDisplayed()) {
						element.sendKeys(fieldValue);
						Thread.sleep(250);
					}

				}
			}
		}
	}

	//5 Set data from Json Object to a master block
	private static void SetDataForMasterBlock(WebDriver driver1, JSONArray jsonFields, 
			List<String> blockElements)	throws InterruptedException {

		for (int j = 0; j < jsonFields.size(); j++) 
		{
			String fieldName = ((JSONObject) jsonFields.get(j)).get("Field").toString();
			String fieldValue = ((JSONObject) jsonFields.get(j)).get("Value").toString();
			if (blockElements.contains(fieldName)) 
			{
				if (driver1.findElements(By.id(fieldName)).size() != 0) 
				{
					WebElement element = driver1.findElement(By.id(fieldName));
					if (element.isDisplayed()) {
						element.sendKeys(fieldValue);
						Thread.sleep(250);
					}
				}

			}
		}
	}

	//6 Add new record to tabular block by clicking Add button
	private static void AddTabullarRecord(WebDriver driver1, String minifiedName) throws InterruptedException {

		String blockAddButtonID = minifiedName + "AddButton";
		if (driver1.findElements(By.cssSelector("[id$=" + blockAddButtonID + "]")).size() != 0) 
		{
			WebElement element = driver1.findElement(By.cssSelector("[id$=" + blockAddButtonID + "]"));
			if (element.isDisplayed()) {
				element.click();
			}
			Thread.sleep(1000);
		}
	}

	//6-Update 
	public void updateData(WebElement element,String updateNameValue) throws InterruptedException
	{
		setTextElementText(element, updateNameValue);
		Thread.sleep(1000);
	}
	//7- Delete 
	public void deleteData(WebElement deleteBtn) throws InterruptedException
	{
		clickButton(deleteBtn);
		Thread.sleep(5000);
		ConfirmAlert();
		Thread.sleep(5000);
	}
	//8- Open filter area and filter by any record
	public void filterByRecords(WebElement filterAreaBtn,String filterAreaFrame,
			WebElement goToLastPageBtn,WebElement selectRowBtn,WebElement filterBtn,
			String parentframeID) throws InterruptedException {

		clickButton(filterAreaBtn);
		switchFrame(filterAreaFrame);
		waitMethod(10);
		clickButton(goToLastPageBtn);
		Thread.sleep(3000);
		clickButton(selectRowBtn);
		clickButton(filterBtn);
		Thread.sleep(6000);
		switchFrame(parentframeID);
	}
	// 9- Retrieve All and Paging
	public void retrieveAllAndPaging(WebElement retrieveAllBtn,WebElement nextPageBtn,
			WebElement previousPageBtn,WebElement lastPageBtn, WebElement firstPageBtn) throws InterruptedException {

		Thread.sleep(2000);
		clickButton(retrieveAllBtn);
		waitMethod(7);
		clickButton(nextPageBtn);
		waitMethod(5);
		clickButton(previousPageBtn);
		clickButton(lastPageBtn);
		waitMethod(5);
		clickButton(firstPageBtn);
	}

	// Only for Grid screens
	public void clickNewRowOnGrid(WebElement newRowBtn) throws InterruptedException
	{
		clickButton(newRowBtn);
		Thread.sleep(3000);

	}
}
