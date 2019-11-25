package com.jtweet.tweetmanagement.controller.api.v1;

import com.jtweet.tweetmanagement.exception.TweetNotFoundException;
import com.jtweet.tweetmanagement.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtweet.tweetmanagement.model.Tweet;
import com.jtweet.tweetmanagement.repository.TweetRepository;

@RestController
@RequestMapping("/v1/tweets")
public class TweetController {

	@Autowired
	private TweetService tweetServiceImpl;
	
	@GetMapping
	public ResponseEntity listTweets(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(this.tweetServiceImpl.getList(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getTweet(@PathVariable String id) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(tweetServiceImpl.getById(id));
		} catch (TweetNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tweet not found.");
		}
	}
	
	@PostMapping
	public ResponseEntity createTweet(@RequestBody Tweet tweet)
	{
		this.tweetServiceImpl.save(tweet);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tweet created successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteTweet(@PathVariable String id)
	{
		this.tweetServiceImpl.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Tweet deleted successfully");
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity tweetsListByUser(@PathVariable Integer userId, Pageable pageable)
	{
		return ResponseEntity.status(HttpStatus.OK).body(this.tweetServiceImpl.getListByUserId(userId, pageable));
	}

	@GetMapping("/hashTag/{hashTag}")
	public ResponseEntity tweetsListByHashTag(@PathVariable String hashTag, Pageable pageable)
	{
		return ResponseEntity.status(HttpStatus.OK).body(this.tweetServiceImpl.getListByHashTag(hashTag, pageable));
	}
}
