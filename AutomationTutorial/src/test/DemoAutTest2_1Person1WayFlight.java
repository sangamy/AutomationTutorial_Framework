package test;
//Scenario: Register in Demoaut.com and book a 1-way flight for 1 person and validate the confirmation texts and total price

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

public class DemoAutTest2_1Person1WayFlight {
	
	public static void main(String[] args) throws Exception {

	//Setup
		new TestDataPool(2);
		WebDriver driver = TestRunSetup.launch(Constants.BASE_URL);
		
	//Page flows
		new HomePage().registration(driver);
		new RegisterPage().registerDetails(driver);
		new RegisterConfirmPage().registerConfirm_Dear(driver);
		new RegisterConfirmPage().registerConfirm_Note(driver);
		new FlightFinderPage().clickFlights(driver);
		new FlightFinderPage().flightDetails(driver);
		new FlightFinderPage().preferences(driver);
		new FlightFinderPage().continueButton(driver);
		new  SelectFlightPage().departReturnFlight(driver);
		new BookAFlightPage().summary(driver);
		new BookAFlightPage().passengers(driver);
		new BookAFlightPage().creditcard(driver);
		new FlightConfirmationPage().validation_Confirm(driver);
		new FlightConfirmationPage().logout(driver);

		driver.quit();
	
	}

}
