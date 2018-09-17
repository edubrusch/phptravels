package br.com.eduardo.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.eduardo.phptravels.selenium.Pages;

public class LoggedPage extends Pages {
	
	private By lbXpAccounText = By.xpath("css=h3.RTL");
	 

	public LoggedPage(WebDriver someDriver) {
		super(someDriver);		
	}

	public boolean isLoggedPage() {
		return isElementPresent(lbXpAccounText) &&
			titleContains("My Account");
	}

	public String getUserSalutation() {		
		return getElementText(lbXpAccounText);
	}

}
