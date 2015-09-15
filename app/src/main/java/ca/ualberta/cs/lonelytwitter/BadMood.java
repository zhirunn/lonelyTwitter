package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by wong5 on 9/15/15.
 */
public class BadMood extends CurrentMood {
    public BadMood(String mood) {
        super(mood);
    }

    public BadMood(Date dateMine, String mood) {
        super(dateMine, mood);
    }

    public String getText() {
        return "-- is sad." + super.getMood();
    }
}
