package com.example.pos_android.network.api_manager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCleint {

    private static Retrofit retrofit1 = null;


    public static Retrofit dataset(){

        return retrofit1;
    }

    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();



    private static OkHttpClient okClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(7, TimeUnit.SECONDS)
                .writeTimeout(7, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .readTimeout(7, TimeUnit.SECONDS)
                .build();
    }


    public static Retrofit getClientServerApi() {

        if (retrofit1 == null) {
            retrofit1 = new Retrofit.Builder()
                    //.baseUrl(BuildConfig.BASEURL_STAGING)
                    .client(okClient())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit1;
    }


}
