package com.jtweet.tweetmanagement.service;

import com.jtweet.tweetmanagement.exception.TweetNotFoundException;
import com.jtweet.tweetmanagement.model.Tweet;
import com.jtweet.tweetmanagement.repository.TweetRepository;;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.*;

public class TweetServiceTest {

    @InjectMocks
    private TweetServiceImpl tweetService;

    @Mock
    private TweetRepository tweetRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetById() throws TweetNotFoundException {
        String tweetId = "12345";
        when(tweetRepository.findById(tweetId)).thenReturn(java.util.Optional.of(new Tweet()));
        Tweet tweet = tweetService.getById(tweetId);
        verify(tweetRepository, times(2)).findById(tweetId);
        Assert.assertNotNull(tweet);
    }

    @Test(expected = TweetNotFoundException.class)
    public void testGetByIdException() throws TweetNotFoundException {
        Tweet tweet = tweetService.getById("12345");
        Assert.assertNotNull(tweet);
    }

    @Test
    public void testDeleteById() {
        String tweetId = "12345";
        tweetService.deleteById(tweetId);
        verify(tweetRepository, times(1)).deleteById(tweetId);
    }

    @Test
    public void testGetList() {
        Pageable pageable = Mockito.mock(Pageable.class);
        Page<Tweet> tweets = Mockito.mock(Page.class);
        when(tweetRepository.findAll(pageable)).thenReturn(tweets);
        Page<Tweet> returnedTweets = tweetService.getList(pageable);
        verify(tweetRepository, times(1)).findAll(pageable);
        Assert.assertEquals(tweets, returnedTweets);
    }

    @Test
    public void testGetListByUserId() {
        Pageable pageable = Mockito.mock(Pageable.class);
        Page<Tweet> tweets = Mockito.mock(Page.class);
        Integer userId = 123;
        when(tweetRepository.findByUserId(userId, pageable)).thenReturn(tweets);
        Page<Tweet> returnedTweets = tweetService.getListByUserId(userId, pageable);
        verify(tweetRepository, times(1)).findByUserId(userId, pageable);
        Assert.assertEquals(tweets, returnedTweets);
    }

    @Test
    public void testGetListByHashTag() {
        Pageable pageable = Mockito.mock(Pageable.class);
        Page<Tweet> tweets = Mockito.mock(Page.class);
        String hashTag = "#test";
        when(tweetRepository.findByHashTags(hashTag, pageable)).thenReturn(tweets);
        Page<Tweet> returnedTweets = tweetService.getListByHashTag(hashTag, pageable);
        verify(tweetRepository, times(1)).findByHashTags(hashTag, pageable);
        Assert.assertEquals(tweets, returnedTweets);
    }
}
