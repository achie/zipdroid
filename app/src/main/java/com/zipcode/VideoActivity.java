/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zipcode;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.zipcode.listing.VideoAdapter;
import com.zipcode.model.Listing;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple YouTube Android API demo application which shows how to use a
 * {@link YouTubeStandalonePlayer} intent to start a YouTube activity_video playback.
 */
public class VideoActivity extends BaseActivity {

    private static final int REQ_START_STANDALONE_PLAYER = 1;
    private static final int REQ_RESOLVE_SERVICE_MISSING = 2;

    private YouTubeThumbnailLoader mThumbnailLoader;
    private YouTubeThumbnailView mThumbnailView;

    private ListView mVideoList;
    private List<Listing> mListings;
    private int activeListing;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mThumbnailView = (YouTubeThumbnailView)findViewById(R.id.videoThumbnail);
        mThumbnailView.initialize(ZipdroidApplication.DEVELOPER_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                mThumbnailLoader = youTubeThumbnailLoader;
                mThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
                    }
                });
                if (mListings != null && !mListings.isEmpty()) {
                    mThumbnailLoader.setVideo(mListings.get(0).getVideo().getYoutubeId());
                }
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
            }
        });
        ViewGroup videoContainer = (ViewGroup)findViewById(R.id.videoContainer);
        videoContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int startTimeMillis = 0;
                boolean autoplay = true;
                boolean lightboxMode = false;

                Listing listing = mListings.get(activeListing);
                Activity activity = VideoActivity.this;
                Intent intent = YouTubeStandalonePlayer.createVideoIntent(
                        VideoActivity.this, ZipdroidApplication.DEVELOPER_KEY, listing.getVideo().getYoutubeId(), startTimeMillis, autoplay, lightboxMode);

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

        mApi.getVideos(new Callback<List<Listing> >() {
            @Override
            public void success(final List<Listing> listings, Response response) {
                mListings = listings;
                if (listings.size() > 0) {
                    Listing listing = listings.get(0);
                    listing.setSelected(true);
                    if (mThumbnailLoader != null) {
                        mThumbnailLoader.setVideo(listing.getVideo().getYoutubeId());
                    }
                }
                mVideoList = (ListView) findViewById(R.id.videoListView);
                mVideoList.setAdapter(new VideoAdapter(VideoActivity.this, R.layout.video_item, listings));
                mVideoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Listing listing = listings.get(position);
                        for (Listing l: listings) {
                            l.setSelected(false);
                        }
                        listing.setSelected(true);
                        ((VideoAdapter)parent.getAdapter()).notifyDataSetChanged();

                        if (mThumbnailLoader != null) {
                            mThumbnailLoader.setVideo(listing.getVideo().getYoutubeId());
                        }
                        activeListing = position;
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_START_STANDALONE_PLAYER && resultCode != RESULT_OK) {
            YouTubeInitializationResult errorReason =
                    YouTubeStandalonePlayer.getReturnedInitializationResult(data);
            if (errorReason.isUserRecoverableError()) {
                errorReason.getErrorDialog(this, 0).show();
            } else {
                String errorMessage =
                        String.format("There was an error initializing the YouTubePlayer (%1$s)", errorReason.toString());
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_video;
    }

    private boolean canResolveIntent(Intent intent) {
        List<ResolveInfo> resolveInfo = this.getPackageManager().queryIntentActivities(intent, 0);
        return resolveInfo != null && !resolveInfo.isEmpty();
    }
}
