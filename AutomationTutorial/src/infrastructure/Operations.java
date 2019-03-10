package infrastructure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageFlows.HomePage;

public class Operations {

	//Clicking link or button
	public void clickLink(WebDriver driver, String xpathExpression){
		try {
			driver.findElement(By.xpath(xpathExpression)).click();
			System.out.println("Clicked the link - "+ xpathExpression );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Typing input value in textbox
	public void setText(WebDriver driver, String xpathExp, String inputValue){
		driver.findElement(By.xpath(xpathExp)).sendKeys(inputValue);
		System.out.println("setText - "+xpathExp + " - "+inputValue);
	}
	
	//Select a value from dropdown
	public void selectDropdown(WebDriver driver, String xpathExpression, String inputValue){
		WebElement ele = driver.findElement(By.xpath(xpathExpression));
		Select sel = new Select(ele);
		sel.selectByVisibleText(inputValue);
		System.out.println("selectDropdown - "+xpathExpression + " - "+inputValue);

	}
	
	//Get text from page
	public String getText(WebDriver driver, String xpathExpression){
		String value =  driver.findElement(By.xpath(xpathExpression)).getText();
		System.out.println("getText - "+xpathExpression +" - "+value);
		return value;
	}
	
	//Clicking on Radio button
	public void clickRadiobutton(WebDriver driver, String xPathExp){
		driver.findElement(By.xpath(xPathExp)).click();
		System.out.println("clickRadiobutton - "+xPathExp);
	}
	
	//Check the checkbox
	public void clickCheckbox(WebDriver driver, String xPathExpression){
		driver.findElement(By.xpath(xPathExpression)).click();
		System.out.println("clickCheckbox - "+xPathExpression);
	}
	
	// Selecting checkbox with inputValue (isSelected = Yes or No)
	public void clickCheckbox(WebDriver driver, String xpathExpression, String inputval)
	{
		//driver.findElement(By.xpath(xpathExpression)).isSelected()

		if(inputval.equalsIgnoreCase("Yes"))
		driver.findElement(By.xpath(xpathExpression)).click();
	}


	
	//Implicit wait
	public void implicitWait(WebDriver driver, long maxTimeout){
		driver.manage().timeouts().implicitlyWait(maxTimeout, TimeUnit.SECONDS);
		System.out.println("implicitWait - waited for "+maxTimeout+" seconds." );
	}
}
