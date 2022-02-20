package com.example.sfyproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sfyproject.MainActivity;
import com.example.sfyproject.R;
import com.example.sfyproject.adapters.ImageAdapter;
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

public class ImageListFragment extends Fragment
{
    public FragmentCallback fragmentCallback;
    private Context context;
    private ArrayList<Image> images;
    private RecyclerView rvList;
    private ImageAdapter imageAdapter;

    public ImageListFragment(Context context)
    {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.image_list_fragment, container, false);

        rvList = view.findViewById(R.id.rvList);

        if(images == null)
        {
            images = new ArrayList<>();
            searchImages("flowers");
        }

        imageAdapter = new ImageAdapter(images);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL,false));
        rvList.setAdapter(imageAdapter);

        imageAdapter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Image image = images.get(rvList.getChildAdapterPosition(view));
                fragmentCallback.showImageDetailFragment(image);
            }
        });

        return view;
    }

    public void searchImages(String query)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UnsplashApi unsplashApi = retrofit.create(UnsplashApi.class);

        Call<ImageList> call= unsplashApi.searchImages(query, MainActivity.API_KEY);
        call.enqueue(new Callback<ImageList>()
        {
            @Override
            public void onResponse(Call<ImageList> call, Response<ImageList> response)
            {
                if(response.isSuccessful())
                {
                    updateData(response.body().getresults());
                }
            }

            @Override
            public void onFailure(Call<ImageList> call, Throwable t)
            {

            }
        });
    }

    public void updateData(ArrayList<Image> images)
    {
        this.images.clear();
        this.images.addAll(images);
        imageAdapter.notifyDataSetChanged();
    }
}
