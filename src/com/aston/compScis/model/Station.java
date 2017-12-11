package com.aston.compScis.model;

/**
 * <h1>Station Class</h1>
 * <p>This class shows any information related to the MTR Stations.
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class Station {

	//Station Name
	private String stationName;
	
	public Station() {
		stationName = null;
	}	
	
	public Station(String stationName) {
		this.stationName = stationName;
	}
	
	public String toString() {
		return stationName;
	}
}
