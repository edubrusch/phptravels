package br.com.eduardo.phptravels.invoice;

import br.com.eduardo.phptravels.TestContext;

public class InvoiceTests extends TestContext {
	
	
	//@Test(description="TC003 - Validar informação de Invoice", dataProvider = "invoice")
	public void ShouldLoginWithSuccess(DTOInvoice data) {
		pages.getHomePage().enterloginPage();
		pages.getLoginPage().fillEmail(data.getEmail());
		pages.getLoginPage().fillPassword(data.getPassword());
		pages.getLoginPage().clickLoginButton();
		
		pages.getLoggedPage().logout();
		
	}

}
