package com.aston.compScis.model;

/**
 * <h1>Station Class</h1>
 * <p>
 * This class shows any information related to the MTR Stations.
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class Station {

	// Station Name
	private String stationName;

	/**
	 * Constructs a station with a particular station
	 * 
	 * @param stationName
	 */
	public Station(String stationName) {
		this.stationName = stationName;
	}
	

	/**
	 * toString representation of station
	 * 
	 * @Return stationName
	 */
	public String toString() {
		return stationName;
	}
}
