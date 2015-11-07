package com.zipcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Media {

    @JsonProperty("id")
    private String mId;

    @JsonProperty("url")
    private String mUrl;

    @JsonProperty("mimeType")
    private String mMimeType;

    @JsonProperty("index")
    private int mIndex;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getMimeType() {
        return mMimeType;
    }

    public void setMimeType(String mimeType) {
        mMimeType = mimeType;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setIndex(int index) {
        mIndex = index;
    }
}
