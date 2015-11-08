package com.zipcode.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zipcode.BaseActivity;
import com.zipcode.R;
import com.zipcode.listing.ListingsActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @InjectView(R.id.background_image)
    ImageView mBackgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String imageUrl = "http://www.vangviet.com/wp-content/uploads/beautiful-delightful-white-house-designs.jpg";

        Picasso.with(this)
                .load(imageUrl)
                .fit()
                .centerCrop()
                .into(mBackgroundImage);
    }

    @OnClick (R.id.submit)
    void onSubmitCLick() {
        startActivity(new Intent(LoginActivity.this, ListingsActivity.class));
        finish();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean showUpNavigation() {
        return false;
    }
}
