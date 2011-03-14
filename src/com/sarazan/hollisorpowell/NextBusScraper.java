package com.sarazan.hollisorpowell;

import com.sarazan.hollisorpowell.route.BusRoute;
import com.sarazan.hollisorpowell.utils.HTTPGetter;

public class NextBusScraper {
	
	public enum Status {
		INACTIVE,ACTIVE,ARRIVING
	}
	
	private static final String[] classes = { "predictionNumberForFirstPred", "predictionNumberForOtherPreds" };
	private static final String BASE_URL = "http://www.nextbus.com/predictor/fancyBookmarkablePredictionLayer.shtml";

	private BusRoute route;
	private Status status;
	private int minutes;

	public NextBusScraper(BusRoute route) {
		this.route = route;
	}
	
	private String parseToMinutes(String html,int index) {
		String subHtml = html.substring(index);
		String[] htmls = subHtml.split("&nbsp;");
		String minutesString = htmls[1];
		htmls = minutesString.split("\n");
		minutesString = htmls[0];	
		
		return minutesString;
	}

	public int execute() {
		String url = BASE_URL + route.toString();
		HTTPGetter getter = new HTTPGetter();
		String html = getter.getUrlData(url);
		
		int pred=-1;
		pred=html.indexOf(classes[0]);
		
		if (pred<0) {
			status = Status.INACTIVE;
			minutes = -1;
			return minutes;
		}
		
		String minutesString = parseToMinutes(html,pred);
		
		if(minutesString.contains("Arriving")) {
			status=Status.ARRIVING;
			pred=html.indexOf(classes[1]);
			minutesString = parseToMinutes(html,pred);
		} else {
			status=Status.ACTIVE;
		}
		
		minutes = Integer.parseInt(minutesString);
		
		return minutes;
	}
	
	@Override
	public String toString() {
		switch(this.status) {
		case INACTIVE:
			return "Buses Not Running.";
		case ACTIVE:
			return "Next Bus In " + minutes + " minutes.";
		case ARRIVING:
			return "ARRIVING. Next Bus In " + minutes + " minutes.";
		}
		
		return "Unknown Error.";
	}
}
