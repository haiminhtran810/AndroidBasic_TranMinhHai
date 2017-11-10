package com.example.hcm_102_0006.android_retrofit_rxj.retrofit;

import retrofit.RestAdapter;

/**
 * Created by hcm-102-0006 on 10/11/2017.
 */

public class GitHubFactory {
    static <T> T createRetrofitService(final Class<T> cla, final String endpoint){
        final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(endpoint).build();
        T service = restAdapter.create(cla);
        return service;
    }
}
