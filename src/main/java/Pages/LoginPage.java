package Pages;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}

	WebDriver driver1;

	//TestBase testBaseObj;

	@FindBy (id="txtUserName")WebElement LoginName;

	@FindBy (id = "txtpassword")WebElement Loginpassword;

	@FindBy (id = "chkremember")WebElement Rememberme;

	@FindBy (id = "btnLogin")WebElement Loginbtn;

	@FindBy (id = "txt_PlaceHolder")WebElement searchBox;

	@FindBy (css = "#todayTasks")WebElement todayTasksPart;


	public void UserLogin(Hashtable<String,String> loginData) throws InterruptedException
	{
		//use the hashtable to read data from Json file with the exact key defined in json file UserName and UserPass
		setTextElementText(LoginName, loginData.get("UserName"));
		setTextElementText(Loginpassword, loginData.get("UserPass"));
		Checkingcheckbox(Rememberme);
		clickButton(Loginbtn);

	}
}
