package com.zipcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zipcode.api.ZipdroidApi;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

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
    }
}
