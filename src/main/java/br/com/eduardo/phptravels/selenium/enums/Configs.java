package br.com.eduardo.phptravels.selenium.enums;

import java.util.Properties;

public enum Configs {
	logtoConsole,	
	chromeDriverLocation, 
	browser;
	
	
	private final String errorMessageLoadingconfigfile =
		"Error loading test properties. Please see if there is a cfg.properties file located in the folder src/main/resources/";
	
	public String get() {		
		return getProps().getProperty(this.name());
	}	
	
	private Properties getProps() {
		Properties props = new Properties();

		try {
			props.load(ClassLoader.getSystemResourceAsStream("cfg.properties"));

		} catch (Exception e) {
			throw new RuntimeException(errorMessageLoadingconfigfile, e);
		}
		
		return props;
	}

}
