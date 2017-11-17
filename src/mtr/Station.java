package mtr;

public class Station {
	
	private int data;
	private Station next = null;
	private Station previous = null;
	
	
	public Station (int data){
	    
		previous = null;
		this.data = data;
		next = null;
	}
	
	public Station (Station previous, int data, Station next){
		
		this.previous = previous;
		this.data = data;
		this.next = next;
	}

}
