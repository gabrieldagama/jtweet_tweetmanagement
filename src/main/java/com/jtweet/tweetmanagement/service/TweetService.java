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
	TweetRepository tweetRepository;
	
	public List<Tweet> getList()
	{
		List<Tweet> tweetList = new ArrayList<Tweet>();
		this.tweetRepository.findAll().forEach(tweetList::add);
		return tweetList;
	}
	
	public List<Tweet> getTweetsByHashTag(String hashTag)
	{
		List<Tweet> tweetList = new ArrayList<Tweet>();
		this.tweetRepository.findByHashTags(hashTag).forEach(tweetList::add);
		return tweetList;
	}
}
