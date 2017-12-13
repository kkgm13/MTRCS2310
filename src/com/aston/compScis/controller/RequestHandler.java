package com.aston.compScis.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	 * @param line
	 *            Name of the Intended Train Line
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
					if (data.getValue().get(i).toString() == data.getValue().get(data.getValue().size() - 1)
							.toString()) {
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
			results += "Sorry, this is not a known MTR Line.";
		}
		// Pass result to the UI
		return results;
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
		String results = "";
		// To get the intended line
		Iterator<Map.Entry<Line, List<Station>>> it = metroData.getMTRLines().entrySet().iterator();
		// To get the matching Stations
		Iterator<Map.Entry<Line, List<Station>>> it2 = metroData.getMTRLines().entrySet().iterator();
		// Create the intended Line for User
		Line searchedLine = new Line(null);

		/*
		 * Search for the line
		 */
		while (it2.hasNext()) {
			// Make a new HashMap stating the iteration
			Entry<Line, List<Station>> pair = it2.next();
			// If the searched line is the line in the
			if (pair.getKey().getLineName().equalsIgnoreCase(line)) {
				// Add the Line Name
				searchedLine.setLineName(pair.getKey().getLineName());
				// Append the result
				results += "The " + pair.getKey().getLineName() + " connects with the following lines: \n\t";
				// Loop through the HashMap Station Values
				for (int i = 0; i < pair.getValue().size(); i++) {
					// Add the Double Node of stations
					searchedLine.addNextStation(pair.getValue().get(i));
				}
			}
		}

		/*
		 * Compare the Line's station against
		 */
		// True/False if the line has been written
		boolean hasLine;
		// Loop while second local file
		while (it.hasNext()) {
			// Make a new HashMap stating the iteration
			Entry<Line, List<Station>> pair = it.next();
			// set to false
			hasLine = false;
			// Loop over Iteration HashMap
			for (int j = 0; j < pair.getValue().size(); j++) {
				// Loop over Line Object
				for (int i = 0; i < searchedLine.getStationList().size(); i++) {
					// If a station from the local HashMap (pair) contains a station from the Line
					// Object (searchedLine)
					if (searchedLine.getStationList().get(i).getElement().toString()
							.equals(pair.getValue().get(j).toString())) {
						// While no iteration of the line is known
						while (!hasLine) {
							// If the line are exactly the same
							if (searchedLine.getLineName().equals(pair.getKey().getLineName())) {
								// DO NOT CHANGE
								break;
							} else {
								// Input the Information of the line
								results += "- " + pair.getKey().getLineName().toString() + "\n\t";
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

		// If the Lines isn't known
		if (results == "") {
			// Output station isn't known
			results += "Sorry, this station is not known or has no lines.";
		}
		// Present to the user
		return results;

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
		String results = "";
		// Create Nodes
		DoubleNode<Station> startStation = null;
		DoubleNode<Station> endStation = null;
		// Create Station Class
		Station firstStation = null;
		Station lastStation = null;

		Iterator<Map.Entry<Line, List<Station>>> itrData = metroData.getMTRLines().entrySet().iterator();

		// Condition to stop iterating over
		boolean firstGot = false;
		boolean lastGot = false;
		// While data has more information
		while (itrData.hasNext()) {
			//Create Entry from iterator
			Entry<Line, List<Station>> pair = itrData.next();
			//Loop over the data
			for (int i = 0; i < pair.getValue().size(); i++) {
				//If Starting Station does match the user's intended station and hasn't been captured.
				if (pair.getValue().get(i).toString().equalsIgnoreCase(stationA) && !firstGot) {
					//Create the Station based on the data
					firstStation = new Station(pair.getValue().get(i).toString());
					startStation = new DoubleNode<Station>(new Station(pair.getValue().get(i).toString()));
					
					//Make it true
					firstGot = true;
					System.out.println("this is " +firstStation+"\n"+startStation.getElement());
				}
				//If Ending Station does match the user's intended station and hasn't been captured.
				if (pair.getValue().get(i).toString().equalsIgnoreCase(stationB) && !lastGot) {
					//Create the Station based on the data
					lastStation = new Station(pair.getValue().get(i).toString());
					endStation = new DoubleNode<Station>(new Station(pair.getValue().get(i).toString()));
					//Make it true
					lastGot = true;
					System.out.println("this is " +lastStation+"\n"+endStation.getElement());
				}
			}
		}

		// Create the LinkedStack
		LinkedStack<Station> routePath = new LinkedStack<Station>();
		// First Station to be placed inside the Stack
		routePath.push(firstStation);
		/*
		 * Stuff to get between the first Station and the Last Station
		 */
		// Last Staion to be placed inside the Stack
		routePath.push(lastStation);
		
		
		List<Station> reversedStack = new ArrayList<Station>();

		
		results += "To get to " + firstStation.toString() + " to " + lastStation.toString()+ ",\n the route to take is:\n";
		
		return results;
	}

}