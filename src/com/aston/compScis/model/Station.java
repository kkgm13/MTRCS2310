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
	private String stationName;
	//Station Node
	private List<Station> stationList;
	
	public Station() {
		
	}
	
	public Station(String stationName) {
		this.stationName = stationName;
	}
	
	public String toString() {
		return stationName;
	}
	
	
	public Station(List<Station> stationList) {
		this.stationList = stationList;
	}
	
	/**
	 * Get Station Name
	 * 
	 * @return Name of the Station 
	 */
	public List<Station> getStationList() {
		return stationList;
	}

	/**
	 * Set the Station
	 * 
	 * @param stationName
	 */
	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	/**
	 * @return the stationName
	 */
//	public String getStationName() {
//		return stationName;
//	}

	/**
	 * @param stationName the stationName to set
	 */
//	public void setStationName(String stationName) {
//		this.stationName = stationName;
//	}

}
