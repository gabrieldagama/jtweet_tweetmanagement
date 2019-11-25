package com.jtweet.tweetmanagement.service;

import com.jtweet.tweetmanagement.exception.TweetNotFoundException;
import com.jtweet.tweetmanagement.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TweetService {
    public Tweet save(Tweet tweet);
    public Tweet getById(String id) throws TweetNotFoundException;
    public void deleteById(String id);
    public Page<Tweet> getList(Pageable pageable);
    public Page<Tweet> getListByUserId(Integer userId, Pageable pageable);
    public Page<Tweet> getListByHashTag(String hashTag, Pageable pageable);
}
