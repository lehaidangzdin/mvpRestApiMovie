package com.lhd.ontap.presenter;

import android.util.Log;

import com.lhd.ontap.constants.Constants;
import com.lhd.ontap.response.ListMovieResponse;
import com.lhd.ontap.retrofit.ApiMovie;
import com.lhd.ontap.retrofit.RetroSever;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements MovieContract.MoviePresenter {

    private static String TAG = "MoviePresenter";
    private MovieContract.View view;
    private int pageNum = 1;

    public MoviePresenter(MovieContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchMovie() {
        ApiMovie apiMovie = RetroSever.getRetrofitServer();
        Call<ListMovieResponse> call = apiMovie.getListMovie(Constants.KEY, Constants.LANGUAGE, pageNum);
        call.enqueue(new Callback<ListMovieResponse>() {
            @Override
            public void onResponse(Call<ListMovieResponse> call, Response<ListMovieResponse> response) {
                ListMovieResponse listMovieResponse = response.body();
                view.success(listMovieResponse.getLsResult());
                Log.d(TAG, "onResponse: " + listMovieResponse.getLsResult());
            }

            @Override
            public void onFailure(Call<ListMovieResponse> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.getMessage());
                view.failure(Constants.FAILURE);


            }
        });
    }
}
