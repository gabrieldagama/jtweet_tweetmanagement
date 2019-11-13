package com.jtweet.tweetmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtweet.tweetmanagement.model.Tweet;
import com.jtweet.tweetmanagement.repository.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	public List<Tweet> getList()
	{
		List<Tweet> tweetList = new ArrayList<Tweet>();
		this.tweetRepository.findAll().forEach(tweetList::add);
		return tweetList;
	}
	
	public List<Tweet> getTweetsByHashTag(String hashTag) {
		return this.tweetRepository.findByHashTags(hashTag);
	}

	public List<Tweet> getTweetsByUserId(Integer userId) {
		return this.tweetRepository.findByUserId(userId);
	}
}
