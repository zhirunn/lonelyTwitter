package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by wong5 on 9/15/15.
 */
public abstract class CurrentMood {
    private Date dateMine;
    private String mood;

    public CurrentMood(Date dateMine, String mood) {
        this.dateMine = dateMine;
        this.mood = mood;
    }

    public void setText(String mood){
        if(mood.length() <= 50) {
            this.mood = mood;
        } else {
            throw new IllegalArgumentException("Can't set moods that long.");
        }
    }

    public Date getDateMine() {
        return dateMine;
    }

    public void setDateMine(Date dateMine) {
        this.dateMine = dateMine;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public CurrentMood(String mood) {
        this.mood = mood;
        this.dateMine = new Date();
    }
}
