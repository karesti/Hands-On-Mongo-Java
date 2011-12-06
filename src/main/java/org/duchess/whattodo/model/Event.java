package org.duchess.whattodo.model;

import static com.google.common.base.Objects.equal;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.common.base.Objects;

public class Event {

	private ObjectId id;

	private String name;

	private String description;

	private List<EventSession> sessions;

	private Venue venue;

	private Date updated;

	public Event() {

	}

	public Event(String name, String description, List<EventSession> sessions,
			Venue venue) {
		super();
		this.name = name;
		this.description = description;
		this.sessions = sessions;
		this.venue = venue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Event) {
			Event other = (Event) obj;
			return equal(id, other.id) && equal(name, other.name)
					&& equal(description, other.description)
					&& equal(sessions, other.sessions)
					&& equal(venue, other.venue)
					&& equal(updated, other.updated);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects
				.hashCode(id, name, description, sessions, venue, updated);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", this.id)
				.add("name", this.name).add("description", this.description)
				.add("showDateTimeStart", this.sessions)
				.add("venue", this.venue).add("updated", this.updated)
				.toString();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<EventSession> getSessions() {
		return sessions;
	}

	public void setSessions(List<EventSession> sessions) {
		this.sessions = sessions;
	}
}
