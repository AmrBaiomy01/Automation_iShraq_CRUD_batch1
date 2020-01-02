package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;

//import testData.JsonDataReader;
import TestData.JsonDataReaderOnPage;


public class PortfolioActivationDeActivationModuleHandler extends PageBase {
	
	public PortfolioActivationDeActivationModuleHandler(WebDriver driver1) {
		super(driver1);
		driver11 = driver1;
	}
	
	WebDriver driver11;
	//static List<String> webElements = new ArrayList<String>();
	
	@FindBy(id= "SaveButton__Button")
	public static WebElement master_SaveButton;

	@FindBy(xpath = "//*[@id=\"V1CopyButton\"]")
	public static WebElement ApproveButton;

	@FindBy (css = "#contact_01 > div > div.col-lg-11 > div.row > div:nth-child(2) > div > div.VisitedModules > ul")
	WebElement lastVisitedModules;
	
	@FindBy (id = "txt_PlaceHolder")
	WebElement searchBox;
	
	@FindBy (css = "#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-footer.text-center > button	")
	WebElement confirmSaveMsg;
	
	@FindBy (id = "POSTButton")
	WebElement postButton;
	
	@FindBy (css = "#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-footer.text-center > button")
	WebElement confirmPostMsg;
	
	public void FillModuleFields(String moduleID) throws InterruptedException, FileNotFoundException, IOException, ParseException 
	
	{

//		//1- Navigate To Module
//		NavigateToModuleWebPage(moduleID);
//
//		//2- Read Fields and Values from Json file
//		//JSONArray jsonObjects = JsonDataReader.ReadFromJson(moduleID);
//
//		//3- Add modules values to fields
//		Boolean dataAdded = false;
//		for (int i = 0; i < jsonObjects.size(); i++) {
//			dataAdded = AddModuleFieldsValues(moduleID, jsonObjects, i);
//		}
//
//		//4- Save module when dataAdded;
//		if (dataAdded) {
//			//JavascriptExecutor jse = (JavascriptExecutor) driver1;
//			//jse.executeScript("document.getElementById('V1SaveButton').focus();");
//
//			Thread.sleep(2000);
//			// Approve FacilityRequest
//			master_SaveButton.click();
//			Thread.sleep(5000);
//			confirmSaveMsg.click();
//			Thread.sleep(2000);
//			postButton.click();
//			waitForConfirmationMsg();
//			ConfirmAlert();
//			Thread.sleep(5000);
//			confirmPostMsg.click();
//			//ApproveButton.click();
//			//Thread.sleep(2000);
//			//Alert alert = driver1.switchTo().alert();
//			//alert.accept();
//		}
//
//		

	}

	private void NavigateToModuleWebPage(String moduleID) throws InterruptedException {
		// TODO Auto-generated method stub
		//driver1.switchTo().frame("RAD_SPLITTER_PANE_EXT_CONTENT_RightRadPane");
		///WebDriverWait wait = new WebDriverWait(driver11, 10);
		///wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_PlaceHolder")));
		Thread.sleep(15000);
		waitForElement(lastVisitedModules);
		waitForElement(searchBox);
		driver1.findElement(By.id("txt_PlaceHolder")).sendKeys(moduleID);
		WebElement x = driver1.findElement(By.id("txt_PlaceHolder"));
		x.sendKeys(Keys.ENTER);
		x.sendKeys(Keys.SHIFT, Keys.ENTER);
		
		waitForFrame("frame" + "_" + moduleID);
		//driver1.switchTo().frame(driver1.findElement(By.cssSelector("iframe[id$='" + moduleID + "']")));
	}

	
	private Boolean AddModuleFieldsValues(String moduleID, JSONArray blockJsonObjects, int blockIndex) throws InterruptedException 
	
	{
		// TODO Auto-generated method stub
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

	//Set data from Json Object to a detail block
	private static void SetDataForDetailBlock(WebDriver driver1, JSONObject jsonObject, List<String> blockElements,
			String blockMinifiedName) throws InterruptedException {

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

	//Set data from Json Object to a master block
	private static void SetDataForMasterBlock(WebDriver driver1, JSONArray jsonFields, List<String> blockElements)
			throws InterruptedException {

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

	//Add new record to tabular block by clicking Add button
	private static void AddTabullarRecord(WebDriver driver1, String minifiedName) throws InterruptedException {
		// TODO Auto-generated method stub

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

}
