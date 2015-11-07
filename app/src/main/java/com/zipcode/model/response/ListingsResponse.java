package com.zipcode.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zipcode.model.Listing;

import java.util.List;

public class ListingsResponse {

    @JsonProperty("listings")
    private List<Listing> mListings;

    public List<Listing> getListings() {
        return mListings;
    }

    public void setListings(List<Listing> listings) {
        mListings = listings;
    }
}
