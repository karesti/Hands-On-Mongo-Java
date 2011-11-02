package com.xebia.whattodo.mongo;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * Note Guice : Only one constructor can be annotated with @Inject
 * 
 * @author karesti
 * 
 */
@Singleton
public class MongoDB {

	private Mongo mongo;

	private final String baseName;

	@Inject
	public MongoDB(@Named("basename") String baseName) {

		// TODO EX 1 Connect
		// HERE

		this.baseName = baseName;
	}

	// TODO PART 3 Constructor for replica set
	// @Inject
	public MongoDB(MongoDBConfiguration mongoDBConfiguration) {
		this.baseName = "";

		// HERE

	}

	public Mongo getMongo() {
		return mongo;
	}

	public DB getDatabase() {
		return mongo.getDB(baseName);
	}
}
