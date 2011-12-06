package org.duchess.whattodo.model;

import static com.google.common.base.Objects.equal;

import com.google.common.base.Objects;

public class Station {

	private String type;

	private String ligne;

	private String name;

	private int distance;

	public Station() {
		this.name = "";
	}

	public Station(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public double getDistance() {
		return distance;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Station) {
			Station other = (Station) obj;
			return equal(name, other.name) && equal(distance, other.distance)
					&& equal(type, other.type) && equal(ligne, other.ligne);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, distance, type, ligne);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("name", name)
				.add("distance", distance).add("type", type)
				.add("ligne", ligne).toString();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
