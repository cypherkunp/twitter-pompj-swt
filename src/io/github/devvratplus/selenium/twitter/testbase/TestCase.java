package io.github.devvratplus.selenium.twitter.testbase;

import io.github.devvratplus.selenium.twitter.pages.LandingPage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.PageFactory;

public abstract class TestCase extends TestBase {

	private static WebDriver driver = null;
	protected static Logger log = null;


	private WebDriver initializeSelenium() {

		log = Logger.getLogger("rootLogger");
		log.info("Initializing Selenium");
		
		// Setting up the driver specific driver
		switch (getSeleniumProperty("browser")) {
		case "Firefox":
			String firefoxProfileName = getSeleniumProperty("firefoxProfile");
			if (firefoxProfileName != "" || firefoxProfileName != "default") {
				FirefoxProfile fProfile = (new ProfilesIni())
						.getProfile(firefoxProfileName);
				driver = new FirefoxDriver(fProfile);
				break;
			}
			
		default : driver = new FirefoxDriver();
		}
		
		if(!getSeleniumProperty("implicitTimeOut").equals("")){
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		return driver;
	}

	public void launchSelenium(){
		driver = initializeSelenium();
		//driver.manage().window().maximize();
		driver.get(getSeleniumProperty("url"));
	}
	
	public void quitSelenium(){
		driver.quit();
	}
	
	public LandingPage initializeLandingPage() {
		return PageFactory.initElements(driver, LandingPage.class);
	}
}
