package com.lhd.ontap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lhd.ontap.R;
import com.lhd.ontap.constants.Constants;
import com.lhd.ontap.databinding.ItemMovieBinding;
import com.lhd.ontap.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private List<Movie> lsMovies;
    private IOnclickItem.clickMovie onclickItem;

    public MovieAdapter(Context context, List<Movie> lsMovies, IOnclickItem.clickMovie onclickItem) {
        this.context = context;
        this.lsMovies = lsMovies;
        this.onclickItem = onclickItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Movie movie = lsMovies.get(position);
        if (movie == null) return;
        Glide.
                with(context)
                .load(Constants.PATH_IMAGE + movie.getPosterPath())
                .placeholder(R.drawable.loading)
                .centerCrop()
                .into(holder.binding.img);
        holder.binding.tvTitle.setText(movie.getTitle());
        holder.binding.cardView.setOnClickListener(view -> onclickItem.onClickItem(movie));
        holder.binding.tvRating.setText(movie.getVotePoint().toString());
    }

    @Override
    public int getItemCount() {
        if (lsMovies != null) {
            return lsMovies.size();
        }
        return 0;
    }

    public void updateList(List<Movie> lstArticles) {
        this.lsMovies = lstArticles;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemMovieBinding binding;

        public ViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
