package com.aston.compScis.model;

import java.util.HashMap;

/**
 * The Station Model
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class Station {
		//Name of the Station
	private String name;
		//List of Lines Associated to the station
	private HashMap<Line, Station> representedLine;

	/**
	 * This allows a station to be created and modelled
	 * 
	 * @param name Name of the Station
	 */
	public Station(String name) {
		this.name = name;
	}
	
	/**
	 * Get the Station name
	 * 
	 * @return name Name of the Station
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the Station's Name
	 * 
	 * @param name Name of the Station
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Station's associated line
	 * @return
	 */
	public HashMap<Line, Station> getRepresentedLine() {
		return representedLine;
	}

	/**
	 * Set the Station's associated line
	 * @param representedLine
	 */
	public void setRepresentedLine(HashMap<Line, Station> representedLine) {
		this.representedLine = representedLine;
	}

}
