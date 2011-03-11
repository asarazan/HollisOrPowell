package com.sarazan.hollisorpowell.route;

public class BusStop {
	
	//To BART station is inbound.
	public static final String DirInbound = "_i";
	public static final String DirOutbound = "_o";
	
	private String vanityName;
	private String stop;
	
	private BusLine busLine;
	
	public BusStop(String vanityName,String stop) {
		this.vanityName=vanityName;
		this.stop=stop;
	}

	public String toString() {
		return this.stop + DirInbound;		
	}
	
	public void addLine(BusLine line) {
		busLine=line;
	}
	
	public String getVanityName() {
		return vanityName;
	}
	
	public BusLine getLine() {
		return busLine;
	}
}
