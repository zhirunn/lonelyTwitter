package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by wong5 on 9/15/15.
 */
public class GoodMood extends CurrentMood {
    public GoodMood(String mood) {
        super(mood);
    }

    public GoodMood(Date dateMine, String mood) {
        super(dateMine, mood);
    }

    public String getText() {
        return "-- is happy." + super.getMood();
    }
}
