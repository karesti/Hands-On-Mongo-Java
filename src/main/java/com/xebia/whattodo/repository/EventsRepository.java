package com.xebia.whattodo.repository;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.inject.Inject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.xebia.whattodo.model.Event;
import com.xebia.whattodo.model.EventSession;
import com.xebia.whattodo.mongo.MapperMorphia;
import com.xebia.whattodo.mongo.MongoDB;

public class EventsRepository {

	private MongoDB mongoDB;
	private MapperMorphia mapper;

	@Inject
	public EventsRepository(MongoDB mongodb, MapperMorphia mapper) {
		this.mongoDB = mongodb;
		this.mapper = mapper;
	}

	public void dropDB() {
		mongoDB.getDatabase().dropDatabase();
	}

	protected DBCollection getCollection() {
		return null;
	}

	public void save(Event event) {
	}

	public void removeAllData() {
	}

	public long count() {
		return 0;
	}

	public Event findById(ObjectId id) {
		return null;
	}

	public void removeById(ObjectId id) {
	}

	public void addSessionToEvent(ObjectId eventId, EventSession eventSession) {
	}

	public void updateNameWithSessionDate(Date sessionDate, String nameUpdate) {
	}

	public long countWithName(String name) {
		return 0;
	}

	public void createIndexOnName() {
	}

	public List<DBObject> getIndexes() {
		return null;
	}

	public List<Event> findContainsWordOnNameAndOrderedByTownUpdatedLimited(
			String string, int i) {
		return null;
	}
}
