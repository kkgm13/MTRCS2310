package com.aston.compScis.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.aston.compScis.model.Line;
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
public class MTR implements Controller {

	// Line Class
	private Line currentLine = new Line();

	/**
	 * Get the Train Line Name and the Terminus of the Line
	 * 
	 * @return Train line Name and the Terminus of the line
	 */
	public String listAllTermini() {
		// Result Variable to pass to the UI
		String results = "\n";
		// Get the MTR Line Data
		currentLine.getMTRLineData();
		// Iterate over the HashMap information
		Iterator<Map.Entry<Line, List<Station>>> it = currentLine.getMTRLines().entrySet().iterator();
		// while the HashMap has next information
		while (it.hasNext()) {
			// Make a new Entry of HashMaps
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
		currentLine.getMTRLineData();
		// Iterate over the HashMap information
		Iterator<Map.Entry<Line, List<Station>>> it = currentLine.getMTRLines().entrySet().iterator();
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
					if (pair.getValue().get(i).getStationName() == pair.getValue().get(pair.getValue().size() - 1)
							.getStationName()) {
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
		// Result Variable to pass to the UI
		String results = "";
		// Get the Data Information
		currentLine.getMTRLineData();
		// Iterate over the HashMap information
		// To get the intended line
		Iterator<Map.Entry<Line, List<Station>>> it = currentLine.getMTRLines().entrySet().iterator();
		// To get the matching Stations
		Iterator<Map.Entry<Line, List<Station>>> it2 = currentLine.getMTRLines().entrySet().iterator();
		// Create the intended Line for User
		Line searchedLine = new Line();
		// Station created
		List<Station> searchedLineStations;
		searchedLineStations = new ArrayList<>();
		
		/*
		 * Refactoring Infrmation
		 */
//		//Create a new String that get and stream the entry set of the
//		String intendedLine = currentLine.getMTRLines().entrySet().stream()
//				//Mapping the Key to the intended object
//				.map(e -> e.getKey())
//				//Get the Line's name
//				.map(Line::getLineName)
//				//Filter against the requestedLine 
//				.filter(line::equalsIgnoreCase)
//				//Get the String
//				.map(s -> s.toString())
//				// Create a new StringBulder and append the string builder of Lines
//				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
//				// As a String variable
//				.toString();
//		// Append to the results
//		results += "The " + intendedLine + " connects with the following lines: \n\t";
//		// Add the Stations from the current 
//		searchedLineStations.addAll(currentLine.getStations());
//		// Add list to the stations
//		searchedLine.setStations(searchedLineStations);
//		
			//Problem Here!
//		//Get the Stations
//		searchedLineStations = currentLine.getMTRLines().values().stream()
//				.map(s -> s.forEach(currentLine.getMTRLines().keySet()))
//				.filter(currentLine.getMTRLines().::equalsIgnoreCase)
//				.map(s -> s.toString())
//				.collect(StringBuilder:: new, StringBuilder::append, StringBuilder::append)
//				.toString();
//		searchedLineStations.addAll(currentLine.setStations(searchedLineStations));
		
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
					// Add to the ArrayList
					searchedLineStations.add(pair.getValue().get(i));
				}
				// Add list to the stations
				searchedLine.setStations(searchedLineStations);
			}
		}

		/*
		 * Compare the Line's station against
		 */
		// True/False if the line has been written
		boolean hasLine;
		//Loop while second local file 
		while (it.hasNext()) {
			// Make a new HashMap stating the iteration
			Entry<Line, List<Station>> pair = it.next();
			//set to false
			hasLine = false;
			// Loop over Local HashMap
			for (int j = 0; j < pair.getValue().size(); j++) {
				// Loop over Line Object
				for (int i = 0; i < searchedLine.getStations().size(); i++) {
					// If a station from the local HashMap (pair) contains a station from the Line
					// Object (searchedLine)
					if (searchedLine.getStations().get(i).getStationName()
							.contains(pair.getValue().get(j).getStationName())) {
						// If the stations are the same
						while (!hasLine) {
							if (searchedLine.getLineName().equalsIgnoreCase(pair.getKey().getLineName())) {
								// do nothing
								break;
							} else {
								// Input the Information of the line
								results += "- " + pair.getKey().getLineName() + "\n\t";
								//Line that has been inserted is known
								hasLine = true;

							}
						}
					}
				}
			}
			hasLine = false;
		}

		// If the Lines isn't known
		if (results == "") {
			// Output station isn't known
			results += "Not a known MTR Station or no known lines found.";
		}
		// Present to the user
		return results;
	}

	public String showPathBetween(String stationA, String stationB) {
		// TODO Auto-generated method stub
		return "hello";
	}

}