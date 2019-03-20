package test;

import org.openqa.selenium.WebDriver;

import data.TestDataPool;
import pageFlows.ToolsQaPage;
import setup.TestRunSetup;

public class ToolsQA_TestCase3 {

	public static void main(String[] args) {
		System.out.println("######## Test Case Starts - ToolsQA #########");

		//Setup
		new TestDataPool(3);	
		WebDriver driver = null;
		driver =TestRunSetup.launch("https://www.toolsqa.com/automation-practice-form/");
		
		// Page Flows 
		ToolsQaPage.practiveAutomationForm(driver);
		
		// Tear-down
		driver.close();
		System.out.println("######## Test Case Ends - ToolsQA #########");

	}

}
