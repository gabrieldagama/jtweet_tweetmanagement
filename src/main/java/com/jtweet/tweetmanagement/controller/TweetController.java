package com.jtweet.tweetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtweet.tweetmanagement.api.ResponseBody;
import com.jtweet.tweetmanagement.api.ResponseBodyConverter;
import com.jtweet.tweetmanagement.model.Tweet;
import com.jtweet.tweetmanagement.repository.TweetRepository;
import com.jtweet.tweetmanagement.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@GetMapping
	public List<Tweet> listTweets() {
		return this.tweetService.getList();
	}
	
	@GetMapping("/{id}")
	public Tweet getTweet(@PathVariable String id)
	{
		return this.tweetRepository.findById(id).get();
	}
	
	@PostMapping
	public ResponseEntity createTweet(@RequestBody Tweet tweet)
	{
		this.tweetRepository.save(tweet);
		ResponseBody responseBody = new ResponseBody(true, "Tweet created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseBodyConverter.convert(responseBody));
	}

	@GetMapping("/user/{userId}")
	public List<Tweet> tweetsListByUser(@PathVariable Integer userId)
	{
		return this.tweetService.getTweetsByUserId(userId);
	}
	
	@GetMapping("/hashTag/{hashTag}")
	public List<Tweet> tweetsListByHashTag(@PathVariable String hashTag)
	{
		return this.tweetService.getTweetsByHashTag(hashTag);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteTweet(@PathVariable String id)
	{
		this.tweetRepository.deleteById(id);
		ResponseBody responseBody = new ResponseBody(true, "Tweet deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBodyConverter.convert(responseBody));	
    }
}
