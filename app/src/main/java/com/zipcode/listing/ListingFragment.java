package com.zipcode.listing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;
import com.zipcode.R;
import com.zipcode.model.Listing;
import com.zipcode.model.Media;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ListingFragment extends Fragment {

    private static final String ARG_LISTING_POSITION = "listing_position";
    private int mListingPosition;
    private ListingsTransmitter mListingsTransmitter;
    private ListingImagePagingAdapter mImagesAdapter;

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

        ViewPager listingImagesPager = (ViewPager) layout.findViewById(R.id.listing_images_pager);
        CirclePageIndicator pageIndicator = (CirclePageIndicator)
                layout.findViewById(R.id.image_position_indicator);
        mImagesAdapter = new ListingImagePagingAdapter(getActivity().getSupportFragmentManager(), new ArrayList<Media>());
        listingImagesPager.setAdapter(mImagesAdapter);
        pageIndicator.setViewPager(listingImagesPager);

        TextView priceTextView = (TextView) layout.findViewById(R.id.listing_image_subtitle);
        TextView metaTextView = (TextView) layout.findViewById(R.id.listing_image_footage);
        TextView displayNameTextView = (TextView) layout.findViewById(R.id.displayNameText);
        TextView addressTextView = (TextView) layout.findViewById(R.id.addressText);

        if (mListingsTransmitter != null) {
            List<Listing> listings = mListingsTransmitter.getListings();
            if (listings != null && listings.size() > mListingPosition) {
                Listing listing = listings.get(mListingPosition);
                if (listing != null) {
                    if (listing.getMedia() != null) {
                        mImagesAdapter.setMedia(listing.getMedia());
                        pageIndicator.notifyDataSetChanged();
                    }

                    priceTextView.setText((new DecimalFormat("$#,###")).format(listing.getPrice()));

                    StringBuilder builder = new StringBuilder();
                    if (listing.getBedrooms() > 0) {
                        builder.append(listing.getBedrooms());
                        builder.append(" bed");
                    }

                    if (listing.getBaths() > 0) {
                        if (builder.length() > 0) {
                            builder.append(", ");
                        }
                        builder.append((new DecimalFormat("0.# bath")).format(listing.getBaths()));
                    }

                    if (listing.getSquareFootage() > 0) {
                        if (builder.length() > 0) {
                            builder.append(" | ");
                        }
                        builder.append((new DecimalFormat("#,### sqft")).format(listing.getSquareFootage()));
                    }
                    metaTextView.setText(builder.toString());

                    if (!TextUtils.isEmpty(listing.getDisplayName())) {
                        displayNameTextView.setVisibility(View.VISIBLE);
                        displayNameTextView.setText(listing.getDisplayName());
                    } else {
                        displayNameTextView.setVisibility(View.GONE);
                    }

                    if (!TextUtils.isEmpty(listing.getAddress())) {
                        addressTextView.setVisibility(View.VISIBLE);
                        addressTextView.setText(listing.getAddress());
                    } else {
                        addressTextView.setVisibility(View.GONE);
                    }
                }
            }
        }

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
