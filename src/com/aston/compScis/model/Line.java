package com.aston.compScis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <h1>Line</h1>
 * <p>This class stores any related information about the MTR's Line.
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class Line {
	//Name of the Line
	private String lineName;
	//List of Station Objects
	private List<Station> stations = new ArrayList<>();
	
	/**
	 * Get the Line Name
	 * 
	 * @return Name of the Line
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * Set the Line Name
	 * 
	 * @param lineName
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	/**
	 * Get the List of Stations
	 * 
	 * @return List of Stations
	 */
	public List<Station> getStations() {
		return stations;
	}

	/**
	 * Set the List of Stations
	 * 
	 * @param stations
	 */
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

}
