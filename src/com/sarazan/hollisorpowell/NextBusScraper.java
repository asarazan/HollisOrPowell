package com.sarazan.hollisorpowell;


public class NextBusScraper {
	
	public static final String BASE_URL = "http://www.nextbus.com/predictor/fancyBookmarkablePredictionLayer.shtml";
	public static final String AREA_ID = "emery";
	
	public static final int RouteHollis = 1;
	public static final int RoutePowell = 2;
	
	public static final int DirInbound = 1;
	public static final int DirOutbound = 2;
	
	private int route;
	private int direction;
	private BusStop stop;
	private BusStop destination;
	
	public NextBusScraper(int route,int direction,BusStop stop,BusStop destination) {
		this.route=route;
		this.direction=direction;
		this.stop=stop;
		this.destination=destination;
	}
	
	private String routeIdentifier() {
		switch(route) {
		case RouteHollis:
			return "Hollis";
		case RoutePowell:
			return "powell";
		}
		
		return "ERROR";
	}
	
	private String shortRouteIdentifier() {
		switch(route) {
		case RouteHollis:
			return "hollis";
		case RoutePowell:
			return "po";
		}
		
		return "ERROR";
	}
	
	private String directionString() {
		String suffix = null;
		switch(direction) {
		case DirInbound:
			suffix = "inbound";
			break;
		case DirOutbound:
			suffix = "outbound";
			break;
		}
		
		return shortRouteIdentifier() + "_" + suffix;		
	}

	public String execute() {
		String url = BASE_URL + 
		"?a=" + AREA_ID + 
		"&r=" + routeIdentifier() + 
		"&d=" + directionString() +
		"&s=" + stop.toString() +
		"&ts=" + destination.toString();
		
		HTTPGetter getter = new HTTPGetter();
		String html = getter.getUrlData(url);
		
		return html;
	}
}
