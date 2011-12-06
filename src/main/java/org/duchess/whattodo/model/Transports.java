package org.duchess.whattodo.model;

import static com.google.common.base.Objects.equal;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class Transports {

	private List<Station> stations;

	public Transports() {
		stations = new ArrayList<Station>();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Transports) {
			Transports other = (Transports) obj;
			return equal(stations, other.stations);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(stations);
	}

	public void addStation(Station station) {
		stations.add(station);
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public List<Station> getStations() {
		return stations;
	}
}
