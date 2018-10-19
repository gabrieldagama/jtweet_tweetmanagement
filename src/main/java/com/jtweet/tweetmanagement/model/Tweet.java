package com.jtweet.tweetmanagement.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tweets")
public class Tweet {
	
	@Id
	private String id;
	private Integer userId;
	private String tweet;
	private ArrayList<String> hashTags;
	
	protected Tweet() {
	}
	
	public Tweet(String id, Integer userId, String tweet, ArrayList<String> hashTags) {
		super();
		this.id = id;
		this.userId = userId;
		this.tweet = tweet;
		this.hashTags = hashTags;
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

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public ArrayList<String> getHashTags() {
		return hashTags;
	}

	public void setHashTags(ArrayList<String> hashTags) {
		this.hashTags = hashTags;
	}
	
	
}
