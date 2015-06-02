package io.github.devvratplus.selenium.twitter.pages;

import io.github.devvratplus.selenium.twitter.exceptions.TrendingListNotFoundException;
import io.github.devvratplus.selenium.twitter.serviceinterfaces.TrendsCardServices;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrendsCard implements TrendsCardServices {
	
	@FindBy(xpath = "//*[@class='Trends module trends']")
	private WebElement trendingList;

	@FindBy(xpath = "//*[@id='page-container']/div[1]/div[3]/div/div/div[1]/h3/span")
	private WebElement trendsCardHeader;

	@Override
	public List<String> getListOfWhatIsTrendingNow() throws TrendingListNotFoundException {
		List<WebElement> trendsWebElementsList = trendingList.findElements(By
				.tagName("li"));
		if(trendsWebElementsList.isEmpty())
			 throw new TrendingListNotFoundException("Trending List Not Found");
		List<String> trendsList = new ArrayList<String>();

		for (WebElement trendsWebElement : trendsWebElementsList) {
			trendsList.add(trendsWebElement.getText());
		}
		return trendsList;
	}

	@Override
	public boolean isHeaderVisible() {
		if (trendsCardHeader.getText().equals("Trends"))
			return true;
		else
			return false;
	}

}
