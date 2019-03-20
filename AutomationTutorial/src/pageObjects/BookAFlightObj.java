package pageObjects;

public class BookAFlightObj {

	//Summary
	public static final String table_DepartPrice = "//table/tbody/tr[3]/td[3]/font";
	public static final String table_ReturnPrice = "//table/tbody/tr[6]/td[3]/font";
	public static final String table_NoOfPassengers = "//table/tbody/tr[7]/td[2]/font";
	public static final String table_taxes = "//table/tbody/tr[8]/td[2]/font";
	public static final String table_TotalPrice = "//table/tbody/tr[9]/td[2]/font/b";

	//Passengers
	public static final String textbox_firstName1 = "//input[contains(@name,'passFirst0')]";
	public static final String textbox_lastName1 = "//input[contains(@name,'passLast0')]";
	public static final String dropdown_Meal1 = "//select[contains(@name,'pass.0.meal')]";

	public static final String textbox_firstName2 = "//input[contains(@name,'passFirst1')]";
	public static final String textbox_lastName2 = "//input[contains(@name,'passLast1')]";
	public static final String dropdown_Meal2 = "//select[contains(@name,'pass.1.meal')]";
	
	public static final String textbox_firstName3 = "//input[contains(@name,'passFirst2')]";
	public static final String textbox_lastName3 = "//input[contains(@name,'passLast2')]";
	public static final String dropdown_Meal3 = "//select[contains(@name,'pass.2.meal')]";
	
	//Credit card details
	public static final String dropdown_CreditCardType = "//select[contains(@name,'creditCard')]";
	public static final String textbox_CreditCardNumber = "//input[contains(@name,'creditnumber')]";
	public static final String dropdown_CreditCardExpMonth = "//select[contains(@name,'cc_exp_dt_mn')]";
	public static final String dropdown_CreditCardExpYear = "//select[contains(@name,'cc_exp_dt_yr')]";
	public static final String textbox_CreditCardFirstName1 = "//input[contains(@name,'cc_frst_name')]";
	public static final String textbox_CreditCardLastName1 = "//input[contains(@name,'cc_last_name')]";
	public static final String checkbox_TicketlessTravel ="//table/tbody/tr[9]/td[2]/input[contains(@name,'ticketLess')]";
	public static final String button_SecurePurchase = "//input[contains(@name,'buyFlights')]";
	


}