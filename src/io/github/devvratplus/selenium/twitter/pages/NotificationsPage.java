package io.github.devvratplus.selenium.twitter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationsPage{

	private MenuBar menu;
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='page-container']/div[3]/div/div/h2")
	private WebElement newMemberHeader;
	
	public NotificationsPage() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isNewMemberHeaderPresent(){
		if(newMemberHeader.getText().equals("Get notifications here when people interact with you:"))
			return true;
		else
			return false;
	}
	
}
