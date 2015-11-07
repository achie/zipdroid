package com.zipcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

import com.zipcode.api.ZipdroidApi;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mTitleToolbar;
    protected TextView mTitle;

    @Inject
    public ZipdroidApi mApi;

    protected abstract int getLayoutResId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((ZipdroidApplication) getApplication()).getZipdroidComponent().inject(this);
        if (getLayoutResId() != 0) {
            setContentView(getLayoutResId());
            ButterKnife.inject(this);
        }

        initToolbar();
    }

    protected void initToolbar() {
        if (usesDefaultToolbar()) {
            mTitleToolbar = (Toolbar) findViewById(R.id.toolbar_activity_title);
            setSupportActionBar(mTitleToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(showUpNavigation());
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mTitle = (TextView) findViewById(R.id.toolbar_title);
            if (!TextUtils.isEmpty(getTitle())) {
                mTitle.setText(getTitle());
            }
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mTitle.setText(title);
    }

    @Override
    public void setTitle(int titleId) {
        super.setTitle(titleId);
        mTitle.setText(titleId);
    }

    protected boolean usesDefaultToolbar() {
        return true;
    }

    protected boolean showUpNavigation() {
        return true;
    }
}
