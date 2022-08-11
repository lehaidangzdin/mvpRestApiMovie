package com.lhd.ontap.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.lhd.ontap.adapter.IOnclickItem;
import com.lhd.ontap.adapter.MovieAdapter;
import com.lhd.ontap.databinding.ActivityMain2Binding;
import com.lhd.ontap.models.Movie;
import com.lhd.ontap.presenter.MovieContract;
import com.lhd.ontap.presenter.MoviePresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieContract.View, IOnclickItem.clickMovie {

    private ActivityMain2Binding binding;
    private MoviePresenter presenter;
    private MovieAdapter movieAdapter;
    private List<Movie> lsMovies = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initControls();
        presenter.fetchMovie();
    }

    private void initControls() {
        presenter = new MoviePresenter(this);
        movieAdapter = new MovieAdapter(getApplicationContext(), lsMovies, this);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        binding.rcv.setLayoutManager(manager);
        binding.rcv.setAdapter(movieAdapter);
    }


    @Override
    public void success(List<Movie> lsMovies) {
        binding.process.setVisibility(View.GONE);
        movieAdapter.updateList(lsMovies);
    }

    @Override
    public void failure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickItem(Movie movie) {
        Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("movie",movie);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}