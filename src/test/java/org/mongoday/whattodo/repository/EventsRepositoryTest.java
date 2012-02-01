package org.mongoday.whattodo.repository;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mongoday.whattodo.config.EventsRepositoryModule;
import org.mongoday.whattodo.model.Event;
import org.mongoday.whattodo.model.EventSession;
import org.mongoday.whattodo.model.Venue;
import org.mongoday.whattodo.mongo.MongoDB;
import org.mongoday.whattodo.repository.EventsRepository;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class EventsRepositoryTest {

	private static Injector injector;

	@BeforeClass
	public static void configure() {
		injector = Guice.createInjector(new EventsRepositoryModule());

	}

	// TODO: Part 2 - EX1 : Create connection
	@Test
	@Ignore
	public void should_be_able_to_connect_to_mongo() {

		MongoDB mongo = injector.getInstance(MongoDB.class);

		assertThat(mongo.getDatabase()).as("DB can't be null").isNotNull();
		assertThat(mongo.getDatabase().getName()).as(
				"DB name is configured on Events Repository Module").isEqualTo(
				"WhatToDo");
		assertThat(mongo.getDatabase().getCollectionNames()).as("has collections").isNotEmpty();
	}

	// TODO: Part 2 - EX2 : Create, Find and Remove By ID
	@Test
	@Ignore
	public void should_be_able_to_create_find_and_remove_one_event_by_id() {

		EventsRepository repository = injector
				.getInstance(EventsRepository.class);

		List<EventSession> sessions = Lists
				.newArrayList(new EventSession("2011-12-30", "12:00"),
						new EventSession("2012-01-06", "12:00"));
		Venue venue = new Venue("Palais Royal", "22 Rue de David Feta",
				"75001", "Paris");
		Event event = new Event("Danse OukaOuka", "Everybody dancing UkaUka",
				sessions, venue);

		long countEventsBeforeInsert = repository.count();

		// Create
		repository.save(event);

		assertThat(event.getId()).as("Event Id can't be null after safe")
				.isNotNull();
		assertThat(repository.count()).as("Count returns +1").isEqualTo(
				countEventsBeforeInsert + 1);

		// Find By Id
		Event eventReaded = repository.findById(event.getId());
		assertThat(eventReaded).as("Event readed can't be null").isNotNull();
		assertThat(eventReaded).as(
				"Event readed by Id must be the same as created one")
				.isEqualTo(event);

		// Remove By Id
		repository.removeById(event.getId());
		assertThat(event.getId()).isNotNull();
		assertThat(repository.count()).as(
				"After Delete Count returns countEventsBeforeInsert value")
				.isEqualTo(countEventsBeforeInsert);

	}
	
	// TODO: Part 2 - EX3 : Search
	@Test
	@Ignore
	public void should_search_with_multiple_criteres() {
		EventsRepository repository = injector
				.getInstance(EventsRepository.class);

		List<Event> events = repository
				.findContainsWordOnNameAndOrderedByTownLimited("concert");

		assertThat(events).isNotNull();
		assertThat(events).isNotEmpty();
		assertThat(events.get(0).getVenue().getTown()).isEqualTo("Aix-en-Provence");
	}


	// TODO: Part 2 - EX4 : Update One, Update More
	@Test
	@Ignore
	public void should_be_able_to_add_another_session() {

		EventsRepository repository = injector
				.getInstance(EventsRepository.class);

		EventSession eventSession = new EventSession("2012-03-10", "12:00");

		EventSession eventSession2 = new EventSession("2012-03-10", "12:00");

		assertThat(eventSession).isEqualTo(eventSession2);
		// Read before
		Event eventBefore = repository.findById(new ObjectId(
				"4e9d4420f7dbcc6b4f9711b5"));

		// Add session
		repository.addSessionToEvent(new ObjectId("4e9d4420f7dbcc6b4f9711b5"),
				eventSession);

		// Read after
		Event eventAfter = repository.findById(new ObjectId(
				"4e9d4420f7dbcc6b4f9711b5"));

		assertThat(eventAfter.getSessions()).hasSize(
				eventBefore.getSessions().size() + 1);
	}

	@Test
	@Ignore
	public void should_be_able_to_do_multiple_updates() {

		EventsRepository repository = injector
				.getInstance(EventsRepository.class);

		EventSession eventSession = new EventSession("2011-11-03", "");

		repository.updateNameWithSessionDate(
				eventSession.getShowDateTimeStart(), "multipleUpdate");

		long countWithName = repository.countWithName("multipleUpdate");

		assertThat(countWithName).isEqualTo(99);
	}

	// TODO: Part 2 - EX5 : Create index on name
	@Test
	@Ignore
	public void should_create_index_on_name() {

		EventsRepository repository = injector
				.getInstance(EventsRepository.class);

		repository.createIndexOnName();

		assertThat(repository.getIndexes()).hasSize(2);
	}
}
