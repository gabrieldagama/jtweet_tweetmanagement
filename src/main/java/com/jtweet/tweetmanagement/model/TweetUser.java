package com.jtweet.tweetmanagement.model;

public class TweetUser {

	private String id;
	private Integer userId;
	private String username;

	public TweetUser() {
	}

	public TweetUser(String id, Integer userId, String username) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
