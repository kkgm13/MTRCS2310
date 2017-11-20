package com.aston.compScis.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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

	HashMap<String, ArrayList<String>> mtrData = new HashMap<>();
	ArrayList<String> mtrStations = new ArrayList<String>();
	ArrayList<String> list;

	/**
	 * Get the Train Line Name and the Terminus of the Line
	 * 
	 * @return Train line Name and the Terminus of the line
	 */
	public String getFirstAndLastTermini() {
		// Result Variable to pass to the UI
		String results = "";
		// Get the Data Information
		getLine();
		Iterator<Map.Entry<String, ArrayList<String>>> it = mtrData.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, ArrayList<String>> pair = it.next();
			results += ("Train Line: " + pair.getKey() + "\n");
			results += ("This train goes from:\t " + pair.getValue().get(0) + " --- " + pair.getValue().get(pair.getValue().size() - 1) + "\n\n");
			it.remove();
		}
		return results;
	}
	
	//Get the Line's Station List
	public String listStationsInLine(String line) {
		String results = "";
		getLine();
		Iterator<Map.Entry<String, ArrayList<String>>> it = mtrData.entrySet().iterator();
		/**
		 * Change Starting Here
		 */
		while (it.hasNext()) {
			Entry<String, ArrayList<String>> pair = it.next();
			if (pair.getKey() == line) {
				results += ("Train Line: " + pair.getKey() + "\n");
				results += ("This train goes from:\t " + pair.getValue() + " --- " + "" + "\n\n");
				it.remove();
			}
		}
		return results;
	}

	/**
	 * Store the data of the CSV file to the HashMap(String, ArrayList)
	 * 
	 * @return Data
	 */
	private void getLine() {
		// Variable to get the File Name
		String fileName = "MTRsystem_partial.csv";
		// Variable to store and split information
		String line;
		// Variable to detect the delimiting code
		String cvsSplitby = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((line = br.readLine()) != null) {
				// Split the data and store in an Array
				String[] stations = line.split(cvsSplitby);
				// Store the key based on the first index of the Array
				String key = stations[0];
				// Loop on the Array
				for (int i = 1; i < stations.length; i++) {
					// Store the Line Name to the key to the List
					list = mtrData.get(key);
					// If the list is null
					if (list == null) {
						// Create a new ArrayList
						list = new ArrayList<>();
						// Add the list to the HashMap with the Key
						mtrData.put(key, list);
					}
					// Add each station to the ArrayList.
					list.add(new String(stations[i]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
