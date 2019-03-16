package utils;

public class StringUtils {
	
	//Get substring of a string
	
	public static String subString(String fullString, String beginIndex, String endIndex){
		
		int beginIndexInt = fullString.indexOf(beginIndex)+beginIndex.length();
		int endIndexInt = fullString.indexOf(endIndex);

		String subSt = fullString.substring(beginIndexInt, endIndexInt);
		
		System.out.println("Substring = "+subSt);
		return subSt;
			
	}

public static String subString(String fullString, char beginIndex, char endIndex){
		
		int beginIndexInt = fullString.indexOf(beginIndex);
		int endIndexInt = fullString.indexOf(endIndex);

		String subSt = fullString.substring(beginIndexInt, endIndexInt);
		
		return subSt;
			
	}


// Remove a part of string
public static String replaceString (String fullString, String replaceFor, String replaceWith){
	
	String finalString = fullString.replaceAll("["+replaceFor+"]", replaceWith);
	
	System.out.println("Replaced String = "+finalString);
	return finalString;
	
	
}


}
