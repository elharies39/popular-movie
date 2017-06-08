package com.appku.elharies.moviepopular.rest;

import com.appku.elharies.moviepopular.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by El Haries on 6/8/2017.
 */

public interface ApiInterface {
    @GET("movie/popular")
    Call<MovieResponse> getMoviePopular(@Query("api_key") String apiKey);
}
