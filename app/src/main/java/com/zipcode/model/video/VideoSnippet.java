package com.zipcode.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.List;

public class VideoSnippet extends VideoMetadata {
    @JsonProperty("publishedAt")
    private Calendar mPublishedAt;

    @JsonProperty("channelId")
    private String mChannelId;

    @JsonProperty("channelTitle")
    private String mChannelTitle;

    @JsonProperty("tags")
    private List<String> mTags;

    @JsonProperty("categoryId")
    private String mCategoryId;

    @JsonProperty("liveBroadcastContent")
    private String mLiveBroadcast;

    @JsonProperty("localized")
    private VideoMetadata mLocalized;

    @JsonProperty("thumbnails")
    private VideoThumbnails mThumbnails;

    public Calendar getPublishedAt() {
        return mPublishedAt;
    }

    public void setPublishedAt(Calendar publishedAt) {
        mPublishedAt = publishedAt;
    }

    public String getChannelId() {
        return mChannelId;
    }

    public void setChannelId(String channelId) {
        mChannelId = channelId;
    }

    public String getChannelTitle() {
        return mChannelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        mChannelTitle = channelTitle;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> tags) {
        mTags = tags;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getLiveBroadcast() {
        return mLiveBroadcast;
    }

    public void setLiveBroadcast(String liveBroadcast) {
        mLiveBroadcast = liveBroadcast;
    }

    public VideoMetadata getLocalized() {
        return mLocalized;
    }

    public void setLocalized(VideoMetadata localized) {
        mLocalized = localized;
    }

    public VideoThumbnails getThumbnails() {
        return mThumbnails;
    }

    public void setThumbnails(VideoThumbnails thumbnails) {
        mThumbnails = thumbnails;
    }
}
