package com.zipcode;

import android.app.Application;

import com.zipcode.module.ApiModule;
import com.zipcode.module.DaggerZipdroidComponent;
import com.zipcode.module.ZipdroidComponent;

public class ZipdroidApplication extends Application {

    private ZipdroidComponent mZipdroidComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mZipdroidComponent = DaggerZipdroidComponent.builder()
                .apiModule(new ApiModule(this))
                .build();
    }

    public ZipdroidComponent getZipdroidComponent() {
        return mZipdroidComponent;
    }
}
