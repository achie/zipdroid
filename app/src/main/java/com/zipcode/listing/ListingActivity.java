package com.zipcode.listing;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.viewpagerindicator.CirclePageIndicator;
import com.zipcode.BaseActivity;
import com.zipcode.R;
import com.zipcode.model.Listing;
import com.zipcode.model.Media;
import com.zipcode.model.response.ListingsResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListingActivity extends BaseActivity implements OnMapReadyCallback {
    private MapFragment mMapFragment;

//    @InjectView(R.id.listing_image_subtitle)
//    TextView mListingImageSubtitle;
    @InjectView(R.id.listing_images_pager)
    ViewPager mListingImagesPager;
    @InjectView(R.id.image_position_indicator)
    CirclePageIndicator mPageIndicator;

    private ListingImagePagingAdapter mImagesAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_listing;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);

        mImagesAdapter = new ListingImagePagingAdapter(getSupportFragmentManager(), new ArrayList<Media>());
        mListingImagesPager.setAdapter(mImagesAdapter);
        mPageIndicator.setViewPager(mListingImagesPager);
        loadListing();
    }

    @Override
    public void onMapReady(GoogleMap map) {
    }

    void loadListing() {
        mApi.getListings(new Callback<ListingsResponse>() {
            @Override
            public void success(ListingsResponse listingsResponse, Response response) {
                if (listingsResponse != null) {
                    loadImages(listingsResponse.getListings());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
                Log.v("$#######" , "Retrofit error; " + error.getMessage());
            }
        });
    }

    private void loadImages(List<Listing> listings) {
        if (listings != null && !listings.isEmpty()) {
            mImagesAdapter.setMedia(listings.get(0).getMedia());
            mPageIndicator.notifyDataSetChanged();
        }
    }
}
