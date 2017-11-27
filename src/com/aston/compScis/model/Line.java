package com.aston.compScis.model;

import java.util.List;

public class Line {

	private String lineName;

	private List<Station> stations;

	public Line(String lineName, List<Station> stations) {

		this.lineName = lineName;
		this.stations = stations;
	}

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

}
