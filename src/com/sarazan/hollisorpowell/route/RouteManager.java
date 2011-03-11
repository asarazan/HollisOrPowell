package com.sarazan.hollisorpowell.route;

import java.util.ArrayList;

public class RouteManager {
	private ArrayList<BusLine> busLines = new ArrayList<BusLine>();
	
	public RouteManager() {
		this.createCannedRoutes();
	}

	public void createCannedRoutes() {
		BusLine line;
		
		line = new BusLine("Powell","powell","po");
		line.addStop("40th & Horton","40hr");
		line.addStop("40th & Hollis","40ho");
		line.addStop("MacArthur Station","bartw",true);
		
		busLines.add(line);

		line = new BusLine("Hollis","Hollis","hollis");
		line.addStop("Hollis & 45th","ho45");
		line.addStop("Park & Watts(Pixar)","pix");
		line.addStop("MacArthur Station","bartw",true);
		
		busLines.add(line);
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
}
