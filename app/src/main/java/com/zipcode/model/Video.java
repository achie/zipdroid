package com.zipcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;

public class Video {
    @JsonProperty("id")
    private String mListingId;

    @JsonProperty("youtube_url")
    private String mUrl;

    @JsonProperty("upload_date")
    private Calendar mUploadDate;

    public String getListingId() {
        return mListingId;
    }

    public void setListingId(String listingId) {
        mListingId = listingId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Calendar getUploadDate() {
        return mUploadDate;
    }

    public void setUploadDate(Calendar uploadDate) {
        mUploadDate = uploadDate;
    }

    public String getYoutubeId() {
        return mUrl.substring(mUrl.indexOf("v=") + 2);
    }
}
