package com.jtweet.tweetmanagement.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.jtweet.tweetmanagement.model.Tweet;

public interface TweetRepository extends CrudRepository<Tweet, String> {
	List<Tweet> findByHashTags(String hashTag);
	List<Tweet> findByUserId(Integer userId);
}
