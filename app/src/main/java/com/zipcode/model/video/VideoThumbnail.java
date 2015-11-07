package com.zipcode.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoThumbnail {
    @JsonProperty("url")
    private String mUrl;

    @JsonProperty("width")
    private int mWidth;

    @JsonProperty("height")
    private int mHeight;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }
}
