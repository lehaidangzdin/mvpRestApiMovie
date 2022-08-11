package com.lhd.ontap.response;

import com.google.gson.annotations.SerializedName;
import com.lhd.ontap.models.Movie;

import java.util.List;

public class ListMovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> lsMovie;

    public List<Movie> getLsResult() {
        return lsMovie;
    }

}
