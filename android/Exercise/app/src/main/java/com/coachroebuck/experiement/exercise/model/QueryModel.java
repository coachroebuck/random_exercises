package com.coachroebuck.experiement.exercise.model;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class QueryModel {

    public int count;
    public String created;
    public String lang;
    public Results results;

    public class Results {
        ChannelModel channel;
    }
}
