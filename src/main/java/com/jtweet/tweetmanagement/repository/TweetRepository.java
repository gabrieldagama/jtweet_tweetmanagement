package com.jtweet.tweetmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jtweet.tweetmanagement.model.Tweet;

public interface TweetRepository extends CrudRepository<Tweet, String> {
	
	public List<Tweet> findByHashTags(String hashTag);

}
