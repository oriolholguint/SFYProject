package com.example.sfyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.sfyproject.fragments.ImageDetailFragment;
import com.example.sfyproject.fragments.ImageListFragment;
import com.example.sfyproject.interfaces.FragmentCallback;
import com.example.sfyproject.interfaces.UnsplashApi;
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
    private ImageDetailFragment imageDetailFragment;

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
        imageDetailFragment = new ImageDetailFragment();

        showImageListFragment();

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
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        imageDetailFragment.fragmentCallback = this;
        imageDetailFragment.setImage(image);
        fragmentTransaction.replace(R.id.frgContainter, imageDetailFragment);
        fragmentTransaction.commit();
    }
}