package br.com.eduardo.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.eduardo.phptravels.selenium.Pages;

public class LoginPage extends Pages {
	
	private By fldNmEmail = By.name("username");
	private By fldNmPassword = By.name("password");
	private By btXpLogin = By.xpath("//button[@type='submit']");

	public LoginPage(WebDriver someDriver) {
		super(someDriver);		
	}

	public void clickLoginButton() {
		clickButton(btXpLogin, "login");
		
	}
	
	public void fillEmail(String content) {
		fillField(fldNmEmail, "email", content);		
	}
	
	public void fillPassword(String content) {
		fillField(fldNmPassword, "password", content);		
	}	
}
