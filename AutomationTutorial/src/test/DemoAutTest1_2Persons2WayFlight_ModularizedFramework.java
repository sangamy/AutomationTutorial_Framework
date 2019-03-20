package test;
//Scenario: Register in Demoaut.com and book a 2-way flight for 2 persons and validate the confirmation texts and total price
import org.openqa.selenium.WebDriver;

import data.Constants;
import data.TestDataPool;
import pageFlows.BookAFlightPage;
import pageFlows.FlightConfirmationPage;
import pageFlows.FlightFinderPage;
import pageFlows.HomePage;
import pageFlows.RegisterConfirmPage;
import pageFlows.RegisterPage;
import pageFlows.SelectFlightPage;
import setup.TestRunSetup;

public class DemoAutTest1_2Persons2WayFlight_ModularizedFramework {

	public static void main(String[] args){
		WebDriver driver = null;
		try {
			System.out.println("######## Test Case Starts - DemoAutTest_ModularizedFramework #########");
			//Global Variables
			String browser =  Constants.BROWSER_TYPE;
			String url = Constants.BASE_URL;

			//Setup
			new TestDataPool(1);
			driver = TestRunSetup.launch(url);	

			//Home Page - Registration click
			new HomePage().registration(driver);

			//Register - Filling in the registration details
			RegisterPage.registerDetails(driver);

			//Register - Confirmation Validation - Dear statementy
			new RegisterConfirmPage().registerConfirm_Dear(driver);

			//Homework: Capture and Validation - Note: Your user name is automationuser.
			new RegisterConfirmPage().registerConfirm_Note(driver);

			//Flight Reservation
			new FlightFinderPage().clickFlights(driver);
			new FlightFinderPage().flightDetails(driver);
			new FlightFinderPage().preferences(driver);
			new FlightFinderPage().continueButton(driver);

			//Select Flight
			new  SelectFlightPage().departReturnFlight(driver);

			//TODO Book A Flight
			new BookAFlightPage().summary(driver);
			new BookAFlightPage().passengers(driver);
			new BookAFlightPage().creditcard(driver);
			
			//Flight Confirmation - Validation
			new FlightConfirmationPage().validation_Confirm(driver);
			
			//TODO Sign out
			new FlightConfirmationPage().logout(driver);



		} catch (Exception e) {
			e.printStackTrace();
			//throw e;// Stop the execution
		}

		finally{
			driver.close();
			System.out.println("######## Test Case Ends - DemoAutTest_ModularizedFramework #########");

		}


	}

}
