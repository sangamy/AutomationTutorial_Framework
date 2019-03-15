package pageFlows;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import data.Constants;
import data.TestDataPool;
import infrastructure.Operations;
import pageObjects.RegisterObj;
import utils.ExcelUtils;
import utils.PasswordUtils;
import utils.ReportingUtils;

public class RegisterPage {

	 static Operations op = new Operations();

	public static void registerDetails(WebDriver driver) throws Exception{
		//Contact Info
		/*WebElement ele = driver.findElement(By.xpath(RegisterPageObj.textbox_FirstName));
		ele.sendKeys("First Name");
		*/
		
		//No need to call datapool here, directly call TestDataPool.tcData.get
		//HashMap<String,String> tcData = ExcelUtils.getTestDataXls(Constants.DATAPOOL_PATH, "DemoAut", 0, 1);//comment this

		op.setText(driver, RegisterObj.textbox_FirstName, TestDataPool.tcData.get("firstName1"));//parameterize
		op.setText(driver, RegisterObj.textbox_LastName, TestDataPool.tcData.get("lastName1"));//param
		op.setText(driver, RegisterObj.textbox_Phone, TestDataPool.tcData.get("phone"));
		op.setText(driver, RegisterObj.textbox_Email, TestDataPool.tcData.get("email"));

		//Mailing Info
		op.setText(driver, RegisterObj.textbox_Address1, TestDataPool.tcData.get("address1"));
		op.setText(driver, RegisterObj.textbox_City, TestDataPool.tcData.get("city"));
		op.setText(driver, RegisterObj.textbox_State, TestDataPool.tcData.get("state"));
		op.setText(driver, RegisterObj.textbox_PostalCode, TestDataPool.tcData.get("postalcode"));
		
		/*WebElement ele = driver.findElement(By.xpath(RegisterPageObj.dropdown_Country));
		Select sel = new Select(ele);
		sel.selectByVisibleText("UNITED STATES");
		*/
		op.selectDropdown(driver, RegisterObj.dropdown_Country, TestDataPool.tcData.get("country"));
		op.setText(driver, RegisterObj.textbox_UserName, TestDataPool.tcData.get("userName"));
		String password = PasswordUtils.decryptString(TestDataPool.tcData.get("password"));
		op.setText(driver, RegisterObj.textbox_Password, password);
		op.setText(driver, RegisterObj.textbox_ConfirmPassword, password);

		ReportingUtils.reportResult("Pass", "Registration", "Registration successful!");
		
		op.clickLink(driver, RegisterObj.link_Submit);
	
		op.implicitWait(driver, 30);
		//Thread.sleep(20000);//static wait Not recommended
	}
	
}
