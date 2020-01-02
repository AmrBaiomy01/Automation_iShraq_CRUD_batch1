package Pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettlementPage extends PageBase {

	public SettlementPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}
	WebDriver driver1;
	FundPage FPage = new FundPage(driver1);


	String settlementModule = "108";

	@FindBy (xpath = "//*[@id=\"txt_PlaceHolder\"]")
	WebElement searchBox;

	@FindBy (id = "V4Pagination__LastPage")
	WebElement getLastPage;

	@FindBy (id = "V4TC_V3TP_V3LCRepeater_ctl00_CST_TRX_CODE")
	WebElement getTransNumber;

	@FindBy (id = "V4POSTButton")
	WebElement postSettlement;

	@FindBy (id = "CS_STATUS")
	WebElement settleStatus;

	@FindBy (css = "#tabs-15002003 > a > span.tabTitle")
	WebElement programScreen;

	@FindBy (css = "#V1RefreshButton")
	WebElement refreshFundPageDetails;
	
	@FindBy(id = "APPROVAL_STATUS")
	public WebElement approvalStatus;


	public void checkSettlement (String SettlementFrame , String PostedFundCode) throws InterruptedException
	{

		Thread.sleep(7000);
		driver1.switchTo().defaultContent();
		waitMethod(5);
		searchBox.clear();
		waitMethod(3);
		searchBox.sendKeys(settlementModule);
		waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		waitMethod(7);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		Thread.sleep(5000);
		switchFrame(SettlementFrame);
		clickButton(getLastPage);
		Thread.sleep(7000);
		waitMethod(5);
		assertEquals(getTransNumber.getAttribute("value"), PostedFundCode);
		//Assert.assertTrue(getTransNumber.getText().equals(fundCode));
		waitMethod(3);
		clickButton(postSettlement);
		ConfirmAlert();
		//waitMethod(5);
		Thread.sleep(7000);
		assertEquals(settleStatus.getAttribute("value"), "Active");
		//waitMethod(5);
		Thread.sleep(7000);
		driver1.switchTo().defaultContent();
		clickButton(programScreen);
		//Thread.sleep(7000);
		waitMethod(5);
		switchFrame("frame_15002003");
		Thread.sleep(7000);
		//waitMethod(5);
		clickButton(refreshFundPageDetails);
		Thread.sleep(7000);
		//waitMethod(5);
		assertEquals(approvalStatus.getAttribute("value"), "ACT");

	}

}
