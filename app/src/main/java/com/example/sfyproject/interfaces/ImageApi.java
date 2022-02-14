package com.example.sfyproject.interfaces;

import com.example.sfyproject.models.Image;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ImageApi
{
    @GET("/search/{item}")
    public Call<Image> find(@Path("item") String item);
}
