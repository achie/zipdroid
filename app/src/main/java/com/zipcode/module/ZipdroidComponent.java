package com.zipcode.module;

import com.zipcode.BaseActivity;
import com.zipcode.api.ZipdroidApi;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface ZipdroidComponent {

    void inject(BaseActivity baseActivity);

    ZipdroidApi getZipdroidApi();

}