package com.aston.compScis.model;

import java.util.List;

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
	private List<Station> stationName;
	
	public Station() {
		
	}
	
	public Station(List<Station> stationName) {
		this.stationName = stationName;
	}
	
	/**
	 * Get Station Name
	 * 
	 * @return Name of the Station 
	 */
	public List<Station> getStationName() {
		return stationName;
	}

	/**
	 * Set the Station
	 * 
	 * @param stationName
	 */
	public void setStationName(List<Station> stationName) {
		this.stationName = stationName;
	}

}
