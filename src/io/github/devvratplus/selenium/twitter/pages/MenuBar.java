package io.github.devvratplus.selenium.twitter.pages;

import io.github.devvratplus.selenium.twitter.serviceinterfaces.MenuBarServices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuBar implements MenuBarServices{
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='global-nav-home']/a")
	private WebElement home;
	
	@FindBy(xpath="//*[@id='global-actions']/li[2]/a")
	private WebElement notifications;
	
	@FindBy(xpath="//*[@id='global-actions']/li[3]/a")
	private WebElement messages;
	
	@FindBy(xpath="//*[@id='global-new-tweet-button']")
	private WebElement tweet;
	
	@FindBy(xpath=".//*[@id='search-query']")
	private WebElement searchTwitter;

	public MenuBar(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnHome(){
		home.click();
	}
	
	public NotificationsPage clickOnNotifications(){
		notifications.click();
		return  PageFactory.initElements(driver, NotificationsPage.class);
	}
	
	public void clickOnMessages(){
		messages.click();
	}

	@Override
	public void clickOnTweet() {
		tweet.click();
	}
	
	
}
