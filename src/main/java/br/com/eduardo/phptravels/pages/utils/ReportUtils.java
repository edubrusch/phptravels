package br.com.eduardo.phptravels.pages.utils;

import org.testng.Reporter;

import br.com.eduardo.phptravels.selenium.enums.Configs;

public class ReportUtils {
	
	public static void log(String Message) {
		Reporter.log(Message, getLogToConsole());		
	}

	private static boolean getLogToConsole() {
		boolean console = false;
		try {
			console = Boolean.parseBoolean(Configs.logtoConsole.get());
		} catch (NullPointerException ex) {
			console = false;
		}
		
		return console;
	}

}
