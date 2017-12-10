package com.aston.compScis.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.aston.compScis.model.Line;
import com.aston.compScis.model.MTRMetro;
import com.aston.compScis.model.Station;

/**
 * <h1>MTR</h1>
 * <hr>
 * This will allow the Program to set all information to present to the user,
 * implementing the Controller interface.
 * 
 * @see Controller
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class RequestHandler implements Controller {

	// Line Class
	private MTRMetro metroData;

	/**
	 * MTR Constructor
	 */
	public RequestHandler() {
		// Initialise MTRMetro
		metroData = new MTRMetro();
	}

	/**
	 * Get All lines with their respected Terminus
	 * 
	 * @return Train line Name and the Terminus of the line
	 */
	public String listAllTermini() {
		// Result Variable to pass to the UI
		String results = "\n";
		// Iterate over the HashMap information
		Iterator<Map.Entry<Line, List<Station>>> itrData = metroData.getMTRLines().entrySet().iterator();
		// While the HashMap has next information
		while (itrData.hasNext()) {
			// Make a new Entry of HashMaps
			Entry<Line, List<Station>> data = itrData.next();
			// Append the results to output the Train Line name
			results += ("Train Line: " + data.getKey().getLineName() + "\n");
			// Append the results to output the starting terminus of the train line
			results += ("This train goes from:\t " + data.getValue().get(0).toString() + " --- ");
			// Append the results to output the ending terminus of the train line
			results += (data.getValue().get(data.getValue().size() - 1).toString() + "\n\n");
		}
		// Pass to the UI
		return results;
	}

	/**
	 * List all the stations of the User's desired line
	 * 
	 * @param line Name of the Intended Train Line
	 * @return The Train Line and the Associated Stations 
	 */
	public String listStationsInLine(String line) {
		// Result Variable to pass to the UI
		String results = "";
		// Iterate over the HashMap information
		Iterator<Map.Entry<Line, List<Station>>> itrData = metroData.getMTRLines().entrySet().iterator();
		// while the HashMap has next information
		while (itrData.hasNext()) {
			// Make a new HashMap stating the iteration
			Entry<Line, List<Station>> data = itrData.next();
			// If the HashMap Key is the requested Line
			if (data.getKey().getLineName().equalsIgnoreCase(line)) {
				// Present the Train Line Name
				results += ("\nTrain Line: " + data.getKey().getLineName() + "\n");
				results += ("This train goes from:\t ");
				// Loop Over the ArrayList in the HashMap
				for (int i = 0; i < data.getValue().size(); i++) {
					// If the current index is the size
					if (data.getValue().get(i).toString() == data.getValue().get(data.getValue().size() - 1).toString()) {
						// Present the LAST line station
						results += data.getValue().get(i).toString();
					} else {
						// Present the Line station
						results += data.getValue().get(i).toString() + " --- ";
					}
				}
				// New Line
				results += "\n\n";
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

	/**
	 * List all the connected lines of the User's Desired Line
	 * 
	 * @param line Name of the Intended Line
	 * @return The Train Line and the Interconnected Lines  
	 */
	public String listAllDirectlyConnectedLines(String line) {
		// Result Variable to pass to the UI
		String results = "";
		// To get the intended line
		Iterator<Map.Entry<Line, List<Station>>> it = metroData.getMTRLines().entrySet().iterator();
		// To get the matching Stations
		Iterator<Map.Entry<Line, List<Station>>> it2 = metroData.getMTRLines().entrySet().iterator();
		// Create the intended Line for User
		Station station = new Station(metroData.getMTRLines().toString()); //????
		Line searchedLine = new Line(station);
		// Station created
		List<Station> searchedLineStations;
		searchedLineStations = new LinkedList<>();

		/*
		 * Search for the line
		 */
		while (it2.hasNext()) {
			// Make a new HashMap stating the iteration
			Entry<Line, List<Station>> pair = it2.next();
			// If the searched line is the line in the
			if (pair.getKey().getLineName().equalsIgnoreCase(line)) {
				// Set the Name of the Line
				searchedLine.setLineName(pair.getKey().getLineName());
				results += "The " + searchedLine.getLineName() + " connects with the following lines: \n\t";
				// Loop through the HashMap Station Values
				for (int i = 0; i < pair.getValue().size(); i++) {
					searchedLine.addNextStation(pair.getValue().get(i));
				}
			}
		}

		/*
		 * Compare the Line's station against
		 */
		// True/False if the line has been written
//		boolean hasLine;
//		// Loop while second local file
//		while (it.hasNext()) {
//			// Make a new HashMap stating the iteration
//			Entry<Line, List<Station>> pair = it.next();
//			// set to false
//			hasLine = false;
//			// Loop over Local HashMap
//			for (int j = 0; j < pair.getValue().size(); j++) {
//				// Loop over Line Object
//				for (int i = 0; i < searchedLine.getStations().size(); i++) {
//					// If a station from the local HashMap (pair) contains a station from the Line
//					// Object (searchedLine)
//					if (searchedLine.getStations().get(i).toString()
//							.contains(pair.getValue().get(j).toString())) {
//						// If the stations are the same
//						while (!hasLine) {
//							if (searchedLine.getLineName().equalsIgnoreCase(pair.getKey().getLineName())) {
//								// do nothing
//								break;
//							} else {
//								// Input the Information of the line
//								results += "- " + pair.getKey().getLineName() + "\n\t";
//								// Line that has been inserted is known
//								hasLine = true;
//
//							}
//						}
//					}
//				}
//			}
//			hasLine = false;
//		}

		// If the Lines isn't known
		if (results == "") {
			// Output station isn't known
			results += "Not a known MTR Station or no known lines found.";
		}
		// Present to the user
		return results;

	}

	public String showPathBetween(String stationA, String stationB) {

		return "hello";
	}

}