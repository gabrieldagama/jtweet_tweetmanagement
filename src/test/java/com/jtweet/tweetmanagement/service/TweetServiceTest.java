package com.jtweet.tweetmanagement.service;

import static org.mockito.Mockito.when;

import com.jtweet.tweetmanagement.exception.TweetNotFoundException;
import com.jtweet.tweetmanagement.model.Tweet;
import com.jtweet.tweetmanagement.repository.TweetRepository;;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        Assert.assertNotNull(tweet);
    }

    @Test(expected = TweetNotFoundException.class)
    public void testGetByIdException() throws TweetNotFoundException {
        String tweetId = "12345";
        Tweet tweet = tweetService.getById(tweetId);
        Assert.assertNotNull(tweet);
    }

}
