package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wong5 on 9/15/15.
 */
public abstract class Tweet extends Object implements Tweetable{
    private String text;
    private Date date;
    private ArrayList<CurrentMood> currentMood;

    public String getText() {
        return text;
    }

    public void setText(String text){
        if(text.length() <= 140) {
            this.text = text;
        } else {
            throw new IllegalArgumentException("Tweets can't be that long.");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tweet(String tweet, Date date) {
        this.text = tweet;
        this.date = date;
    }

    public Tweet(String tweet) {
        this.text = tweet;
        this.date = new Date();
    }

    public abstract Boolean isImportant();
}
