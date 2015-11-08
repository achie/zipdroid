package com.zipcode.listing;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.zipcode.BaseActivity;
import com.zipcode.R;
import com.zipcode.model.Listing;
import com.zipcode.model.response.ListingsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListingsActivity extends BaseActivity implements ListingFragment.ListingsTransmitter {

    private ListingImagePagingAdapter mImagesAdapter;
    private List<Listing> mListings;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_listings;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadListing();

        if (findViewById(R.id.scrollView) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ListingFragment fragment = ListingFragment.getInstance(0);


            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.scrollView, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void loadListing() {
        mApi.getListings(new Callback<ListingsResponse>() {
            @Override
            public void success(ListingsResponse listingsResponse, Response response) {
                if (listingsResponse != null) {
                    loadListings(listingsResponse.getListings());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
                Log.v("$#######" , "Retrofit error; " + error.getMessage());
            }
        });
    }

    private synchronized void loadListings(List<Listing> listings) {
        if (mListings == null) {
            mListings = new ArrayList<>();
        }
        mListings.clear();
        mListings.addAll(listings);
    }

    @Override
    public List<Listing> getListings() {
        return mListings;
    }
}
