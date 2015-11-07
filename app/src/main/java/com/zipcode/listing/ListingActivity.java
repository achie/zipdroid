package com.zipcode.listing;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.squareup.picasso.Picasso;
import com.zipcode.BaseActivity;
import com.zipcode.R;
import com.zipcode.model.Listing;
import com.zipcode.model.response.ListingsResponse;

import java.util.List;

import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListingActivity extends BaseActivity implements OnMapReadyCallback {
    private MapFragment mMapFragment;

    @InjectView(R.id.listing_image)
    ImageView mListingImage;
    @InjectView(R.id.listing_image_subtitle)
    TextView mListingImageSubtitle;

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
                    loadImage(listingsResponse.getListings());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
                Log.v("$#######" , "Retrofit error; " + error.getMessage());
            }
        });
    }

    private void loadImage(List<Listing> listings) {
        if (listings != null && !listings.isEmpty()) {
            Picasso.with(this)
                    .load(listings.get(0).getMedia().get(0).getUrl())
                    .fit()
                    .centerCrop()
                    .into(mListingImage);
        }
    }
}
