package br.com.eduardo.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.eduardo.phptravels.selenium.Pages;

public class LoggedPage extends Pages {
	
	private By lbXpAccounText = By.xpath("//h3[contains(@class,'RTL')]");
	private By likXpLoggedAccount = By.xpath("//a[contains(text(),'Johny')]");
	private By likTxlogout = By.linkText("Logout");

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

	public void logout() {
		genericClick(getDriver().findElements(likXpLoggedAccount).get(1), "Menu logout");
		clickLink(likTxlogout, "Click logout link");		
	}

}
