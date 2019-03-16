package test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import utils.KeyboardUtils;
import utils.PasswordUtils;
import utils.StringUtils;

public class playground {

	public static void main(String[] args) throws Exception {
		StringUtils.subString("Selenium Automation", "um ", "ma");
		StringUtils.replaceString("$12345", "$", "");
		
		
	/*	KeyboardUtils.Key_Tab();
		KeyboardUtils.typeString("C:\\directory\\file.extension");
		KeyboardUtils.Key_Enter();
		*/
		
		PasswordUtils.encryptString("password123");
		PasswordUtils.decryptString("2eba4sy8o1e2t+aZ0U4dXw==");
		
		String x = "New York to Paris";
		int y = x.indexOf("to ");
		System.out.println(y);
		System.out.println(x.substring(y+3));
		

		String x1 = "Paris to New York";
		int y1 = x1.indexOf("to ");
		System.out.println(y1);
		System.out.println(x1.substring(y1+3));
		
	String actual_DepartingInfo = "New York to Paris 3/20/2019 @ 11:24 w/ Unified Airlines 363 First $281 each";
	int departBeginIndex_City = actual_DepartingInfo.indexOf(" to ");
	System.out.println("departBeginIndex_City = "+departBeginIndex_City);
	String[] departEndIndex_City_array = actual_DepartingInfo.split("[0-9]+[/][0-9]{2}[/][0-9]{4}");
	
	
	System.out.println("array:");
	System.out.println(departEndIndex_City_array[0]);

	//String depart = departEndIndex_City_array[0];
	
	String arrivingInCity =departEndIndex_City_array[0].substring(departBeginIndex_City+4);
	
	System.out.println(" arrivingInCity = "+arrivingInCity);
			
	//System.out.println("departEndIndex_City = "+departEndIndex_City);

	//String actual_Departing_City= actual_DepartingInfo.substring(departBeginIndex_City, departEndIndex_City);
	//System.out.println("actual_Departing_City = "+actual_Departing_City);		
		
	
		
	
	
	}

}
