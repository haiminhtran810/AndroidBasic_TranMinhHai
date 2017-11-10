package com.example.hcm_102_0006.android_retrofit_rxj.retrofit;


import com.example.hcm_102_0006.android_retrofit_rxj.model.GitHub;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by hcm-102-0006 on 10/11/2017.
 */

public interface GitHubService {
    String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{login}")
    Observable<GitHub> getUser(@Path("login") String login);

}
