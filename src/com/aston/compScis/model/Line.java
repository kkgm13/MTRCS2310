package com.aston.compScis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Line {

	//Name of the Line
	private String lineName;
	//List of Station Objects
	private List<Station> stations = new ArrayList<>();
	//ReadFile Class
	private ReadFile file = new ReadFile();
	//Hash Map Data Structure to save the Line and Station
	private HashMap<Line, List<Station>> mtrLine;

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
	
	/**
	 * Get the Data from the Read File
	 */
	public void getMTRData() {
		mtrLine = new HashMap<Line, List<Station>>();
		file.getLine();
		mtrLine = file.getMtrLine();
	}
	
	/**
	 * Get the MTR Line HashMap 
	 * 
	 * @return mtrLine 
	 */
	public HashMap<Line, List<Station>> getMTRLines() {
		return mtrLine;
	}

	/**
	 * Set the MTR Line HashMap 
	 * 
	 * @param mtrLine
	 */
	public void setMTRLines(HashMap<Line, List<Station>> mtrLine) {
		this.mtrLine = mtrLine;
	}

}
