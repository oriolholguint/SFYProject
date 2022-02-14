package com.example.sfyproject.models;

import java.util.ArrayList;

public class ImageList
{
    private ArrayList<Image> results;

    public ImageList(ArrayList<Image> results)
    {
        this.results = results;
    }

    public ArrayList<Image> getresults() {
        return results;
    }

    public void setresults(ArrayList<Image> results) {
        this.results = results;
    }
}
