package br.com.eduardo.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.eduardo.phptravels.selenium.Pages;

public class HomePage extends Pages {	
	
	private By likXpMenuAccount = By.xpath("//a[contains(text(),'My Account')]");
	private By likLtsubmenuLogin = By.linkText("Login");
	private By fldNmLoginemail = By.name("username");
	private By divIdFrameNav = By.id("collapse");

	public HomePage(WebDriver someDriver) {
		super(someDriver);		
	}	
	
	public void enterloginPage(){
		getDriver().findElements(likXpMenuAccount).get(1).click();
		genericClick(getDriver().findElement(divIdFrameNav).findElement(likLtsubmenuLogin), "Login");
		waitElementPresent(fldNmLoginemail);
	}

}
