package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by wong5 on 9/29/15.
 */
public class TweetList {
    private Tweet mostRecentTweet;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        mostRecentTweet = tweet;
        tweets.add(tweet);
    }

    public Tweet getMostRecentTweet(){
        return mostRecentTweet;
    }

    public int getCount() {
        return tweets.size();
    }

    public void removeTweet(Tweet tweet){
        mostRecentTweet = tweet;
        tweets.remove(tweet);
    }




}
