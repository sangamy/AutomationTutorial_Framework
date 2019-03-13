package pageFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infrastructure.Operations;
import pageObjects.SelectFlightObj;
import utils.ReportingUtils;

public class SelectFlightPage {
	
	
public void departReturnFlight(WebDriver driver){
	//Depart Flight
	driver.findElement(By.xpath(SelectFlightObj.radiobutton_DepartUnifiedAirlines)).click();
	new Operations().clickRadiobutton(driver, SelectFlightObj.radiobutton_DepartUnifiedAirlines);

	//Return Flight
	new Operations().clickRadiobutton(driver, SelectFlightObj.radiobutton_ReturnUnifiedAirlines);
	
	ReportingUtils.reportResult("Pass", "Select Flight Page", "Select Flight Page");
	//Continue
	new Operations().clickLink(driver, SelectFlightObj.button_Continue);

}
}
