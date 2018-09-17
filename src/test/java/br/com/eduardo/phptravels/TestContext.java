package br.com.eduardo.phptravels;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.eduardo.phptravels.pages.utils.ReportUtils;
import br.com.eduardo.phptravels.selenium.DriverManager;
import br.com.eduardo.phptravels.selenium.Pages;
import br.com.eduardo.phptravels.selenium.enums.Configs;

public class TestContext {
	
	private WebDriver driver = null;
	private String browser = Configs.browser.get();
	private final String homeAddress = "https://www.phptravels.net/";	
	protected Pages pages; 
	protected String[][] dataPool; 
	
	@BeforeClass
	protected void init() {
		driver = DriverManager.getInstance().getDriver(browser);
		pages = new Pages(driver);
		driver.navigate().to(homeAddress);
	}	
	
	protected void teardown() {
		driver.quit();
	}
	
	@BeforeMethod
	protected void testPrep(Method method) {
		String message = String.format("Running test: %s", method.getAnnotation(Test.class).description());
		ReportUtils.log(message);
	}
	
	@AfterMethod
	protected void testFinished(ITestResult result) {
		String status = "FAILURE";
		if(result.getStatus() == ITestResult.SUCCESS) {
			status = "SUCCESS";			
		}
		
		String message = String.format("Finished test: %s with status: %s", result.getMethod().getDescription(), status);
		ReportUtils.log(message);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	 @DataProvider(name = "dataPool")
	 protected String[][] login() {		 
		 return new String[][] { { "user@phptravels.com", "demouser", "Johny Smith"}};
	 }

}
