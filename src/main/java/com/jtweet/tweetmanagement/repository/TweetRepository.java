package com.jtweet.tweetmanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jtweet.tweetmanagement.model.Tweet;

public interface TweetRepository extends PagingAndSortingRepository<Tweet, String> {
	Page<Tweet> findByHashTags(String hashTag, Pageable pageable);
	Page<Tweet> findByUserId(Integer userId, Pageable pageable);
}
