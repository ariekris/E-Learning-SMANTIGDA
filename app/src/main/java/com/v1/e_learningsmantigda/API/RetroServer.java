package com.v1.e_learningsmantigda.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arie Krisnoanto on 11/16/2017.
 */

public class RetroServer {
    private static final String base_url = "http://192.168.100.12/elearning_smantigda/";

    private static Retrofit retrofit;

    public  static Retrofit getClient() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
