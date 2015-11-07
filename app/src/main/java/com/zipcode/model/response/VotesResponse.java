package com.zipcode.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zipcode.model.Listing;

import java.util.List;

public class VotesResponse {
    @JsonProperty("votes")
    private List<Listing> mVotes;

    public List<Listing> getVotes() {
        return mVotes;
    }

    public void setVotes(List<Listing> votes) {
        mVotes = votes;
    }
}
