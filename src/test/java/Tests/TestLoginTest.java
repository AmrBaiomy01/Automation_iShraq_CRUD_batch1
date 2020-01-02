package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class TestLoginTest {

	public static WebDriver driver ; 

	@FindBy (id = "txtUserName")
	WebElement UserName;

	@FindBy (id = "txtpassword")
	WebElement UserPass;

	@FindBy (id = "btnLogin")
	WebElement LoginBtn;


	@Test
	public void setUp() 
	{

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		driver.navigate().to("http://192.168.112.33/I50DEV/Security/SignIn.aspx");


		driver.findElement(By.id("txtUserName")).sendKeys("Administrator");
		driver.findElement(By.id("txtpassword")).sendKeys("admin12");

		driver.findElement(By.id("btnLogin")).click();
		driver.quit();
	}
}


