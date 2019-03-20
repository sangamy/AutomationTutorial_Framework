package data;

import java.util.Random;

public class Constants {

	public static final String CHROMEDRIVER_PATH = "C:\\drivers\\chromedriver.exe";
	public static final String BROWSER_TYPE = "chrome";//firefox, edge
	public static final String BASE_URL = "http://www.demoaut.com";

	//public static final String DATAPOOL_PATH = "C:/AutomationProjects/AutomationTutorial/resource/Datapool.xls";
	//public static final String TESTDATAOUTPUT_PATH= "C:\\AutomationProjects/AutomationTutorial/resource/TestDataOutput.properties";

	Random rand = new Random();
	public static String workingDir = System.getProperty("user.dir"); //C:\\AutomationProjects\\TestAutomation_Selenium
	//public static String datapoolPath = "C:\\AutomationProjects\\SeleniumTutorial\\resource\\TestDataPool_Automation.xls";

	public static final String DATAPOOL_PATH = workingDir + "/resource/Datapool.xls";
	public static final String TESTDATAOUTPUT_PATH= workingDir+ "\\resource/TestDataOutput.properties";
	public static final String CONFIG_PATH= workingDir+ "\\resource/config.properties";

	public static String automationDatapoolPath = workingDir + "\\resources\\TestDataPool_Automation.xls";


	//	public static String screenshotFolderPath = "C:\\Selenium_Logs\\Screenshots\\";
	public static String screenshotFolderPath = "C:\\Selenium_Logs\\Screenshots\\";

	public static String configPath = "C:/AutomationProjects/SeleniumTutorial/src/config/config.properties";
	public static int counter = 0;

	public static String dataPool_Xls = "C:\\AutomationProjects\\SeleniumTutorial\\resource\\TestDataPool_Automation.xls"; 
	public static String dataPool_Xlsx = "C:/Selenium_Logs/TestData/Datapool.xlsx"; // \\=/

}
