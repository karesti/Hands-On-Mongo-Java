package com.xebia.whattodo.mongo;

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
		this.morphia.mapPackage("com.xebia.whattodo.model");
	}

	// TODO: EX2 Create Mapping
	public <T extends Object> T fromDBObject(Class<T> entityClass,
			DBObject dbObject) {
		return null;
	}

	// TODO: EX2 Create Mapping
	public <T extends Object> DBObject toDBObject(T modelObject) {
		return null;
	}

}
