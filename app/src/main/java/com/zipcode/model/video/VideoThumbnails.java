package com.zipcode.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoThumbnails {
    @JsonProperty("default")
    private VideoThumbnail mDefault;

    @JsonProperty("standard")
    private VideoThumbnail mStandard;

    @JsonProperty("medium")
    private VideoThumbnail mMedium;

    @JsonProperty("high")
    private VideoThumbnail mHigh;

    @JsonProperty("maxres")
    private VideoThumbnail mMaxRes;

    public VideoThumbnail getDefault() {
        return mDefault;
    }

    public void setDefault(VideoThumbnail aDefault) {
        mDefault = aDefault;
    }

    public VideoThumbnail getStandard() {
        return mStandard;
    }

    public void setStandard(VideoThumbnail standard) {
        mStandard = standard;
    }

    public VideoThumbnail getMedium() {
        return mMedium;
    }

    public void setMedium(VideoThumbnail medium) {
        mMedium = medium;
    }

    public VideoThumbnail getHigh() {
        return mHigh;
    }

    public void setHigh(VideoThumbnail high) {
        mHigh = high;
    }

    public VideoThumbnail getMaxRes() {
        return mMaxRes;
    }

    public void setMaxRes(VideoThumbnail maxRes) {
        mMaxRes = maxRes;
    }
}
