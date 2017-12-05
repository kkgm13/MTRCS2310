package com.aston.compScis.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * <h1>ReadFile</h1>
 * 
 * <p>This allows to grab the Data from the CSV file.
 * This would come from the MTRsystem_partial.csv file.
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class ReadFile {
	// Hash Map Data Structure to save the Line and Station
	private HashMap<Line, List<Station>> mtrLine;
	// File Name Path Name
	private String fileName = "MTRsystem_partial.csv";
	// Line Class
	private Line line;
	// Station Class
	private Station station;

	/**
	 * Store the data of the CSV file to the HashMap(Line, List of Stations)
	 * 
	 * @return MTR Data as a HashMap with the Key of Lines
	 */
	public void getLine() {
		// Variable to store and split information
		String dataLine;
		// Variable to detect the delimiting code
		String cvsSplitby = ",";

		// Grab the CSV data
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			// Create a new HashMap
			mtrLine = new HashMap<>();
			// While the data is being grabbed
			while ((dataLine = br.readLine()) != null) {
				// Split the data and store in an Array
				String[] listOfStations = dataLine.split(cvsSplitby);
				// Create empty line
				line = new Line();
				// Store the key based on the first index of the Array
				line.setLineName(listOfStations[0]);
				// Loop on the Array CSV line
				for (int i = 1; i < listOfStations.length; i++) {
					// Create a new Station
					station = new Station();
					// Set the new Station
					station.setStationName(listOfStations[i]);
					// Add the station to the List of Stations
					line.getStations().add(station);
				}
				// Place it into the HashMap
				mtrLine.put(line, line.getStations());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the MTRData with Line
	 * 
	 * @return mtrData
	 */
	public HashMap<Line, List<Station>> getMtrLine() {
		return mtrLine;
	}

	/**
	 * Set the MTRData with Line
	 * 
	 * @param mtrData
	 */
	public void setMtrLine(HashMap<Line, List<Station>> mtrLine) {
		this.mtrLine = mtrLine;
	}

	
	
}
