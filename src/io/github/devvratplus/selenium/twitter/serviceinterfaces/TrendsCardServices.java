package io.github.devvratplus.selenium.twitter.serviceinterfaces;

import io.github.devvratplus.selenium.twitter.exceptions.TrendingListNotFoundException;

import java.util.List;

public interface TrendsCardServices {

	public boolean isHeaderVisible();
	public List<String> getListOfWhatIsTrendingNow() throws TrendingListNotFoundException;
	
}
