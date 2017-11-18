package com.aston.compScis.model;
import com.aston.compScis.view.LinearNode;

/**
 * 
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class MTRLine {
	private LinearNode<Station> lastInLine;
	private Station station;
	
	public MTRLine(Station station) {
		lastInLine = new LinearNode<>(station);
		this.station = station;
	}
	
	public void addNextInLine(Station stationName) {
		LinearNode<Station> node = new LinearNode<>(stationName);
		node.setNext(lastInLine);
		lastInLine = node;
	}
	
	public int size() {
		int count = 0;
		LinearNode<Station> current = lastInLine;
		while(current != null) {
			count++;
			current = current.getNext();
		}
		
		return count;
	}
	
	public String toString(){
		String results = null;
		int size = size();
		switch(size) { 
			case 0 : return results + "This is an unknown train station"; 
			default : results += "The termini for " + station.getName() + " is: ";
		}
		
		LinearNode<Station> current = lastInLine;
		
		while(current != null) {
			results += current.getElement().toString();
			current = current.getNext();
			if(current.getNext() == null && current.getElement() != null || current.getPrevious() == null && current.getElement() != null) {
				results += current.getElement().toString();
			}
		}
		
		return results;
	}
	
}
