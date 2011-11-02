package com.xebia.whattodo.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.xebia.whattodo.mongo.MapperMorphia;
import com.xebia.whattodo.mongo.MongoDB;
import com.xebia.whattodo.mongo.MongoDBConfiguration;
import com.xebia.whattodo.repository.EventsRepository;

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
