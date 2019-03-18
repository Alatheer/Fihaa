package com.Alatheer.alatheer.schoole.Services;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by elashry on 3/3/2018.
 */

public class ServicesApi {

    public static Retrofit CreateApiClient()
        {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                .build();
       /* Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://anwaralfyaha.anwaralfyaha.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
