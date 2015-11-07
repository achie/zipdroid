package com.zipcode.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zipcode.model.Listing;

import java.util.List;

public class ListingsResponse {
    @JsonProperty("success")
    private boolean mIsSuccess;

    @JsonProperty("status")
    private int mStatusCode;

    @JsonProperty("total")
    private long mTotal;

    @JsonProperty("bundle")
    private List<Listing> mListings;

    public boolean isSuccess() {
        return mIsSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        mIsSuccess = isSuccess;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(int statusCode) {
        mStatusCode = statusCode;
    }

    public long getTotal() {
        return mTotal;
    }

    public void setTotal(long total) {
        mTotal = total;
    }

    public List<Listing> getListings() {
        return mListings;
    }

    public void setListings(List<Listing> listings) {
        mListings = listings;
    }
}
