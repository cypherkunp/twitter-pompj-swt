package io.github.devvratplus.selenium.twitter.testcases;

import static org.junit.Assert.assertTrue;
import io.github.devvratplus.selenium.twitter.exceptions.TrendingListNotFoundException;
import io.github.devvratplus.selenium.twitter.pages.HomePage;
import io.github.devvratplus.selenium.twitter.pages.LandingPage;
import io.github.devvratplus.selenium.twitter.pages.NotificationsPage;
import io.github.devvratplus.selenium.twitter.testbase.TestCase;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandonTests extends TestCase{
	
	@Before
	public void setUp() {
		launchSelenium();
	}

	@After
	public void tearDown() {
		quitSelenium();
	}

	@Test
	public void verifySuccessfulLogin() {

		LandingPage lp = initializeLandingPage();
		
		HomePage homePage = lp.doLoginViaEmailID(
				getSeleniumProperty("username"),
				getSeleniumProperty("password"), false);
		
		assertTrue(homePage.isLoginSuccessFull());
	}

	@Test
	public void verifyNotificationLink() {

		LandingPage lp = initializeLandingPage();
		
		HomePage homePage = lp.doLoginViaEmailID(
				getSeleniumProperty("username"),
				getSeleniumProperty("password"), false);
		
		NotificationsPage notificationPage = homePage.menuBar()
				.clickOnNotifications();

		assertTrue("New Member Header Not getting dispayed",
				notificationPage.isNewMemberHeaderPresent());

	}
	
	@Test 
	public void verifyTrendsCardK(){
		
		LandingPage lp = initializeLandingPage();
		
		HomePage homePage = lp.doLoginViaEmailID(
				getSeleniumProperty("username"),
				getSeleniumProperty("password"), false);

		List<String> trendingList = null;
		
		try {
			trendingList = homePage.trendsCard()
					.getListOfWhatIsTrendingNow();
		} catch (TrendingListNotFoundException e) {
			e.printStackTrace();
		}
			
		int count = 0;
		for (String trend : trendingList) {
			System.out.println(trend);
			count++;
		}
		
		if (!(count == 10))
			assertTrue(false);

	}
	
	@Test
	public void verifyTrendsHeader(){
		log.info("hello");
		LandingPage lp = initializeLandingPage();
		
		HomePage homePage = lp.doLoginViaEmailID(
				getSeleniumProperty("username"),
				getSeleniumProperty("password"), false);
		
		assertTrue("Header not visible.", homePage.trendsCard().isHeaderVisible());
	}
	
	@Test
	public void logtest(){
		log.info("hello");
	}
}
