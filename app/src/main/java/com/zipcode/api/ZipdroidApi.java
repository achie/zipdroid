package com.zipcode.api;

import com.zipcode.model.Listing;
import com.zipcode.model.response.ListingsResponse;
import com.zipcode.model.response.VideosResponse;
import com.zipcode.model.response.VotesResponse;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ZipdroidApi {

    @GET("/listing")
    void getListings(Callback<ListingsResponse> callback);

    @GET("/listing/{listingId}")
    void getListing(Callback<Listing> callback);

    @GET("/vote")
    void getVotes(Callback<VotesResponse> callback);

    @GET("/video")
    void getVideos(Callback<VideosResponse> callback);

    @POST("/vote/{voteId}")
    void postVote(
        @Field("vote") boolean vote,
        Callback<Object> callback
    );
}
