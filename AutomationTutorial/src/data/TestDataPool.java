package data;

import java.util.HashMap;

import utils.ExcelUtils;

public class TestDataPool {
public static HashMap<String, String> tcData = new HashMap<>();

//Default constructor (will be called when the class is instantiated)
public TestDataPool(){
	try {
		tcData=ExcelUtils.getTestDataXls(Constants.DATAPOOL_PATH, "Automation", 0, 1);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//Parameterized constructor to read any test case data
public TestDataPool(int tcRowNumber){
	try {
		tcData=ExcelUtils.getTestDataXls(Constants.DATAPOOL_PATH, "Automation", 0, tcRowNumber);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
