package com.example.sfyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sfyproject.adapters.ImageAdapter;
import com.example.sfyproject.interfaces.ImageApi;
import com.example.sfyproject.models.Image;
import com.example.sfyproject.models.ImageList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    public final static String BASE_URL = "https://api.unsplash.com/";
    public final static String API_KEY = "oLLCTeG87yFwYsu5tTLa4Gmg_cdBP2bBzuzJJK9zEmY";
    private static ArrayList<Image> images;
    private ImageAdapter imageAdapter;

    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    public void initComponents()
    {
        rvList = findViewById(R.id.rvList);

        images = new ArrayList<>();
        imageAdapter = new ImageAdapter(this, images);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false));
        rvList.setAdapter(imageAdapter);

        searchImages("flores");
    }

    public void searchImages(String query)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImageApi imageApi = retrofit.create(ImageApi.class);

        Call<ImageList> call=imageApi.searchImages(query, API_KEY);
        call.enqueue(new Callback<ImageList>()
        {
            @Override
            public void onResponse(Call<ImageList> call, Response<ImageList> response)
            {
                if(response.isSuccessful())
                {
                    images.addAll(response.body().getresults());
                    imageAdapter.notifyDataSetChanged(); //No actualiza la informacion del adapter
                }
            }

            @Override
            public void onFailure(Call<ImageList> call, Throwable t)
            {

            }
        });
    }

}