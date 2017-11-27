package com.aston.compScis.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.aston.compScis.model.Line;
import com.aston.compScis.model.ReadFile;
import com.aston.compScis.model.Station;

/**
 * <h1>MTR</h1>
 * 
 * This will allow the Program to set all information to present to the user.
 * <br>
 * This also implements the Controller interface.
 * 
 * @see Controller
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class MTR implements Controller {

	//Read File Class
//	private ReadFile file = new ReadFile();
	
	private Line line;
	private Station station;
	
	

	/**
	 * Get the Train Line Name and the Terminus of the Line
	 * 
	 * @return Train line Name and the Terminus of the line
	 */
	public String listAllTermini() {
		// Result Variable to pass to the UI
		String results = "\n";
		results += "Hello";
		// Get the Data Information
//		file.getLine();
//		// Iterate over the HashMap information
//		Iterator<Map.Entry<String, ArrayList<String>>> it = file.getMtrData().entrySet().iterator();
//		// while the HashMap has next information
//		while (it.hasNext()) {
//			//
//			Entry<String, ArrayList<String>> pair = it.next();
//			// Append the results to output the Train Line name
//			results += ("Train Line: " + pair.getKey() + "\n");
//			// Append the results to output the terminus of the train line
//			results += ("This train goes from:\t " + pair.getValue().get(0) + " --- "
//					+ pair.getValue().get(pair.getValue().size() - 1) + "\n\n");
//			// Pop it out from the iteration
//			it.remove();
//		}
		// Pass to the UI
		return results;
	}

	/**
	 * List all the train stations of the train line
	 * 
	 * @param line
	 *            Name of the Intended Train Line
	 * @return The Train and the Stations Associated
	 */
	public String listStationsInLine(String line) {
		// Result Variable to pass to the UI
		String results = "";
//		// Get the Data Information
//		file.getLine();
//		// Iterate over the HashMap information
//		Iterator<Map.Entry<String, ArrayList<String>>> it = file.getMtrData().entrySet().iterator();
//		// while the HashMap has next information
//		while (it.hasNext()) {
//			// Make a new HashMap stating the iteration
//			Entry<String, ArrayList<String>> pair = it.next();
//			// If the HashMap Key is the requested Line
//			if (pair.getKey().equalsIgnoreCase(line)) {
//				// Present the Train Line Name
//				results += ("\nTrain Line: " + pair.getKey() + "\n");
//				results += ("This train goes from:\t ");
//				// Loop Over the ArrayList in the HashMap
//				for (int i = 0; i < pair.getValue().size(); i++) {
//					// If the current index is the size
//					if (pair.getValue().get(i) == pair.getValue().get(pair.getValue().size() - 1)) {
//						// Present the LAST line station
//						results += pair.getValue().get(i);
//					} else {
//						// Present the Line station
//						results += pair.getValue().get(i) + " --- ";
//					}
//				}
//				// New Line
//				results += "\n\n";
//				// Remove from the iteration
//				it.remove();
//			}
//
//		}
//		// If the Lines isn't known
//		if (results == "") {
//			// Output station isn't known
//			results += "Not a known MTR Station.";
//		}
		results += "Hello";
		// Pass result to the UI
		return results;
	}

	public String listAllDirectlyConnectedLines(String line) {
		// TODO Auto-generated method stub
		return "hello";
	}

	public String showPathBetween(String stationA, String stationB) {
		// TODO Auto-generated method stub
		return "hello";
	}

}