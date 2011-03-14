package com.sarazan.hollisorpowell.route;

import java.util.ArrayList;

import com.sarazan.hollisorpowell.utils.XmlRouteParser;

public class RouteManager {
	private ArrayList<BusLine> busLines = new ArrayList<BusLine>();
	
	public RouteManager() {
		this.createCannedRoutes();
		//XmlRouteParser parser = new XmlRouteParser(this);
		//parser.execute();
	}

	public void createCannedRoutes() {
		BusLine line;
		
		line = new BusLine("Powell","powell","po");
		line.addStop("40th & Horton","40hr");
		line.addStop("40th & Hollis","40ho");
		line.addStop("MacArthur Station","bartw",true);
		
		addLine(line);

		line = new BusLine("Hollis","Hollis","hollis");
		line.addStop("Hollis & 45th","ho45");
		line.addStop("Park & Watts(Pixar)","pix");
		line.addStop("MacArthur Station","bartw",true);
		
		addLine(line);
	}
	
	public BusLine getLineByName(String name) {
		for (BusLine line : busLines) {
			if (line.getVanityName()==name) {
				return line;
			}
		}		
		return null;
	}
	
	public BusLine lineAtIndex(int index) {
		return busLines.get(index);
	}
	
	public void addLine(BusLine line) {
		busLines.add(line);
	}
	
	public void parseComplete() {
		//TODO
	}
}
