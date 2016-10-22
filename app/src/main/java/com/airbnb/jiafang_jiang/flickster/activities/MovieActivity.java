package com.airbnb.jiafang_jiang.flickster.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.airbnb.jiafang_jiang.flickster.R;
import com.airbnb.jiafang_jiang.flickster.adapters.MovieRecyclerViewAdapter;
import com.airbnb.jiafang_jiang.flickster.models.Movie;
import com.airbnb.jiafang_jiang.flickster.models.MovieJsonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class MovieActivity extends AppCompatActivity {

    @BindView(R.id.swipe_refresh_layout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    private static final String MOVIE_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    private static final String STATE_SCROLL_POSITION = "scroll_position";

    private final AsyncHttpClient client = new AsyncHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Movie> movies = Lists.newArrayList();

    private MovieRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        adapter = new MovieRecyclerViewAdapter(this, movies);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        swipeRefreshLayout.setOnRefreshListener(() -> refreshMovies());

        if (movies.isEmpty()) {
            getMovies();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(
                STATE_SCROLL_POSITION,
                ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int pos = savedInstanceState.getInt(STATE_SCROLL_POSITION);
        recyclerView.getLayoutManager().scrollToPosition(pos);
    }

    public void refreshMovies() {
        adapter.clear();
        getMovies();
    }

    private void getMovies() {
        client.get(MOVIE_URL, new BaseJsonHttpResponseHandler<MovieJsonResponse>() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, MovieJsonResponse response) {
                movies.addAll(response.getResults());
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, MovieJsonResponse errorResponse) {
                Log.w("[NETWORK ERROR]", errorResponse.toString());
            }

            @Override
            protected MovieJsonResponse parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                return mapper.readValue(rawJsonData, MovieJsonResponse.class);
            }
        });
    }

}
