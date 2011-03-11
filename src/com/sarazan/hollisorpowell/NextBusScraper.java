package com.sarazan.hollisorpowell;

import com.sarazan.hollisorpowell.route.BusRoute;


public class NextBusScraper {
	
	public static final String BASE_URL = "http://www.nextbus.com/predictor/fancyBookmarkablePredictionLayer.shtml";
	
	private BusRoute route;
	
	public NextBusScraper(BusRoute route) {
		this.route=route;
	}
	
	public String execute() {
		String url = BASE_URL + route.toString();		
		HTTPGetter getter = new HTTPGetter();
		String html = getter.getUrlData(url);
		
		return html;
	}
}
