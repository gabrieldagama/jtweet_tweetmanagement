package com.jtweet.tweetmanagement.model;

public class TweetUser {

	private String id;
	private String username;

	public TweetUser() {
	}

	public TweetUser(String id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
