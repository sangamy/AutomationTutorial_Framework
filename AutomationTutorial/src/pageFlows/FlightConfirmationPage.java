package pageFlows;

import org.openqa.selenium.WebDriver;

import data.Constants;
import data.TestDataPool;
import infrastructure.Operations;
import pageObjects.FlightConfirmationObj;
import utils.PropertyUtils;
import utils.ReportingUtils;

public class FlightConfirmationPage {

	Operations op = new Operations();
	public void validation_Confirm(WebDriver driver){

		//Expected Values ( declare and define the values)
		String expected_ConfirmationText = "Your itinerary has been booked!"; //Refer to Requirement/Test case
		String expected_Departing_City = TestDataPool.tcData.get("departingFromCity") ;
		String expected_Arriving_City = TestDataPool.tcData.get("arrivingInCity");
		String expected_Depart_Class = TestDataPool.tcData.get("class");
		String expected_Depart_price = PropertyUtils.propertyFile_Read(Constants.TESTDATAOUTPUT_PATH, "departPrice");

		System.out.println("#### Flight Confirmation ####");
		String actual_ConfirmationText = op.getText(driver, FlightConfirmationObj.text_Confirmation);
		String actual_DepartingInfo = op.getText(driver, FlightConfirmationObj.text_DepartingInfo);
		String actual_ReturningInfo = op.getText(driver, FlightConfirmationObj.text_ReturningInfo);
		String actual_Passengers = op.getText(driver, FlightConfirmationObj.text_PassengerInfo);
		String actual_Tax = op.getText(driver, FlightConfirmationObj.text_Tax);
		String actual_TotalPrice = op.getText(driver, FlightConfirmationObj.text_TotalPrice);


		/*String cities[]= actual_DepartingInfo.split("[ to ]"); //New York to Paris 
		String actual_Departing_City =cities[0] ;
		String actual_Arriving_City = cities[1];
		System.out.println("actual_Departing_City = "+actual_Departing_City);
		System.out.println("actual_Arriving_City = "+actual_Arriving_City);
		 */
		System.out.println("***************departing Info *******************");
		//Departing City
		int departBeginIndex_City = 0;
		System.out.println("departBeginIndex_City = "+departBeginIndex_City);
		int departEndIndex_City = actual_DepartingInfo.indexOf(" to");
		System.out.println("departEndIndex_City = "+departEndIndex_City);
		String actual_Departing_City= actual_DepartingInfo.substring(departBeginIndex_City, departEndIndex_City);
		System.out.println("actual_Departing_City = "+actual_Departing_City);		

		//Arriving City

		int arriveBeginIndex_City = actual_DepartingInfo.indexOf("to ");
		System.out.println("departBeginIndex_City = "+arriveBeginIndex_City);
		String[] departEndIndex_City_array = actual_DepartingInfo.split("[0-9]+[/][0-9]{2}[/][0-9]{4}");

		System.out.println(departEndIndex_City_array[0]);
		String arrivingInCity =departEndIndex_City_array[0].substring(arriveBeginIndex_City+3);
		System.out.println(" arrivingInCity = "+arrivingInCity);


		//TODO Date   
		String arriveCity = TestDataPool.tcData.get("arrivingInCity");// Paris
		String actual_DepartingInfo_Date = actual_DepartingInfo.substring(actual_DepartingInfo.indexOf(arriveCity)+arriveCity.length(), actual_DepartingInfo.indexOf(" @ "));

		//First class
		int departBeginIndex_class = actual_DepartingInfo.indexOf('F'); System.out.println("departBeginIndex_class="+departBeginIndex_class);
		int departEndIndex_class = actual_DepartingInfo.indexOf('$'); System.out.println("departEndIndex_class="+departEndIndex_class);

		String actual_Depart_Class = actual_DepartingInfo.substring(departBeginIndex_class, departEndIndex_class);
		System.out.println("depart_Class="+actual_Depart_Class);

		//Depart price
		int departBeginIndex_price = actual_DepartingInfo.indexOf('$')+1; System.out.println("departBeginIndex_price="+departBeginIndex_price);
		int departEndIndex_price = actual_DepartingInfo.lastIndexOf(' '); System.out.println("departEndIndex_price="+departEndIndex_price);
		//int departEndIndex2 = departFlightPrice.indexOf("each")-1;

		String actual_Depart_price = actual_DepartingInfo.substring(departBeginIndex_price, departEndIndex_price);
		System.out.println("depart_price="+actual_Depart_price);

		System.out.println("***************returning Info *******************");
		//returning City
		int returnBeginIndex_City = 0;
		System.out.println("returnBeginIndex_City = "+returnBeginIndex_City);
		int returnEndIndex_City = actual_ReturningInfo.indexOf(" to");
		System.out.println("returnEndIndex_City = "+returnEndIndex_City);
		String actual_returning_City= actual_ReturningInfo.substring(returnBeginIndex_City, returnEndIndex_City);
		System.out.println("actual_returning_City = "+actual_returning_City);		

		//Arriving City

		int returnBeginIndex_City2 = actual_ReturningInfo.indexOf("to ");
		System.out.println("returnBeginIndex_City = "+arriveBeginIndex_City);
		String[] returnEndIndex_City_array = actual_ReturningInfo.split("[0-9]+[/][0-9]{2}[/][0-9]{4}");

		System.out.println(returnEndIndex_City_array[0]);
		String arrivingInCity2 =returnEndIndex_City_array[0].substring(returnBeginIndex_City2+3);

		System.out.println(" arrivingInCity = "+arrivingInCity2);

		//First class
		int returnBeginIndex_class = actual_ReturningInfo.indexOf('F'); System.out.println("returnBeginIndex_class="+returnBeginIndex_class);
		int returnEndIndex_class = actual_ReturningInfo.indexOf('$'); System.out.println("returnEndIndex_class="+returnEndIndex_class);

		String return_Class = actual_ReturningInfo.substring(returnBeginIndex_class, returnEndIndex_class);
		System.out.println("return_Class="+return_Class);

		//return price
		int returnBeginIndex_price = actual_ReturningInfo.indexOf('$')+1; System.out.println("returnBeginIndex_price="+returnBeginIndex_price);
		int returnEndIndex_price = actual_ReturningInfo.lastIndexOf(' '); System.out.println("returnEndIndex_price="+returnEndIndex_price);
		//int returnEndIndex2 = returnFlightPrice.indexOf("each")-1;

		String return_price = actual_ReturningInfo.substring(returnBeginIndex_price, returnEndIndex_price);
		System.out.println("return_price="+return_price);

		System.out.println("-------Passengers-------");
		actual_Passengers=actual_Passengers.replaceAll("[ passengers]", "");
		System.out.println("actual_Passengers = "+actual_Passengers);

		System.out.println("-------Tax-------");
		actual_Tax = actual_Tax.substring(1,actual_Tax.indexOf(' ') );
		System.out.println("actual_Tax = "+actual_Tax);

		System.out.println(" ------- Total price ------");
		actual_TotalPrice = actual_TotalPrice.substring(1, actual_TotalPrice.indexOf(' '));
		System.out.println("actual_TotalPrice = "+ actual_TotalPrice);;

		System.out.println("******** Validation *********");
		/*if(expected_ConfirmationText.equals(actual_ConfirmationText))
			System.out.println("Pass - expected_ConfirmationText = actual_ConfirmationText");
		else
			System.out.println("Pass - expected_ConfirmationText != actual_ConfirmationText");
		 */
		//Validation - Confirmation text
		String verdict_confirmText = ReportingUtils.compare(expected_ConfirmationText, actual_ConfirmationText);
		ReportingUtils.reportResult("Done", "Flight Confirmation", "Flight Confirmation Text Validation"+actual_ConfirmationText);

		//Validation - Depart City
		String verdict_DepartCity = ReportingUtils.compare(expected_Departing_City, actual_Departing_City);
		ReportingUtils.reportResult("Done", "Flight Confirmation - Departing City" , "Flight confirmation for departing city"+actual_Departing_City);

		//Validation - Return City
		String verdict_ReturnCity = ReportingUtils.compare(expected_Arriving_City, actual_returning_City);
		ReportingUtils.reportResult("Done", "Flight Confirmation - Returning City" , "Flight confirmation for returning city"+actual_returning_City);

		//Validation - Class
		ReportingUtils.reportResult("Done", "Flight confirmation - Class", "Flight confirmation Class - "+actual_Depart_Class);

		//Validation - Depart Price
		ReportingUtils.reportResult("Done", "Flight Depart Price", "Depart Price-"+actual_Depart_price);

		//Validation - Returning City
		ReportingUtils.reportResult("Done", "Flight Returning ", "Returning Flight-"+actual_returning_City);

		//Validation - Returning Class
		ReportingUtils.reportResult("Done", "Flight Class ", "Returning Class-"+actual_Depart_Class);

		//Validation Returning price
		ReportingUtils.reportResult("Done", "Flight Return price ", "Returning Price-"+ "");

		// Validation - No of passengers
		ReportingUtils.reportResult("Done", "Flight No of Passengers ", "Passengers-"+ actual_Passengers);

		// Validation - Tax
		ReportingUtils.reportResult("Done", "Flight - tax ", "Tax-"+ actual_Tax);


		// Validation - Total price
		ReportingUtils.reportResult("Done", "Flight - Total price ", "Total price-"+ actual_TotalPrice);


		// Flight confirmation screenshot
		ReportingUtils.reportResult("Pass", "Flight Confirmation", "Flight confirmation final validation");



	}

	public void logout(WebDriver driver){
		op.clickLink(driver, FlightConfirmationObj.button_Logout);
	}
}
