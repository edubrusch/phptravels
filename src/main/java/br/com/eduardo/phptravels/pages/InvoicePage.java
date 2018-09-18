package br.com.eduardo.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.eduardo.phptravels.selenium.Pages;

public class InvoicePage extends Pages {
		
	
	private By fldhotelName = By.xpath("//td[@width='75%' @align='left']");
	private By fldinvoiceDate = By.xpath("//[]");
	private By flddueDate = By.xpath("//[]");
	private By fldinvoiceNumber = By.xpath("//[]");
	private By fldbookingCode = By.xpath("//[]");
	private By fldcustomerDetails = By.xpath("//[]");
	private By fldroom = By.xpath("//[]");
	private By fldcheckIn = By.xpath("//[]");
	private By fldcheckOut = By.xpath("//[]");
	private By fldtotalStay = By.xpath("//[]");
	private By flddepositNow = By.xpath("//[]");
	private By fldtaxVAT = By.xpath("//[]");
	private By fldtotalAmount = By.xpath("//[]");
	
	

	public InvoicePage(WebDriver somedDriver) {
		super(somedDriver);		
	}
	
	public String getHotelName() {
		return getElementText(fldhotelName);
	}
	
	public String getInvoiceDate() {
		return getElementText(fldinvoiceDate);
	}
	
	public String getDueDate() {
		return getElementText(flddueDate);
	}
	
	public String getInvoiceNumber() {
		return getElementText(fldinvoiceNumber);
	}
	
	public String getBookingCode() {
		return getElementText(fldbookingCode);
	}
	
	public String getCustomerDetails() {
		return getElementText(fldcustomerDetails);
	}
	
	public String getRoom() {
		return getElementText(fldroom);
	}
	
	public String getCheckIn() {
		return getElementText(fldcheckIn);
	}
	
	public String getCheckOut() {
		return getElementText(fldcheckOut);
	}
	
	public String getTotalStay() {
		return getElementText(fldtotalStay);
	}
	
	public String getDepositNow() {
		return getElementText(flddepositNow);
	}
	
	public String getTaxVAT() {
		return getElementText(fldtaxVAT);
	}
	
	public String getTotalAmount() {
		return getElementText(fldtotalAmount);
	}
	

}
