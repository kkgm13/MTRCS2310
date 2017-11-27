package com.aston.compScis.model;

import java.util.List;

/**
 * 
 * @author Team CompSci's
 *
 */
public class Line {
	//Line Name
	private String lineName;
	//List of Stations in the line 
	private List<Station> stations;
	//Current Station
	private DoubleNode<Station> currentStation;
	// Previous Station
	private DoubleNode<Station> previousStation;
	// Next Station
	private DoubleNode<Station> nextStation;
	
	public Line(Station stations) {
		nextStation = new DoubleNode<>(stations);
	}
	
	public void addNextInLine(Station incomingStation) {
		DoubleNode<Station> station = new DoubleNode<>(incomingStation);
		station.setNext(nextStation);
		nextStation = station;
	}
	
	public int size() {
		int count = 0;
		DoubleNode<Station> current = nextStation;
		while(current != null) {
			count++;
			current = current.getNext();
		}
		
		return count;
	}
	
//	
//	public String toString() {
//		String stationList = 
//	}
//	
	
	
	
	
	
	/*
	 * Encapsulation
	 */
	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public DoubleNode<Station> getCurrentStation() {
		return currentStation;
	}

	public void setCurrentStation(DoubleNode<Station> currentStation) {
		this.currentStation = currentStation;
	}

	public DoubleNode<Station> getPreviousStation() {
		return previousStation;
	}

	public void setPreviousStation(DoubleNode<Station> previousStation) {
		this.previousStation = previousStation;
	}

	public DoubleNode<Station> getNextStation() {
		return nextStation;
	}

	public void setNextStation(DoubleNode<Station> nextStation) {
		this.nextStation = nextStation;
	}
	
	
	
}
