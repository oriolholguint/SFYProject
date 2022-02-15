package com.example.sfyproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sfyproject.R;
import com.example.sfyproject.interfaces.FragmentCallback;
import com.example.sfyproject.models.Image;
import com.squareup.picasso.Picasso;

public class ImageDetailFragment extends Fragment
{
    public FragmentCallback fragmentCallback;
    private Image selectedImage;
    private ImageView imagePic;
    private TextView imageDate;
    private TextView imageLikes;
    private TextView imageDescription;
    private TextView imageId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.image_detail_fragment, container, false);

        imagePic         = view.findViewById(R.id.imagePic);
        imageDate        = view.findViewById(R.id.imageDate);
        imageLikes       = view.findViewById(R.id.imageLikes);
        imageDescription = view.findViewById(R.id.imageDescription);
        imageId          = view.findViewById(R.id.imageId);

        Picasso.with(view.getContext())
                .load(selectedImage.getUrls().getRegular())
                .fit()
                .centerCrop()
                .into(imagePic);
        imageDate.setText(selectedImage.getCreated_at());
        imageLikes.setText(selectedImage.getLikes() + " likes");
        imageDescription.setText(selectedImage.getDescription());
        imageId.setText("Id: " + selectedImage.getId());

        return view;
    }

    public void setImage(Image image)
    {
        this.selectedImage = image;
    }
}
