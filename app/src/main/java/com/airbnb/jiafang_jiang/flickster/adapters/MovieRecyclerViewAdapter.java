package com.airbnb.jiafang_jiang.flickster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.jiafang_jiang.flickster.R;
import com.airbnb.jiafang_jiang.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    private List<Movie> movies;
    private Context context;

    private static final int VIEW_HOLDER_POSTER = 0;
    private static final int VIEW_HOLDER_BACKDROP = 1;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View movieView = inflater.inflate(R.layout.item_movie, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(movieView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.movieTitle.setText(movie.getTitle());
        holder.movieOverview.setText(movie.getOverview());

        switch (getItemViewType(position)) {
            case VIEW_HOLDER_BACKDROP:
                Picasso.with(context)
                        .load(movie.getBackdropPath())
                        .placeholder(R.drawable.shiba_inu)
                        .into(holder.movieImage);
                break;
            case VIEW_HOLDER_POSTER:
                Picasso.with(context)
                        .load(movie.getPosterPath())
                        .placeholder(R.drawable.shiba_inu)
                        .into(holder.movieImage);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (isInLandscapeMode()) {
            return VIEW_HOLDER_BACKDROP;
        }
        return VIEW_HOLDER_POSTER;
    }

    private boolean isInLandscapeMode() {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }


    public Context getContext() {
        return context;
    }

    public void clear() {
        movies.clear();
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movieTitle) TextView movieTitle;
        @BindView(R.id.movieOverview) TextView movieOverview;
        @BindView(R.id.movieImage) ImageView movieImage;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
