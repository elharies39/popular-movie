package com.appku.elharies.moviepopular;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.appku.elharies.moviepopular.adapter.MovieAdapter;
import com.appku.elharies.moviepopular.model.MovieResponse;
import com.appku.elharies.moviepopular.model.Result;
import com.appku.elharies.moviepopular.rest.ApiClient;
import com.appku.elharies.moviepopular.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String API_KEY = "cfca9d4452fa2c08f658bda6fc1525ca";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tampilMovie();
    }

    public void tampilMovie(){
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_movie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiService.getMoviePopular(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Result> movie = response.body().getResults();
                Log.d(TAG,"Number of movies received: "+movie.size());
                recyclerView.setAdapter(new MovieAdapter(movie,R.layout.list_item,getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}
