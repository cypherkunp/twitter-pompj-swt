package io.github.devvratplus.selenium.twitter.serviceinterfaces;

import io.github.devvratplus.selenium.twitter.pages.HomePage;
import io.github.devvratplus.selenium.twitter.pages.LandingPage;

public interface LandingPageServices {

	public HomePage doLoginViaUsername(String username, String password,
			boolean selectRememberMeCheckbox);
	
	public HomePage doLoginViaEmailID(String emailID, String password,
			boolean selectRememberMeCheckbox);
	
	public HomePage doLoginViaPhoneNumber(String phoneNumber, String password,
			boolean selectRememberMeCheckbox);
	
	public void doSignUp(String fullName, String emailID, String password);

}
