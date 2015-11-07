package com.zipcode.api;

import com.zipcode.model.response.ListingsResponse;

import retrofit.Callback;
import retrofit.http.GET;

public interface ZipdroidApi {

    @GET("listing")
    void getListings(Callback<ListingsResponse> callback);

}
