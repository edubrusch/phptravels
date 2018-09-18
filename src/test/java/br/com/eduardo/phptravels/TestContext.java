package br.com.eduardo.phptravels;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.eduardo.phptravels.invoice.DTOInvoice;
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
		String message = String.format("\nRunning test: %s", method.getAnnotation(Test.class).description());
		ReportUtils.log(message);
	}

	@AfterMethod
	protected void testFinished(ITestResult result) {
		String status = "FAILURE";
		if (result.getStatus() == ITestResult.SUCCESS) {
			status = "SUCCESS";
		}

		String message = String.format("Finished test: %s with status: %s", result.getMethod().getDescription(), status);
		ReportUtils.log(message);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@DataProvider(name = "goodLogins")
	protected String[][] goodLogins() {
		return new String[][] { { "user@phptravels.com", "demouser", "Johny Smith" } };
	}
	
	@DataProvider(name = "badlogins")
	protected String[][] badLogins() {
		return new String[][] { 
			{"user@phptravels.com", "Demouser"},
			{"user@phptravels.com", "demouser_"},
			{"user@phptravels.com.br", "demouser"},
			{"another_user@phptravels.com", "Demouser"}					
		};
	}	
	
	@DataProvider(name = "invoices")
	protected DTOInvoice[] invoiceData() {
		DTOInvoice invoice1Good = new DTOInvoice();
		DTOInvoice invoice2Bad = new DTOInvoice();
		
		invoice2Bad.setEmail("user@phptravels.com");
		invoice2Bad.setPassword("Demouser");
		invoice2Bad.setHotelName("Rendezvous Hotel");
		invoice2Bad.setInvoiceDate("10/09/2018");
		invoice2Bad.setDueDate("11/09/2018");
		invoice2Bad.setInvoiceNumber("114");
		invoice2Bad.setBookingCode("4259");		
		invoice2Bad.setRoom("Junior Suites");
		invoice2Bad.setCheckIn("10/09/2018");
		invoice2Bad.setCheckOut("11/09/2018");
		invoice2Bad.setTotalStay("1 $250");
		invoice2Bad.setDepositNow("USD $27.50");
		invoice2Bad.setTaxVAT("USD $25");
		invoice2Bad.setTotalAmount("USD $275");
		invoice2Bad.setCustomerDetails("JOHNY SMITH\r\n" + 
				"R2, AVENUE DU MAROC\r\n" + 
				"123456");
		
		invoice1Good.setEmail("user@phptravels.com");
		invoice1Good.setPassword("demouser");
		invoice1Good.setHotelName("Rendezvous Hotel");
		invoice1Good.setInvoiceDate("14/01/2018");
		invoice1Good.setDueDate("15/01/2018");
		invoice1Good.setInvoiceNumber("110");
		invoice1Good.setBookingCode("0875");		
		invoice1Good.setRoom("Superopr double");
		invoice1Good.setCheckIn("14/01/2018");
		invoice1Good.setCheckOut("15/01/2018");
		invoice1Good.setTotalStay("1 $150");
		invoice1Good.setDepositNow("USD $20.90");
		invoice1Good.setTaxVAT("USD $19");
		invoice1Good.setTotalAmount("USD $209");
		invoice1Good.setCustomerDetails("JOHNY SMITH "
										+ "R2, AVENUE DU MAROC"
										+ "123456");
		
		return new DTOInvoice[] {invoice1Good, invoice2Bad};	
		
	}

}
