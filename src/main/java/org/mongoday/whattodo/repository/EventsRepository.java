package org.mongoday.whattodo.repository;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongoday.whattodo.model.Event;
import org.mongoday.whattodo.model.EventSession;
import org.mongoday.whattodo.mongo.MapperMorphia;
import org.mongoday.whattodo.mongo.MongoDB;

import com.google.inject.Inject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

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
		throw new UnsupportedOperationException("You must implement GET COLLECTION method on repository");
	}

	public void save(Event event) {
		// Use morphia - this.mapper - here to help you with the mapping ! 
		throw new UnsupportedOperationException("You must implement SAVE method on repository");
	}

	public void removeAllData() {
		throw new UnsupportedOperationException("You must implement REMOVE ALL DATA method on repository");
	}

	public long count() {
		throw new UnsupportedOperationException("You must implement COUNT method on repository");
	}

	public Event findById(ObjectId id) {
		throw new UnsupportedOperationException("You must implement FIND BY ID method on repository");
	}

	public void removeById(ObjectId id) {
		throw new UnsupportedOperationException("You must implement REMOVE BY ID method on repository");
	}

	public void addSessionToEvent(ObjectId eventId, EventSession eventSession) {
		throw new UnsupportedOperationException("You must implement ADD SESSION TO EVENT method on repository");

	}

	public void updateNameWithSessionDate(Date sessionDate, String nameUpdate) {
		throw new UnsupportedOperationException("You must implement UPDATE NAME WITH SESSION DATE method on repository");
	}

	public long countWithName(String name) {
		throw new UnsupportedOperationException("You must implement COUNT WITH NAME method on repository");
	}

	public void createIndexOnName() {
		throw new UnsupportedOperationException("You must implement CREATE INDEX method on repository");
	}

	public List<DBObject> getIndexes() {
		throw new UnsupportedOperationException("You must implement GET INDEXES method on repository");
	}

	public List<Event> findContainsWordOnNameAndOrderedByTownLimited(String word) {
		throw new UnsupportedOperationException("You must implement FIND METHOD method on repository");
	}
}
