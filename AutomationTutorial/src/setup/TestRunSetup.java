package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import data.Constants;
import utils.PropertyUtils;

public class TestRunSetup {


	public static WebDriver launch(String url){
		WebDriver driver = null;
		String browserType = PropertyUtils.propertyFile_Read(Constants.CONFIG_PATH, "browser");

		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
			 driver = new ChromeDriver();
	
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
	
			break;

		default:
			break;
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;

	}



}
