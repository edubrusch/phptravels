package br.com.eduardo.phptravels.selenium;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.eduardo.phptravels.pages.HomePage;
import br.com.eduardo.phptravels.pages.LoggedPage;
import br.com.eduardo.phptravels.pages.LoginPage;
import br.com.eduardo.phptravels.pages.utils.ReportUtils;

public class Pages {	
	
	private WebDriver driver;
	
	public Pages(WebDriver somedDriver) {
		driver = somedDriver;
	}
	
	private HomePage home;
	private LoggedPage logged;
	private LoginPage login;

	public WebDriver getDriver() {
		return driver;
	}
	
	
	public LoginPage getLoginPage() {
		if(login == null) {
			login = new LoginPage(driver);
		}
		
		return login;
	}
			
	public HomePage getHomePage() {
		if(home == null) {
			home = new HomePage(driver);
		}
		
		return home;
	}
	
	public LoggedPage getLoggedPage() {
		if(logged == null) {
			logged = new LoggedPage(driver);
		}
		
		return logged;
	}
	
	
	
	protected void waitElementPresent(By locator) {
		@SuppressWarnings("unused")
		WebElement element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	protected boolean isElementPresent(By locator) {
		boolean  present = false;				
		try {
			present = !(driver.findElement(locator) == null);			
		}catch(NoSuchElementException | WebDriverException ex) {
			present = false;
		}
		return present;
	}
	
	public boolean titleContains(String key) {
		return driver.getTitle().contains(key);
	}
	
	protected void fillField(By field, String name, String content) {
		String message = String.format("Fill field: %s with %s.", name, content);
		driver.findElement(field).sendKeys(content);
		ReportUtils.log(message);
	}
	
	protected void clickButton(By button, String buttonName) {
		String message = String.format("Click button: %s.", buttonName);
		driver.findElement(button).click();
		ReportUtils.log(message);
	}	
	
	protected void clickLink(By link, String buttonName) {
		String message = String.format("Click link: %s.", buttonName);
		driver.findElement(link).click();
		ReportUtils.log(message);
	}	
	
	protected void genericClick(WebElement element, String description) {
		String message = String.format("Click item on the screen: %s.", description);
		element.click();
		ReportUtils.log(message);
	}
	
	protected String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}

}
