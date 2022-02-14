package com.example.sfyproject.models;

public class Image
{
    private String id;
    private String description;
    private Url urls;
    private int likes;

    public Image(String id, String description, Url urls, int likes)
    {
        this.id = id;
        this.description = description;
        this.urls = urls;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Url getUrls() {
        return urls;
    }

    public int getLikes() {
        return likes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrls(Url urls) {
        this.urls = urls;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
