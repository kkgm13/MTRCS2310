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
	
	/**
	 * Get Station Name
	 * 
	 * @return Name of the Station 
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * Set the Station
	 * 
	 * @param stationName
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

}
