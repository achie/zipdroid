package com.zipcode.listing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zipcode.R;
import com.zipcode.model.Listing;

import java.util.List;

public class ListingFragment extends Fragment {

    private static final String ARG_LISTING_POSITION = "listing_position";
    private int mListingPosition;
    private ListingsTransmitter mListingsTransmitter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle args = getArguments();
        if (args != null) {
            mListingPosition = args.getInt(ARG_LISTING_POSITION);
        }

        try {
            mListingsTransmitter = (ListingsTransmitter) getActivity();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(
                R.layout.fragment_listing, container, false);

        return layout;
    }

    public static ListingFragment getInstance(int listingPosition) {
        ListingFragment fragment = new ListingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LISTING_POSITION, listingPosition);
        fragment.setArguments(args);
        return fragment;
    }

    public interface ListingsTransmitter {
        List<Listing> getListings();
    }
}
