package br.com.eduardo.phptravels.selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.eduardo.phptravels.selenium.enums.Configs;

public class DriverManager {
	
	private final String chromeDriverProperty = "webdriver.chrome.driver";	
	private WebDriver driver = null;
	private static DriverManager instance = null;
	
	protected DriverManager() {
		// it's a singleton. this will avoid it being instantiated.
	}
	
	public static DriverManager getInstance() {
		if(instance == null) {
	         instance = new DriverManager();
	      }		
	      return instance;
	}
	
	public WebDriver getDriver(String browser) {
		if(driver == null) {
			initializedriver(browser);
		}
		return driver;
	}
	
	
	private void initializedriver(String browser) {
		if(browser.toLowerCase().equals("chrome")) {
			bootChrome();
		} else {
			throw new RuntimeException(String.format("Browse %s não implementado", browser)); 
		}
	}	
	
	private void bootChrome() {		
		String path = new File (Configs.chromeDriverLocation.get()).getAbsolutePath();
		System.setProperty(chromeDriverProperty, path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}	

}
