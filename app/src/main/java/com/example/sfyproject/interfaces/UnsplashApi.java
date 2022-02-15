package com.example.sfyproject.interfaces;

import com.example.sfyproject.models.ImageList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnsplashApi
{
    //@Headers("Authorization: Client-ID "+MainActivity.API_KEY)
    @GET("/search/photos")
    Call<ImageList> searchImages(@Query("query") String query, @Query("client_id") String client_id);
}
