package com.zipcode.listing;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zipcode.R;
import com.zipcode.model.Listing;
import com.zipcode.utils.ViewUtils;

import java.text.DecimalFormat;
import java.util.List;

public class VideoAdapter extends ArrayAdapter<Listing> {

    private static final int REQ_START_STANDALONE_PLAYER = 1;
    private static final int REQ_RESOLVE_SERVICE_MISSING = 2;

    Context mContext;
    int mLayoutResourceId;
    List<Listing> mListings;

    public VideoAdapter(Context context, int layoutResourceId, List<Listing> listings) {
        super(context, layoutResourceId, listings);
        mContext = context;
        mLayoutResourceId = layoutResourceId;
        mListings = listings;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ListingHolder holder;

        if(row == null) {
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new ListingHolder();
            holder.videoListImage = (ImageView)row.findViewById(R.id.videoListImage);
            holder.videoListPrice = (TextView)row.findViewById(R.id.videoListPrice);
            holder.videoDisplayName = (TextView)row.findViewById(R.id.videoDisplayName);
            holder.videoAddress = (TextView)row.findViewById(R.id.videoAddress);
            holder.videoDistance = (TextView)row.findViewById(R.id.videoDistance);
            holder.videoItemContainer = (ViewGroup)row.findViewById(R.id.videoItemContainer);

            row.setTag(holder);
        } else {
            holder = (ListingHolder)row.getTag();
        }

        final Listing listing = mListings.get(position);

        holder.videoListPrice.setText((new DecimalFormat("$#,###")).format(listing.getPrice()));
        holder.videoDisplayName.setText(listing.getDisplayName());
        holder.videoAddress.setText(listing.getAddress());
        holder.videoDistance.setText(String.format("%1$s miles from you!", (new DecimalFormat("#.#")).format(listing.getDistance())));

        if (listing.isSelected()) {
            holder.videoItemContainer.setBackgroundColor(ViewUtils.getColor(mContext, R.color.lightGray));
        } else {
            holder.videoItemContainer.setBackgroundColor(ViewUtils.getColor(mContext, android.R.color.white));
        }

        Picasso.with(mContext)
                .load(listing.getMedia().get(0).getUrl())
                .fit()
                .centerCrop()
                .into(holder.videoListImage);

        return row;
    }

    static class ListingHolder
    {
        ImageView videoListImage;
        TextView videoListPrice;
        TextView videoDisplayName;
        TextView videoAddress;
        TextView videoDistance;
        ViewGroup videoItemContainer;
    }
}
