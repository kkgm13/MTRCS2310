package mtr;

public class ControllerOptions implements Controller {
	private Station station;
	private Line line;
	
	
	public String listAllTermini() {
		String test = station.getName();
		return test;
	}

	public String listStationsInLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}

	public String listAllDirectlyConnectedLines(String line) {
		// TODO Auto-generated method stub
		return null;
	}

	public String showPathBetween(String stationA, String stationB) {
		// TODO Auto-generated method stub
		return null;
	}

}
