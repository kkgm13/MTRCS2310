package com.aston.compScis.model;

import java.util.LinkedList;
import java.util.List;

import com.aston.compScis.model.Station;
/**
 * <h1>Line</h1>
 * <p>This class stores any related information about the MTR's Line.
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class Line {
	//Name of the Line
	private String lineName;
	//DoubleNode List of Stations
	private DoubleNode<Station> lastStation;
	private DoubleNode<Station> nextStation;
	
	private List<DoubleNode<Station>> stationList;

	public Line(Station station){
		stationList = new LinkedList<>();
		lastStation = new DoubleNode<>();
	}
	
	public void addNextStation(Station currentStation){
		DoubleNode<Station> stationNode = new DoubleNode<>(currentStation);
		stationNode.setNext(lastStation);
		stationNode.setPrevious(nextStation);
		lastStation = stationNode;
		stationList.add(stationNode);
	}
	
	/**
	 * Size of the DoubleNode
	 * 
	 * @return the size of the DoubleNode
	 */
	public int size(){
		int stationCount = 0;
		DoubleNode<Station> currentStation = lastStation;
		while(currentStation != null){
			stationCount ++;
			currentStation = currentStation.getNext();
		}
		return stationCount;
	}
	
	/**
	 * Get the Line Name
	 * 
	 * @return Name of the Line
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * Set the Line Name
	 * 
	 * @param lineName
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	
	public List<DoubleNode<Station>> getStationList() {
		return stationList;
	}

	public void setStationList(List<DoubleNode<Station>> stationList) {
		this.stationList = stationList;
	}
	
}
