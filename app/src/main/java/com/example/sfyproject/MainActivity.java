package com.example.sfyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.sfyproject.adapters.ImageAdapter;
import com.example.sfyproject.fragments.ImageListFragment;
import com.example.sfyproject.interfaces.FragmentCallback;
import com.example.sfyproject.interfaces.ImageApi;
import com.example.sfyproject.models.Image;
import com.example.sfyproject.models.ImageList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements FragmentCallback
{
    public final static String BASE_URL = "https://api.unsplash.com/";
    public final static String API_KEY = "oLLCTeG87yFwYsu5tTLa4Gmg_cdBP2bBzuzJJK9zEmY";
    private FragmentManager fragmentManager;
    private ImageListFragment imageListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    public void initComponents()
    {
        imageListFragment = new ImageListFragment(this);

        showImageListFragment();
        searchImages("flowers");
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
                    imageListFragment.updateData(response.body().getresults());
                }
            }

            @Override
            public void onFailure(Call<ImageList> call, Throwable t)
            {

            }
        });
    }

    @Override
    public void showImageListFragment()
    {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        imageListFragment.fragmentCallback = this;
        fragmentTransaction.replace(R.id.frgContainter, imageListFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void showImageDetailFragment(Image image)
    {

    }
}