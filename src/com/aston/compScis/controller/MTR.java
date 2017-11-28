package com.aston.compScis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.aston.compScis.model.Line;
import com.aston.compScis.model.ReadFile;
import com.aston.compScis.model.Station;

/**
 * <h1>MTR</h1>
 * <hr> 
 * This will allow the Program to set all information to present to the user, implementing the Controller interface.
 * 
 * @see Controller
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class MTR implements Controller {

	// Read File Class
	//private ReadFile file = new ReadFile();
	// Station Class
	private Station station = new Station();
	// Line Class
	private Line currentLine = new Line();
	// HashMap
	private HashMap<Line, List<Station>> mtrLines;
	
	/**
	 * Get the Train Line Name and the Terminus of the Line
	 * 
	 * @return Train line Name and the Terminus of the line
	 */
	public String listAllTermini() {
		// Result Variable to pass to the UI
		String results = "\n";
		//Get the MTR Line Data
		currentLine.getMTRData();
		// Iterate over the HashMap information
		Iterator<Map.Entry<Line, List<Station>>> it = currentLine.getMTRLines().entrySet().iterator();
				//file.getMtrLine().entrySet().iterator();
		// while the HashMap has next information
		while (it.hasNext()) {
			//
			Entry<Line, List<Station>> pair = it.next();
			// Append the results to output the Train Line name
			results += ("Train Line: " + pair.getKey().getLineName() + "\n");
			// Append the results to output the terminus of the train line
			results += ("This train goes from:\t " + pair.getValue().get(0).getStationName() + " --- "
					+ pair.getValue().get(pair.getValue().size() - 1).getStationName() + "\n\n");
			// Pop it out from the iteration
			it.remove();
		}
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
		// Get the Data Information
		currentLine.getMTRData();
		// Iterate over the HashMap information
		Iterator<Map.Entry<Line, List<Station>>> it = currentLine.getMTRLines().entrySet().iterator();;
		//file.getMtrLine().entrySet().iterator();
		// while the HashMap has next information
		while (it.hasNext()) {
			// Make a new HashMap stating the iteration
			Entry<Line, List<Station>> pair = it.next();
			// If the HashMap Key is the requested Line
			if (pair.getKey().getLineName().equalsIgnoreCase(line)) {
				// Present the Train Line Name
				results += ("\nTrain Line: " + pair.getKey().getLineName() + "\n");
				results += ("This train goes from:\t ");
				// Loop Over the ArrayList in the HashMap
				for (int i = 0; i < pair.getValue().size(); i++) {
					// If the current index is the size
					if (pair.getValue().get(i).getStationName() == pair.getValue().get(pair.getValue().size() - 1).getStationName()) {
						// Present the LAST line station
						results += pair.getValue().get(i).getStationName();
					} else {
						// Present the Line station
						results += pair.getValue().get(i).getStationName() + " --- ";
					}
				}
				// New Line
				results += "\n\n";
				// Remove from the iteration
				it.remove();
			}

		}
		// If the Lines isn't known
		if (results == "") {
			// Output station isn't known
			results += "Not a known MTR Station.";
		}
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