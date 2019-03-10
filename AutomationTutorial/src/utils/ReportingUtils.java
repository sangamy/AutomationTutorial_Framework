package utils;

public class ReportingUtils {
	
	public static void reportResult (String reportComment, String expectedValue, String actualValue){
		if(expectedValue.equals(actualValue))
			System.out.println("Pass - "+reportComment + ": Expected = "+expectedValue+ " & Actual = "+actualValue);
		else
			System.out.println("Fail - "+reportComment + ": Expected = "+expectedValue+ " is NOT same as Actual = "+actualValue);
	
	}

	public static void reportResult (String reportComment, int expectedValue, int actualValue){
		if(expectedValue == actualValue)
			System.out.println("Pass - "+reportComment + ": Expected = "+expectedValue+ " & Actual = "+actualValue);
		else
			System.out.println("Fail - "+reportComment + ": Expected = "+expectedValue+ " is NOT same as Actual = "+actualValue);
	
	}

}
