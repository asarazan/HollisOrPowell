package com.sarazan.hollisorpowell;

public class BusStop {
	
	public static final String StopHorton_40 = "40hr";
	public static final String StopPixar = "pix";
	public static final String StopHollis_45 = "ho45";
	
	public static final String StopMacArthur = "bartw";
	
	public static final String DirInbound = "_i";
	public static final String DirOutbound = "_o";
	
	private String stop;
	private String direction;
	
	public BusStop(String stop,String direction) {
		this.stop=stop;
		this.direction=direction;
	}

	public String toString() {
		return this.stop + this.direction;		
	}
}
