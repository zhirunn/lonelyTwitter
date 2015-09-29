package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import java.util.regex.Matcher;

/**
 * Created by wong5 on 9/29/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testHoldsStuff() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertSame(list.getMostRecentTweet(), tweet);
    }

    public void testHoldsManyThings() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertEquals(list.getCount(), 1);
        list.add(new NormalTweet("test"));
        assertEquals(list.getCount(), 2);
    }

    public void testRemovesStuff() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.removeTweet(tweet);
        assertSame(list.getMostRecentTweet(), tweet);
    }


    public void testHasStuff() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertSame(list.getMostRecentTweet(), tweet);
    }


    public void testHasDuplicate() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        try {
            list.add(tweet);
            assertNotSame(list.getMostRecentTweet(), tweet);
        } catch(IllegalArgumentException e){
        }
    }

}

