package com.aston.compScis.model;

import java.util.HashMap;

/**
 * <h1>The Line Model</h1>
 * <br>
 * This represents a model of what a MTR line.
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class Line {
		//Name of the Line
	private String name;
		//The Line's Stations
	private HashMap<Line, Station> lineStations;
	
	public Line(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Line, Station> getLineStations() {
		return lineStations;
	}

	public void setLineStations(HashMap<Line, Station> lineStations) {
		this.lineStations = lineStations;
	}
	
	
}
