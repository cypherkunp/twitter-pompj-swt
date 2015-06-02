package io.github.devvratplus.selenium.twitter.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class TestBase {

	private static final String SELENIUM_PROPERTY_FILE = System
			.getProperty("user.dir") + "\\config\\selenium.properties";
	private static Properties seleniumProperty = null;
	
	public TestBase(){
		loadSeleniumProperty();
	}

	private void loadSeleniumProperty() {
		seleniumProperty = new Properties();
		try {
			File selePropertyFile = new File(SELENIUM_PROPERTY_FILE);
			FileInputStream loadseleniumProp = new FileInputStream(
					selePropertyFile);
			seleniumProperty.load(loadseleniumProp);

		} catch (FileNotFoundException e) {
			System.out.println("File not found at the default location > "
					+ SELENIUM_PROPERTY_FILE);
		} catch (IOException e) {
			System.out.println("Unable to load the property file located at > "
					+ SELENIUM_PROPERTY_FILE);
		}
	}

	public String getSeleniumProperty(String propertyKey) {

		return seleniumProperty.getProperty(propertyKey);
	}
}
