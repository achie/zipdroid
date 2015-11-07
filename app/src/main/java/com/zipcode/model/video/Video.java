package com.zipcode.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {
    @JsonProperty("kind")
    private String mKind;

    @JsonProperty("etag")
    private String mTag;

    @JsonProperty("id")
    private String mId;

    @JsonProperty("snippet")
    private VideoSnippet mSnippet;

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public VideoSnippet getSnippet() {
        return mSnippet;
    }

    public void setSnippet(VideoSnippet snippet) {
        mSnippet = snippet;
    }
}
