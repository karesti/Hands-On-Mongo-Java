package org.mongoday.whattodo.mongo;

import com.google.code.morphia.Morphia;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mongodb.DBObject;

@Singleton
public class MapperMorphia {
	private Morphia morphia;

	@Inject
	public MapperMorphia() {
		this.morphia = new Morphia();
		this.morphia.mapPackage("org.duchess.whattodo.model");
	}

	public <T extends Object> T fromDBObject(Class<T> entityClass,
			DBObject dbObject) {
		return this.morphia.fromDBObject(entityClass, dbObject);
	}

	public <T extends Object> DBObject toDBObject(T modelObject) {
		DBObject dbObject = this.morphia.toDBObject(modelObject);
		dbObject.removeField("className");
		return dbObject;
	}
}
