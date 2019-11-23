package com.jtweet.tweetmanagement.service;

import com.jtweet.tweetmanagement.exception.TweetNotFoundException;
import com.jtweet.tweetmanagement.model.Tweet;
import com.jtweet.tweetmanagement.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TweetServiceImpl implements TweetService{

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Tweet getById(String id) throws TweetNotFoundException {
        if (!tweetRepository.findById(id).isPresent()) {
            throw new TweetNotFoundException("The tweet wasn't found.", id);
        }
        return tweetRepository.findById(id).get();
    }

    @Override
    public void deleteTweet(String id) {

    }

    @Override
    public Page<Tweet> getList(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Tweet> getListByUserId(Integer userId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Tweet> getListByHashTag(String hashTag, Pageable pageable) {
        return null;
    }
}