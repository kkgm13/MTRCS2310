package mtr;

public class Station {
	
	private int data;
	private Station next;
	private Station previous;
	private Station currentStation;
	private String name;

	public Station(int data, String name){
		previous = null;
		this.data = data;
		next = null;
		this.name = name;
	}
	
	public Station(Station currentStation){
		this.previous = null;
		this.currentStation = currentStation;
		this.next = null;
	}

}
