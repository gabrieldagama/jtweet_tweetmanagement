package com.jtweet.tweetmanagement.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tweets")
public class Tweet {
	
	@Id
	private String id;
	private TweetUser tweetUser;
	private String tweet;
	private ArrayList<String> hashTags;
	
	public Tweet() {
	}
	
	public Tweet(String id, TweetUser tweetUser, String tweet, ArrayList<String> hashTags) {
		super();
		this.id = id;
		this.tweetUser = tweetUser;
		this.tweet = tweet;
		this.hashTags = hashTags;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TweetUser getTweetUser() {
		return tweetUser;
	}

	public void setTweetUser(TweetUser tweetUser) {
		this.tweetUser = tweetUser;
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
