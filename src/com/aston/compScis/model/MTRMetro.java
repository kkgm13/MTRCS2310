package com.aston.compScis.model;

import java.util.HashMap;
import java.util.List;

/**
 * <h1>MTRMetro</h1>
 * <p>This class is the main handler between the 
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class MTRMetro {

	//Main Data Holder as a HashMap of Lines and a List of Related Stations
	private HashMap<Line, List<Station>> mtrLine;
	//CSV Reader
	private ReadFile file;
	
	/**
	 * <h1>MTRMetro Constructor</h1>
	 * <p>This handles the initialisation of the MTR Metro
	 */
	public MTRMetro() {
		//Initialise Variables
		file = new ReadFile();
		mtrLine = new HashMap<Line, List<Station>>();
		//Get the Data
		getMTRData();
	}
	
	/**
	 * Get the Data from the Read File
	 */
	private void getMTRData() {
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
