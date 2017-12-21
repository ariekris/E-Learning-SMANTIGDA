package com.v1.e_learningsmantigda.API;

import com.v1.e_learningsmantigda.Aspirasi.Aspirasi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Arie Krisnoanto on 11/16/2017.
 */

public interface ApiRequest {

    @FormUrlEncoded
    @POST("login.php")
    Call<Aspirasi> login (@Field("username") String username,
                          @Field("password") String password);

    @FormUrlEncoded
    @POST("/create_kritiksaran.php")
    Call<Aspirasi> call(@Field("txt_kritiksaran") String txt_kritiksaran);
}
