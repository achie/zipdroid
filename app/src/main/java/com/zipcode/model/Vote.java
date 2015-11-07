package com.zipcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;

public class Vote {
    @JsonProperty("id")
    private String mId;

    @JsonProperty("vote")
    private boolean mVote;

    @JsonProperty("timestamp")
    private Calendar mTimestamp;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public boolean isVote() {
        return mVote;
    }

    public void setVote(boolean vote) {
        mVote = vote;
    }

    public Calendar getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        mTimestamp = timestamp;
    }
}
