package pageFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infrastructure.Operations;
import pageObjects.RegisterConfirmObj;

public class RegisterConfirmPage {

	Operations op = new Operations();
	public void registerConfirm_Dear(WebDriver driver){
		
		//String capturedValue = driver.findElement(By.xpath(RegisterConfirmPageObj.text_DearFnLn)).getText();
		//return capturedValue;
		
		String actualValue_RegConfDear = op.getText(driver, RegisterConfirmObj.text_DearFnLn);
		String expectedValue_RegConfDear = "Dear Selenium Automation,";//Requirement 

		
		// Validation
		if(expectedValue_RegConfDear.equals(actualValue_RegConfDear))
			System.out.println("Pass - Dear confirmation :: "+ expectedValue_RegConfDear);
		else
			System.out.println("Fail - Dear confirmation");

		
		
		
		
	}
	
	
	//Validation of Note
	
	public void registerConfirm_Note(WebDriver driver){
		//String actualValue_Note = driver.findElement(By.xpath(RegisterConfirmPageObj.text_Note)).getText();
	
		
	String expectedValue_Note = "Note: Your user name is automationuser.";
	String actualValue_Note = op.getText(driver, RegisterConfirmObj.text_Note);
	
	//Validation
	if(expectedValue_Note.equals(actualValue_Note))
		System.out.println("Pass - Note confirmation :: "+ actualValue_Note);
	else
		System.out.println("Fail - Note confirmation :: "+ actualValue_Note + " is not same as "+expectedValue_Note);
	
	op.implicitWait(driver, 30);

	}
	
		

	
}
