package com.xebia.whattodo.model;

import static com.google.common.base.Objects.equal;

import com.google.common.base.Objects;

public class Venue {

	private String name = "";

	private String way = "";

	private String pCode = "";

	private String town = "";

	private Transports transports;

	public Venue() {
		super();
		this.transports = new Transports();
	}

	public Venue(String name, String way, String pCode, String town) {
		this();
		this.name = name;
		this.way = way;
		this.pCode = pCode;
		this.town = town;
	}

	public Venue(String name, String way, String pCode, String town,
			Transports transports) {
		this(name, way, pCode, town);
		this.transports = transports;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Venue) {
			Venue other = (Venue) obj;
			return equal(name, other.name) && equal(way, other.way)
					&& equal(pCode, other.pCode) && equal(town, other.town)
					&& equal(transports, other.transports);

		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, way, pCode, town, transports);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("name", this.name)
				.add("way1", this.way).add("town", this.town)
				.add("pCode", this.pCode).add("transports", this.transports)
				.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Transports getTransports() {
		return transports;
	}

	public void setTransports(Transports transports) {
		this.transports = transports;
	}

}