package br.com.eduardo.phptravels.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.eduardo.phptravels.TestContext;

public class LoginTests extends TestContext {
	
	
	@Test(description="TC001 - Login (Positivo)", dataProvider = "dataPool")
	public void ShouldLoginwithSuccess(String userMail, String password, String userName) {
		pages.getHomePage().enterloginPage();
		pages.getLoginPage().fillEmail(userMail);
		pages.getLoginPage().fillPassword(password);
		pages.getLoginPage().clickLoginButton();
		boolean logged = pages.getLoggedPage().isLoggedPage();
		String currentuser = pages.getLoggedPage().getUserSalutation();
		Assert.assertTrue(logged);
		Assert.assertTrue(currentuser.contains(userName));
	}
	

}
