package com.aston.compScis.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * <h1>ReadFile</h1> <br>
 * 
 * This allows to present the CSV file's information. This would come from the
 * MTRsystem_partial.csv file.
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class ReadFile {

	//Hash Map Data Structure to save the Line and Station
	private HashMap<Line, Station> mtrLine;
	//
	private Line line;
	//
	private Station station;
	// Variable to get the File Name
	private String fileName = "MTRsystem_partial.csv";
	
	
	/**
	 * Store the data of the CSV file to the HashMap(String, ArrayList)
	 * 
	 * @return Data
	 */
	public void getLine() {
		// Variable to store and split information
		String dataline;
		// Variable to detect the delimiting code
		String cvsSplitby = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			mtrLine = new HashMap<>();
			while ((dataline = br.readLine()) != null) {
				// Split the data and store in an Array
				String[] stations = dataline.split(cvsSplitby);
				// Store the key based on the first index of the Array
				String key = stations[0];
				// Loop on the Array
				for (int i = 1; i < stations.length; i++) {
					// Store the Line Name to the key to the List
					line.setLineName(key);
					// If the list is null
					if (station == null) {
						// Create a new ArrayList
						station = new List<Station>();
						//
						line.setStations(station.getStationName());
						// Add the list to the HashMap with the Key
						mtrLine.put(line, station);
					}
					// Add each station to the ArrayList.
					list.add(new String(stations[i]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the MTRData
	 * 
	 * @return mtrData 
	 */
	public HashMap<Line, Station> getMtrData() {
		return mtrLine;
	}

	/**
	 * Set the MTRData
	 * 
	 * @param mtrData
	 */
	public void setMtrLine(HashMap<Line, Station> mtrLine) {
		this.mtrLine = mtrLine;
	}
	
}
