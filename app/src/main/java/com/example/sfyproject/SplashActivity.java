package com.example.sfyproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);

        Intent intent;

        if(!preferences.getBoolean("on_board_screen", false))
        {
            savePreferences(preferences);
            intent = new Intent(this, OnBoardActivity.class);
        }
        else
        {
            intent = new Intent(this, MainActivity.class);
        }

        startActivity(intent);
        finish();
    }

    public void savePreferences(SharedPreferences sharedPreferences)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("on_board_screen", true);
        editor.commit();
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
