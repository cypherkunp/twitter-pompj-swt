package io.github.devvratplus.selenium.twitter.pages;

import io.github.devvratplus.selenium.twitter.serviceinterfaces.LandingPageServices;
import io.github.devvratplus.selenium.twitter.testbase.TestCase;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage implements LandingPageServices {
		
	private WebDriver driver;
	
	@FindBy(id = "signin-email")
	private WebElement userDetauils;
	
	//@FindBy(name = "session[password]")
	@FindBy(id = "signin-password")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id='front-container']/div[2]/div[2]/form/div[2]/label/input")
	private WebElement rememberMeCheckbox;
	
	@FindBy(xpath = "//*[@id='front-container']/div[2]/div[2]/form/table/tbody/tr/td[2]/button")
	private WebElement loginButton;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	private HomePage doLogin(String userDetails, String password,
			boolean selectRememberMeCheckbox){
		
		this.userDetauils.sendKeys(userDetails);
		this.password.sendKeys(password);
		
		if(!selectRememberMeCheckbox)
		this.rememberMeCheckbox.click();
		
		this.loginButton.click(); 
		
		return PageFactory.initElements(driver, HomePage.class);
	}

	@Override
	public HomePage doLoginViaUsername(String username, String password,
			boolean selectRememberMeCheckbox) {
		return doLogin(username, password, selectRememberMeCheckbox);
		
	}

	@Override
	public HomePage doLoginViaEmailID(String emailID, String password,
			boolean selectRememberMeCheckbox) {
		return doLogin(emailID, password, selectRememberMeCheckbox);
		
	}

	@Override
	public HomePage doLoginViaPhoneNumber(String phoneNumber, String password,
			boolean selectRememberMeCheckbox) {
		return doLogin(phoneNumber, password, selectRememberMeCheckbox);
		
	}
	
	@Override
	public void doSignUp(String fullName, String emailID, String password) {
		// TODO Auto-generated method stub
		
	}

}
