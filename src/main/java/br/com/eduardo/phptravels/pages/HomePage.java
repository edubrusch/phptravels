package br.com.eduardo.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.eduardo.phptravels.selenium.Pages;

public class HomePage extends Pages {
	
	@SuppressWarnings("unused")
	private By likXpMenuAccount = By.xpath("//*[@id='li_myaccount']");
	private By likLtsubmenuLogin = By.linkText(" Login");
	private By fldNmLoginemail = By.name("username");
	private By divIdFrameNav = By.id("collapse");

	public HomePage(WebDriver someDriver) {
		super(someDriver);		
	}	
	
	public void enterloginPage(){		
		genericClick(getDriver().findElement(divIdFrameNav).findElement(likLtsubmenuLogin), "Login");
		waitElementPresent(fldNmLoginemail);
	}

}
