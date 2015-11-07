package com.zipcode.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoMetadata {
    @JsonProperty("title")
    protected String mTitle;

    @JsonProperty("description")
    protected String mDescription;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
