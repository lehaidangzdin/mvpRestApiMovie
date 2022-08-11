package com.lhd.ontap.presenter;

import com.lhd.ontap.models.Movie;

import java.util.List;

public interface MovieContract {
    interface View {
        void success(List<Movie> list);

        void failure(String message);
    }

    interface MoviePresenter {
        void fetchMovie();
    }
}
