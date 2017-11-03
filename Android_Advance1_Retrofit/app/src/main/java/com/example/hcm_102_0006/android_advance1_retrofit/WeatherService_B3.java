package com.example.hcm_102_0006.android_advance1_retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hcm-102-0006 on 03/11/2017.
 */

public class WeatherService_B3 {
    //https://api.darksky.net/forecast/0123456789abcdef9876543210fedcba/42.3601,-71.0589
    private final static String BASE_URL = "https://api.darksky.net";
    private static Retrofit retrofit = null;
    // Register Retrofit with BASE_URL
    private static Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(BASE_URL)
                    // parse to JSON/XML
                    .addConverterFactory(GsonConverterFactory.create());
    private static HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okHttpClientBuilder =
            new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor);
    private static  OkHttpClient okHttpClient = okHttpClientBuilder.build();

    // If you use token
    /*
    Resolve : 2
    1 - Auth với anotations (@Header)
    @GET("user")
    Call<UserDetails> getUserDetails(@Header("token") String token)
    2 - Auth với Okhttp interceptors
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();

                    Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                                    Credentials.basic("aUsername", "aPassword"));

                    Request newRequest = builder.build();
                    return chain.proceed(newRequest);
            }
    }).build();

    Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("http://jsonapi.org/examples/")
    .client(okHttpClient)
    .build();
    */
    public static <T> T createService(Class<T> serviceClass) {
        retrofit = builder.client(okHttpClient).build();
        return retrofit.create(serviceClass);
    }


}
