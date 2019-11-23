package com.jtweet.tweetmanagement.exception;

public class TweetNotFoundException extends Exception {

    private String id;

    public TweetNotFoundException(String id) {
        super();
        this.id = id;
    }

    public TweetNotFoundException(String message, Throwable cause, String id) {
        super(message, cause);
        this.id = id;
    }

    public TweetNotFoundException(String message, String id) {
        super(message);
        this.id = id;
    }

    public TweetNotFoundException(Throwable cause, String id) {
        super(cause);
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
}
