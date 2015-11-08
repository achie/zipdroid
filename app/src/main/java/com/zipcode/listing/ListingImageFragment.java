package com.zipcode.listing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.zipcode.R;

public class ListingImageFragment extends Fragment {

    private static final String ARG_URL = "image_url";
    private String mImageUrl;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle args = getArguments();
        if (args != null) {
            mImageUrl = args.getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ImageView imageView = (ImageView) inflater.inflate(
                R.layout.fragment_listing_image, container, false);

        Picasso.with(getContext())
                .load(mImageUrl)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                .fit()
                .centerCrop()
                .into(imageView);

        return imageView;
    }

    public static ListingImageFragment getInstance(String url) {
        ListingImageFragment fragment = new ListingImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }
}
