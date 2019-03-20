package pageFlows;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.Constants;
import data.TestDataPool;
import infrastructure.Operations;
import pageObjects.BookAFlightObj;
import utils.ExcelUtils;
import utils.PropertyUtils;
import utils.ReportingUtils;

public class BookAFlightPage {
	Operations op = new Operations();

	public void summary(WebDriver driver){
		System.out.println("\n ##### BookAFlightPage - summary #####\n");
		//String departPrice = 	driver.findElement(By.xpath(BookAFlightObj.table_DepartPrice)).getText();
		String departPrice = op.getText(driver, BookAFlightObj.table_DepartPrice);

		//Write to Property File
		PropertyUtils.propertyFile_Write(Constants.TESTDATAOUTPUT_PATH, "departPrice", departPrice);

		String returnPrice = op.getText(driver, BookAFlightObj.table_ReturnPrice);
		String noOfPassengers = op.getText(driver, BookAFlightObj.table_NoOfPassengers);

		String taxes = op.getText(driver, BookAFlightObj.table_taxes);
		String totalPrice = op.getText(driver, BookAFlightObj.table_TotalPrice);

		taxes = taxes.substring(1); //$96
		System.out.println("Modified tax = "+taxes);

		totalPrice = totalPrice.replaceAll("[$]", ""); //1264
		System.out.println("Modified total price = "+totalPrice);

		// Parsing
		int departPriceInt = Integer.parseInt(departPrice);
		int returnPriceInt = Integer.parseInt(returnPrice);
		int noOfPassengersInt = Integer.parseInt(noOfPassengers);

		int taxesInt = Integer.parseInt(taxes);
		int totalPriceInt = Integer.parseInt(totalPrice);
		//double taxesDouble = Double.parseDouble(taxes);
		//long totalPriceLong = Long.parseLong(totalPrice);

		//Validation
		int expectedTotalPrice = (departPriceInt+returnPriceInt)*noOfPassengersInt + taxesInt  ; //Requirement : totalprice= (departprice+returnprice)*totalnoofpassengers+taxes
		int actualTotalPrice = totalPriceInt; //Runtime webpage

		ReportingUtils.reportSimple("Total Flight Price", expectedTotalPrice, actualTotalPrice);
		/*if(expectedTotalPrice == actualTotalPrice )
		System.out.println("Pass - expectedTotalPrice == actualTotalPrice");
	else
		System.out.println("Fail - expectedTotalPrice NOT equal to actualTotalPrice");

		 */
	}

	public void passengers(WebDriver driver) throws Exception{
		System.out.println("\n ##### BookAFlightPage - Passengers #####\n");

		String noOfPassengers = TestDataPool.tcData.get("passengers");
		
		switch (noOfPassengers) {
		case "1":
			op.setText(driver, BookAFlightObj.textbox_firstName1, TestDataPool.tcData.get("firstName1"));
			op.setText(driver, BookAFlightObj.textbox_lastName1, TestDataPool.tcData.get("lastName1"));
			op.selectDropdown(driver, BookAFlightObj.dropdown_Meal1, TestDataPool.tcData.get("meal"));
			
			break;

		case "2":
			op.setText(driver, BookAFlightObj.textbox_firstName1, TestDataPool.tcData.get("firstName1"));
			op.setText(driver, BookAFlightObj.textbox_lastName1, TestDataPool.tcData.get("lastName1"));
			op.selectDropdown(driver, BookAFlightObj.dropdown_Meal1, TestDataPool.tcData.get("meal"));
			
			op.setText(driver, BookAFlightObj.textbox_firstName2, TestDataPool.tcData.get("firstName2"));
			op.setText(driver, BookAFlightObj.textbox_lastName2, TestDataPool.tcData.get("lastName2"));
			op.selectDropdown(driver, BookAFlightObj.dropdown_Meal2, TestDataPool.tcData.get("meal"));

			break;
		case "3":
			op.setText(driver, BookAFlightObj.textbox_firstName1, TestDataPool.tcData.get("firstName1"));
			op.setText(driver, BookAFlightObj.textbox_lastName1, TestDataPool.tcData.get("lastName1"));
			op.selectDropdown(driver, BookAFlightObj.dropdown_Meal1, TestDataPool.tcData.get("meal"));
			
			op.setText(driver, BookAFlightObj.textbox_firstName2, TestDataPool.tcData.get("firstName2"));
			op.setText(driver, BookAFlightObj.textbox_lastName2, TestDataPool.tcData.get("lastName2"));
			op.selectDropdown(driver, BookAFlightObj.dropdown_Meal2, TestDataPool.tcData.get("meal"));

			op.setText(driver, BookAFlightObj.textbox_firstName3, TestDataPool.tcData.get("firstName2"));
			op.setText(driver, BookAFlightObj.textbox_lastName3, TestDataPool.tcData.get("lastName2"));
			op.selectDropdown(driver, BookAFlightObj.dropdown_Meal3, TestDataPool.tcData.get("meal"));

			break;
		default:
			break;
		}
		
		
		

	}


	public void creditcard(WebDriver driver) {
		System.out.println("\n ##### BookAFlightPage - Credit card #####\n");

		try {
			op.selectDropdown(driver, BookAFlightObj.dropdown_CreditCardType, TestDataPool.tcData.get("creditCardType"));
			op.setText(driver, BookAFlightObj.textbox_CreditCardNumber, TestDataPool.tcData.get("creditCardNumber"));

			String creditCardExp = TestDataPool.tcData.get("creditCardExpiry");

			String[] cc =creditCardExp.split("[-]");


			op.selectDropdown(driver, BookAFlightObj.dropdown_CreditCardExpMonth, cc[0]);
			op.selectDropdown(driver, BookAFlightObj.dropdown_CreditCardExpYear, cc[1]);

			op.setText(driver, BookAFlightObj.textbox_CreditCardFirstName1, TestDataPool.tcData.get("firstName1"));
			op.setText(driver, BookAFlightObj.textbox_CreditCardLastName1, TestDataPool.tcData.get("lastName1"));

			op.clickCheckbox(driver, BookAFlightObj.checkbox_TicketlessTravel, TestDataPool.tcData.get("ticketlessTravel"));
			
			ReportingUtils.reportResult("Pass", "Book A FLight", "Book A FLight");
			
			op.clickLink(driver, BookAFlightObj.button_SecurePurchase);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
