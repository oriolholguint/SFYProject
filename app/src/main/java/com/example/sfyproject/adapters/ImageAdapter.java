package com.example.sfyproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sfyproject.R;
import com.example.sfyproject.models.Image;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> implements View.OnClickListener
{
    private ArrayList<Image> images;
    private View.OnClickListener listener;

    public ImageAdapter(ArrayList<Image> images)
    {
        this.images = images;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imagePic;
        TextView imageDescription;
        TextView imageLikes;

        public ViewHolder(View item)
        {
            super(item);
            imagePic         = item.findViewById(R.id.imagePic);
            imageDescription = item.findViewById(R.id.imageDescription);
            imageLikes       = item.findViewById(R.id.imageLikes);
        }

        void bindImage(Image image)
        {
            imageDescription.setText(image.getDescription());
            imageLikes.setText(image.getLikes() + " likes");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);

        item.setOnClickListener(this);

        return new ViewHolder(item);
    }

    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.bindImage(images.get(position));
    }

    public int getItemCount()
    {
        return this.images.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view)
    {
        if(listener != null)
        {
            listener.onClick(view);
        }
    }
}
