package com.zipcode.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zipcode.model.video.Video;

import java.util.List;

public class VideosResponse {
    @JsonProperty("videos")
    private List<Video> mVideos;

    public List<Video> getVideos() {
        return mVideos;
    }

    public void setVideos(List<Video> videos) {
        mVideos = videos;
    }
}
