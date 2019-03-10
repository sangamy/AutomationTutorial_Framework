package pageFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infrastructure.Operations;
import pageObjects.SelectFlightObj;

public class SelectFlightPage {
	
	
public void departReturnFlight(WebDriver driver){
	//Depart Flight
	driver.findElement(By.xpath(SelectFlightObj.radiobutton_DepartUnifiedAirlines)).click();
	new Operations().clickRadiobutton(driver, SelectFlightObj.radiobutton_DepartUnifiedAirlines);

	//Return Flight
	new Operations().clickRadiobutton(driver, SelectFlightObj.radiobutton_ReturnUnifiedAirlines);
	
	//Continue
	new Operations().clickLink(driver, SelectFlightObj.button_Continue);

}
}
