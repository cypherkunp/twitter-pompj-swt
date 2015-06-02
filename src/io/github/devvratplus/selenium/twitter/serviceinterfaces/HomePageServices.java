package io.github.devvratplus.selenium.twitter.serviceinterfaces;

import java.util.List;


public interface HomePageServices {

	public boolean isLoginSuccessFull();
	
	public List<String> getVisibleTweetsOnTheTimeLine();
}
