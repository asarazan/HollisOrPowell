package com.sarazan.hollisorpowell.route;


public class BusRoute {	
	public static final String AREA_ID = "emery";
		
	private BusStop stop;
	private BusStop destination;
	
	public BusRoute(BusStop stop) {
		BusLine line = stop.getLine();
		BusStop endPoint = line.getEndPoint();
		
		this.stop=stop;
		this.destination=endPoint;		
	}
	
	private String directionString() {		
		return getLine().getShortName() + "_i";		
	}

	public String toString() {
		String url =  
		"?a=" + AREA_ID + 
		"&r=" + getLine().getCodeName() + 
		"&d=" + directionString() +
		"&s=" + stop.toString() +
		"&ts=" + destination.toString();
		
		return url;
	}
	
	public BusLine getLine() {
		return stop.getLine();
	}
	
	public BusStop getStop() {
		return stop;
	}
}
