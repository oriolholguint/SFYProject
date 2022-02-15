package com.example.sfyproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sfyproject.interfaces.UnsplashApi;
import com.example.sfyproject.models.Image;
import com.example.sfyproject.models.ImageList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    /*public void searchImages (String query)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UnsplashApi unsplashApi = retrofit.create(UnsplashApi.class);

        Call<ImageList> call = unsplashApi.searchImages(query, MainActivity.API_KEY);

        call.enqueue(new Callback<ImageList>()
        {
            @Override
            public void onResponse(Call<ImageList> call, Response<ImageList> response)
            {
                if (response.isSuccessful())
                {
                    goToMainActivity(response.body().getresults());
                }
            }

            @Override
            public void onFailure(Call<ImageList> call, Throwable t)
            {

            }
        });
    }*/
}
