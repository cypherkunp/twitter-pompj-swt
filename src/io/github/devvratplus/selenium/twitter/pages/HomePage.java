package io.github.devvratplus.selenium.twitter.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.devvratplus.selenium.twitter.serviceinterfaces.HomePageServices;
import io.github.devvratplus.selenium.twitter.testbase.TestBase;

public class HomePage extends TestBase implements HomePageServices	{
	
	private MenuBar menu;
	private TrendsCard trendsCard;

	@FindBy(xpath = "//*[@id='page-container']/div[1]/div[1]/div/div[2]/div/a")
	private WebElement userNameDisplayed;

	public HomePage(WebDriver driver) {
		if (menu == null) {
			menu = PageFactory.initElements(driver, MenuBar.class);
		}

		if (trendsCard == null) {
			trendsCard = PageFactory.initElements(driver, TrendsCard.class);
		}
	}

	public MenuBar menuBar() {
		return menu;
	}

	public TrendsCard trendsCard() {
		return trendsCard;
	}

	@Override
	public boolean isLoginSuccessFull() {
		if (userNameDisplayed.getText().equals(getSeleniumProperty("user")))
			return true;
		else
			return false;
	}

	@Override
	public List<String> getVisibleTweetsOnTheTimeLine() {
		// TODO Auto-generated method stub
		return null;
	}

}
