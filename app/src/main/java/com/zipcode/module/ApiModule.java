package com.zipcode.module;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import com.zipcode.api.ZipdroidApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;

@Module
public class ApiModule {
    private Context mContext;

    public ApiModule(Context context) {
        mContext = context.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mContext;
    }

    @Provides
    Client provideClient() {
        OkHttpClient client = new OkHttpClient();
        return new OkClient(client);
    }

    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint("https://zipcode-retsly.herokuapp.com");
    }

    @Provides
    @Singleton
    RequestInterceptor provideRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
            }
        };
    }

    @Provides
    @Singleton
    public RestAdapter provideRestAdapter(Endpoint endpoint, Client client, RequestInterceptor interceptor){
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(client)
                .setRequestInterceptor(interceptor)
                .build();
    }

    @Provides
    ZipdroidApi provideZipdroidApi(RestAdapter restAdapter) {
        return restAdapter.create(ZipdroidApi.class);
    }
}
