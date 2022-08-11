package com.lhd.ontap.adapter;

import com.lhd.ontap.models.Movie;

public interface IOnclickItem {
    interface clickMovie {
        void onClickItem(Movie movie);
    }

    interface clickCategories {
        void onClickItem(Movie movie);
    }
}
