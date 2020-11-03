package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	
	
	@BeforeTest
	public void setUpDriver() throws MalformedURLException {
		
		String host = "localhost";
		DesiredCapabilities dc = null;
		
		if(System.getProperty("HUB_HOST") != null) {

			host = System.getProperty("HUB_HOST");
		}
		
		if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			
			dc = DesiredCapabilities.firefox();
		}else {
			
			dc = DesiredCapabilities.chrome();;
		}
		
		String completeUrl = "http://" + host + ":4444/wd/hub";
		
		this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
	}
	
	
	@AfterTest
	public void quit() {
		
		this.driver.quit();
	}

}
