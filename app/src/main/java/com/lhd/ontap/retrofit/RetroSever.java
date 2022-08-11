package com.lhd.ontap.retrofit;

import com.lhd.ontap.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroSever
{
    public static Retrofit retrofit = null;
    public static ApiMovie getRetrofitServer() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiMovie.class);

    }
}
