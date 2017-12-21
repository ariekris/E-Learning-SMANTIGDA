package com.v1.e_learningsmantigda.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arie Krisnoanto on 11/21/2017.
 */

public class RetroClient {

    private static final String base_url = "http://192.168.100.12/elearning_smantigda/login/";
    private static Retrofit retro = null;

    private static Retrofit getClient() {
        if (retro == null) {
            retro = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retro;
    }
    public static ApiRequest getRequetService(){
        return getClient().create(ApiRequest.class);
    }
}
