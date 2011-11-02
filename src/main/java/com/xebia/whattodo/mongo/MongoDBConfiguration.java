package com.xebia.whattodo.mongo;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.mongodb.MongoURI;

public class MongoDBConfiguration {

	private MongoURI uri;

	private boolean slaveOk;

	@Inject
	public MongoDBConfiguration(@Named("com.whattodo.mongo.uri") String uri,
			@Named("com.whattodo.mongo.pool") int connectionsPerHost,
			@Named("com.whattodo.mongo.slaveOk") boolean slaveOk) {

		this.uri = new MongoURI(uri);
		if (this.uri.getDatabase() == null) {
			throw new IllegalArgumentException(
					"Bad configuration, database section in URI is mandatory.");
		}
		this.uri.getOptions().connectionsPerHost = connectionsPerHost;
		this.slaveOk = slaveOk;
	}

	public MongoURI getUri() {
		return this.uri;
	}

	public boolean isSlaveOk() {
		return slaveOk;
	}

	public String toString() {
		return Objects.toStringHelper(this)
				.add("host", this.uri.getOptions().connectionsPerHost)
				.add("slave", isSlaveOk()).add("uri", getUri()).toString();
	}

}
