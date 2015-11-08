package com.zipcode.listing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.squareup.picasso.Picasso;
import com.zipcode.R;
import com.zipcode.ZipdroidApplication;
import com.zipcode.model.Listing;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

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

            row.setTag(holder);
        } else {
            holder = (ListingHolder)row.getTag();
        }

        final Listing listing = mListings.get(position);

        Random rand = new Random();
        double distance = ((double)rand.nextInt(30))/10.0;
        holder.videoListPrice.setText((new DecimalFormat("$#,###")).format(listing.getPrice()));
        holder.videoDisplayName.setText(listing.getDisplayName());
        holder.videoAddress.setText(listing.getAddress());
        holder.videoDistance.setText(String.format("%1$s miles from you!", (new DecimalFormat("#.#")).format(distance)));

        Picasso.with(mContext)
                .load(listing.getMedia().get(0).getUrl())
                .fit()
                .centerCrop()
                .into(holder.videoListImage);
        row.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int startTimeMillis = 0;
                boolean autoplay = true;
                boolean lightboxMode = false;

                Activity activity = (Activity) mContext;
                Intent intent = YouTubeStandalonePlayer.createVideoIntent(
                        activity, ZipdroidApplication.DEVELOPER_KEY, listing.getVideo().getYoutubeId(), startTimeMillis, autoplay, lightboxMode);

                if (intent != null) {
                    if (canResolveIntent(intent)) {
                        activity.startActivityForResult(intent, REQ_START_STANDALONE_PLAYER);
                    } else {
                        // Could not resolve the intent - must need to install or update the YouTube API service.
                        YouTubeInitializationResult.SERVICE_MISSING
                                .getErrorDialog(activity, REQ_RESOLVE_SERVICE_MISSING).show();
                    }
                }
            }
        });

        return row;
    }

    static class ListingHolder
    {
        ImageView videoListImage;
        TextView videoListPrice;
        TextView videoDisplayName;
        TextView videoAddress;
        TextView videoDistance;
    }

    private boolean canResolveIntent(Intent intent) {
        List<ResolveInfo> resolveInfo = mContext.getPackageManager().queryIntentActivities(intent, 0);
        return resolveInfo != null && !resolveInfo.isEmpty();
    }
}
