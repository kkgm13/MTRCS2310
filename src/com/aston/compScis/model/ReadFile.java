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
	ArrayList<String> list;

	/**
	 * Get the Train Line Name and the Terminus of the Line
	 * 
	 * @return Train line Name and the Terminus of the line
	 */
	public String getFirstAndLastTermini() {
		// Result Variable to pass to the UI
		String results = "\n";
		// Get the Data Information
		getLine();
		// Iterate over the HashMap information
		Iterator<Map.Entry<String, ArrayList<String>>> it = mtrData.entrySet().iterator();
		// while the HashMap has next information
		while (it.hasNext()) {
			//
			Entry<String, ArrayList<String>> pair = it.next();
			// Append the results to output the Train Line name
			results += ("Train Line: " + pair.getKey() + "\n");
			// Append the results to output the terminus of the train line
			results += ("This train goes from:\t " + pair.getValue().get(0) + " --- "
					+ pair.getValue().get(pair.getValue().size() - 1) + "\n\n");
			// Pop it out from the iteration
			it.remove();
		}
		// Pass to the UI
		return results;
	}

	/**
	 * List all the train stations of the train line
	 * 
	 * @param line Name of the Intended Train Line
	 * @return The Train and the Stations Associated
	 */
	public String listStationsInLine(String line) {
		// Result Variable to pass to the UI
		String results = "";
		// Get the Data Information
		getLine();
		// Iterate over the HashMap information
		Iterator<Map.Entry<String, ArrayList<String>>> it = mtrData.entrySet().iterator();
		// while the HashMap has next information
		while (it.hasNext()) {
			//Make a new HashMap stating the iteration
			Entry<String, ArrayList<String>> pair = it.next();
			//If the HashMap Key is the requested Line
			if (pair.getKey().equalsIgnoreCase(line)) {
				//Present the Train Line Name
				results += ("\nTrain Line: " + pair.getKey() + "\n");
				results += ("This train goes from:\t ");
				//Loop Over the ArrayList in the HashMap
				for (int i = 0; i < pair.getValue().size(); i++) {
					//If the current index is the size
					if (pair.getValue().get(i) == pair.getValue().get(pair.getValue().size() - 1)) {
						//Present the LAST line station
						results += pair.getValue().get(i);
					} else {
						//Present the Line station
						results += pair.getValue().get(i) + " --- ";
					}
				}
				//New Line
				results += "\n\n";
				//Remove from the iteration
				it.remove();
			} 

		}
		//If the Lines isn't known
		if(results == "") {
			//Output station isn't known
			results += "Not a known MTR Station.";
		}
		//Pass result to the UI
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
