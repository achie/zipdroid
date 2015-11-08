package com.zipcode.listing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.zipcode.BaseActivity;
import com.zipcode.R;
import com.zipcode.VideoActivity;
import com.zipcode.model.Listing;
import com.zipcode.model.response.ListingsResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListingsActivity extends BaseActivity implements ListingFragment.ListingsTransmitter {
    private List<Listing> mListings;
    private int mCurrentListingPosition;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_listings;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadListing();
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
                Log.v("$#######", "Retrofit error; " + error.getMessage());
            }
        });
    }

    private synchronized void loadListings(List<Listing> listings) {
        if (mListings == null) {
            mListings = new ArrayList<>();
        }
        mListings.clear();
        mListings.addAll(listings);
        mCurrentListingPosition = 0;

        if (findViewById(R.id.scrollView) != null) {
            ListingFragment fragment = ListingFragment.getInstance(mCurrentListingPosition);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.scrollView, fragment).commit();
        }
    }

    @Override
    public List<Listing> getListings() {
        return mListings;
    }

    @OnClick(R.id.btn_action_thumbs_up)
    void onThumbsUpClick() {
        //TODO send vote
        showNextListing();
    }

    @OnClick(R.id.btn_action_block)
    void onBlockClick() {
        //TODO send vote
        showNextListing();
    }

    private void showNextListing() {
        mCurrentListingPosition++;
        if (mListings.size() > mCurrentListingPosition) {
            ListingFragment newFragment = ListingFragment.getInstance(mCurrentListingPosition);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.scrollView, newFragment);
            transaction.commit();
        } else {
            startActivity(new Intent(this, VideoActivity.class));
            finish();
        }
    }

    @Override
    protected boolean showUpNavigation() {
        return false;
    }
}
