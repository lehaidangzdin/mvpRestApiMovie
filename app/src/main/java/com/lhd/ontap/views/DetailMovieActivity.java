package com.lhd.ontap.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.lhd.ontap.constants.Constants;
import com.lhd.ontap.databinding.ActivityDetailMovieBinding;
import com.lhd.ontap.models.Movie;

public class DetailMovieActivity extends AppCompatActivity {

    private final String TAG = "DetailArticleActivity";
    private ActivityDetailMovieBinding binding;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getDataFromActivity();
    }

    private void getDataFromActivity() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle == null) return;
        movie = (Movie) bundle.getSerializable("movie");
        Log.d(TAG, "getDataFromActivity: " + movie.getId());
        fillData();

    }

    private void fillData() {
        Glide.
                with(this)
                .load(Constants.PATH_IMAGE+movie.getBackDropPath())
//                .placeholder(R.drawable.pla)
                .centerCrop()
                .into(binding.img);
        binding.tvTitle.setText(movie.getTitle());
        binding.tvRelease.setText(movie.getReleaseDate());
//        binding.tvPublishedAt.setText(article.getPublishedAt().substring(0, 10));
//        binding.tvContent.setText(article.getContent());
    }
}