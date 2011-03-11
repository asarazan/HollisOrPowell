package com.sarazan.hollisorpowell.route;

import java.util.ArrayList;

import com.sarazan.hollisorpowell.route.BusStop;

public class BusLine {
	
	private String vanityName;
	private String codeName;
	private String shortName;
	
	private ArrayList<BusStop> stops = new ArrayList<BusStop>();
	
	private BusStop endPoint;
	
	public BusLine(String vanityName,String codeName,String shortName) {
		this.vanityName=vanityName;
		this.codeName=codeName;
		this.shortName=shortName;
	}
	
	void addStop(BusStop stop) {
		stops.add(stop);
		stop.addLine(this);
	}
	
	void addStop(String vanityName,String stopCode,boolean endPoint) {
		BusStop stop = new BusStop(vanityName,stopCode);
		
		this.addStop(stop);
		
		if(endPoint)
			this.endPoint=stop;
	}
	
	void addStop(String vanityName,String stopCode) {
		addStop(vanityName,stopCode,false);
	}
	
	public BusStop stopAtIndex(int index) {
		return stops.get(index);
	}
	
	public BusStop getEndPoint() {
		return endPoint;
	}
	
	public String getVanityName() {
		return vanityName;
	}
	
	public String getCodeName() {
		return codeName;
	}
	
	public String getShortName() {
		return shortName;
	}
}
