package org.duchess.whattodo.config;

import org.duchess.whattodo.mongo.MapperMorphia;
import org.duchess.whattodo.mongo.MongoDB;
import org.duchess.whattodo.mongo.MongoDBConfiguration;
import org.duchess.whattodo.repository.EventsRepository;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class EventsRepositoryModule extends AbstractModule {

	@Override
	protected void configure() {
		bindConstant().annotatedWith(Names.named("basename")).to("WhatToDo");

		bindConstant().annotatedWith(Names.named("com.whattodo.mongo.uri")).to(
				"mongodb://");

		bindConstant().annotatedWith(Names.named("com.whattodo.mongo.pool"))
				.to("10");

		bindConstant().annotatedWith(Names.named("com.whattodo.mongo.slaveOk"))
				.to("");

		bind(MongoDB.class);
		bind(MapperMorphia.class);
		bind(MongoDBConfiguration.class);
		bind(EventsRepository.class);
	}
}
