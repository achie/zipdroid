package com.zipcode;

import android.app.Application;

import com.zipcode.module.ApiModule;
import com.zipcode.module.DaggerZipdroidComponent;
import com.zipcode.module.ZipdroidComponent;

public class ZipdroidApplication extends Application {

    private ZipdroidComponent mZipdroidComponent;
    public static final String DEVELOPER_KEY = "AIzaSyDRGj6kVrU-OZ1IHg1Nc4TbWC-91RjRafo";

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
