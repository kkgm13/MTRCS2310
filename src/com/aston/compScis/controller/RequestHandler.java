package com.aston.compScis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.aston.compScis.model.DoubleNode;
import com.aston.compScis.model.Line;
import com.aston.compScis.model.LinkedStack;
import com.aston.compScis.model.MTRMetro;
import com.aston.compScis.model.Station;

/**
 * <h1>RequestHandler</h1>
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

	// MTR Metro Class
	private MTRMetro metroData;
	//String Builder
	private StringBuilder results;

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
		results = new StringBuilder();
		// While the HashMap has next information
		for(Entry<Line, List<Station>> data : metroData.getMTRLines().entrySet()) {
			// Append the results to output the Train Line name
			results.append("Train Line: " + data.getKey().getLineName() + "\n");
			// Append the results to output the starting terminus of the train line
			results.append("This train goes from:\t " + data.getValue().get(0).toString() + " --- ");
			// Append the results to output the ending terminus of the train line
			results.append(data.getValue().get(data.getValue().size() - 1).toString() + "\n\n");
		}
		// Present to the user the results
		return results.toString();
	}

	/**
	 * List all the stations of the User's desired line
	 * 
	 * @param line
	 *            Name of the Intended Train Line
	 * @return The Train Line and the Associated Stations
	 */
	public String listStationsInLine(String line) {
		// Result Variable to pass to the UI
		results = new StringBuilder();
		// while the HashMap has next information
		for(Entry<Line, List<Station>> data : metroData.getMTRLines().entrySet()) {			
			// If the HashMap Key is the requested Line
			if (data.getKey().getLineName().equalsIgnoreCase(line)) {
				// Present the Train Line Name
				results.append("This line, " + data.getKey().getLineName() + ", goes through the following stations:\n");
				// Loop Over the ArrayList in the HashMap
				for (int i = 0; i < data.getValue().size(); i++) {
					// Present the Line station
						results.append("\t-" + data.getValue().get(i).toString() + "\n");
				}
			}
		}
		// If the Line isn't known
		if (results.toString().equals("")) {
			// Output station isn't known
			results.append("Sorry, this is not a known MTR Line.");
		}
		// Present to the user the results
		return results.toString();
	}

	/**
	 * List all the connected lines of the User's Desired Line
	 * 
	 * @param line
	 *            Name of the Intended Line
	 * @return The Train Line and the Interconnected Lines
	 */
	public String listAllDirectlyConnectedLines(String line) {
		// Result Variable to pass to the UI
		results = new StringBuilder();
		// Create the intended Line for User
		Line searchedLine = new Line(null);

		/*
		 * Search for the line
		 */
		for(Entry<Line, List<Station>> data : metroData.getMTRLines().entrySet()) {		
			// If the searched line is the line in the
			if (data.getKey().getLineName().equalsIgnoreCase(line)) {
				// Add the Line Name
				searchedLine.setLineName(data.getKey().getLineName());
				// Append the result
				results.append("The " + data.getKey().getLineName() + " connects with the following lines: \n\t");
				// Loop through the HashMap Station Values
				for (int i = 0; i < data.getValue().size(); i++) {
					// Add the Double Node of stations
					searchedLine.addNextStation(data.getValue().get(i));
				}
			}
		}

		/*
		 * Compare the Line's station against the MTR Metro HashMap Data
		 */
		// True/False if the line has been written
		boolean hasLine;
		// Loop while second local file
		for(Entry<Line, List<Station>> data : metroData.getMTRLines().entrySet()) {			
			// set to false
			hasLine = false;
			// Loop over Iteration HashMap
			for (int j = 0; j < data.getValue().size(); j++) {
				// Loop over Line Object
				for (int i = 0; i < searchedLine.getStationList().size(); i++) {
					// If a station from the local HashMap (pair) contains a station from the Line
					// Object (searchedLine)
					if (searchedLine.getStationList().get(i).getElement().toString()
							.equals(data.getValue().get(j).toString())) {
						// While no iteration of the line is known
						while (!hasLine) {
							// If the line are exactly the same
							if (searchedLine.getLineName().equals(data.getKey().getLineName())) {
								// DO NOT CHANGE - Removes the repeating line
								break;
							} else {
								// Input the Information of the line
								results.append("- " + data.getKey().getLineName().toString() + "\n\t");
								// Line that has been inserted is known
								hasLine = true;
							}
						}
					}
				}
			}
			// Reset Boolean
			hasLine = false;
		}

		// If the Lines/Stations aren't known
		if (results.toString().equals("")) {
			// Output station isn't known
			results.append("Sorry, this station is not known or has no lines.");
		}
		// Present to the user the results
		return results.toString();

	}

	/**
	 * Show the station path between two stations
	 * 
	 * @param stationA
	 *            Name of the Starting Station
	 * @param stationB
	 *            Name of the Ending Station
	 * @return The path between the Starting station and the Ending station
	 */
	public String showPathBetween(String stationA, String stationB) {
		results = new StringBuilder();
		// Create Nodes
		DoubleNode<Station> startStation = null;
		DoubleNode<Station> endStation = null;
		// Create Station Class
		Station firstStation = null;
		Station lastStation = null;

		// Condition to stop iterating over
		boolean firstGot = false;
		boolean lastGot = false;
		// While data has more information
		for(Entry<Line, List<Station>> data : metroData.getMTRLines().entrySet()) {	
			// Loop over the data
			for (int i = 0; i < data.getValue().size(); i++) {
				// If Starting Station does match the user's intended station and hasn't been
				// captured.
				if (data.getValue().get(i).toString().equalsIgnoreCase(stationA) && !firstGot) {
					// Create the Station based on the data
					firstStation = new Station(data.getValue().get(i).toString());
					startStation = new DoubleNode<Station>(new Station(data.getValue().get(i).toString()));

					// Make it true
					firstGot = true;
				}
				// If Ending Station does match the user's intended station and hasn't been
				// captured.
				if (data.getValue().get(i).toString().equalsIgnoreCase(stationB) && !lastGot) {
					// Create the Station based on the data
					lastStation = new Station(data.getValue().get(i).toString());
					endStation = new DoubleNode<Station>(new Station(data.getValue().get(i).toString()));
					// Make it true
					lastGot = true;
				}
			}
		}

		try {
			//If the starting and ending stations are the same
			if(firstStation.toString().equals(lastStation.toString())) {
				// Append to the user of the same station 
				results.append("You are currently at your entry/destination station.");
			} else {
				// Create the LinkedStack
				LinkedStack<Station> routePath = new LinkedStack<Station>();
				// First Station to be placed inside the Stack
				routePath.push(firstStation);
				/*
				 * DPS to get between the first Station and the Last Station
				 */
				
				// Last Station to be placed inside the Stack
				routePath.push(lastStation);
		
				List<Station> reversedStack = new ArrayList<Station>();
				// Append the information to the user
				results.append("To get to " + firstStation.toString() + " to " + lastStation.toString()+ ",\n the route to take is:\n");
			}
		// Catch any NullPointerException to bypass non-existing or incorrect stations
		} catch(NullPointerException npe) {
			// Reset the length to Nothing
			results.setLength(0);
			// Append that it isn't found
			results.append("The following stations inputted are not known stations.\nPlease check if you have placed the correct stations.");
		}
		
		// Present to the user the results
		return results.toString();
	}

}