package com.vikas.codetest.rest;

import com.vikas.codetest.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vikas on 11/28/2017.
 */

public interface ApiInterface {
    @GET("movie/upcoming")
    Call<Movie> getUpcomingMovie(@Query("api_key") String apiKey);

    @GET("movie/{movie-id}")
    Call<Movie> getMovieDetails(@Path("movie-id") int id, @Query("api_key") String apiKey);

    @GET("movie/{movie-id}/images")
    Call<Movie> getMovieImaghes(@Path("movie-id") int id, @Query("api_key") String apiKey);
}


