package com.lhd.ontap.retrofit;

import com.lhd.ontap.response.ListMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiMovie {
    @GET("movie/now_playing")
    Call<ListMovieResponse> getListMovie(@Query("api_key") String apiKey,
                                         @Query("language") String language,
                                         @Query("page") int page);

    //    https://api.themoviedb.org/3/movie/297762?api_key=e9e9d8da18ae29fc430845952232787c&append_to_response=videos
    @GET("movie/{id}")
    Call<ListMovieResponse> getDetailMovie(@Path("id") int id,
                                           @Query("api_key") String apiKey,
                                           @Query("append_to_response") String language);

}
