package com.example.sfyproject.models;

public class Image
{
    private String id;
    private String created_at;
    private String description;
    private Url urls;
    private int likes;

    public Image(String id, String created_at, String description, Url urls, int likes)
    {
        this.id = id;
        this.created_at = created_at;
        this.description = description;
        this.urls = urls;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Url getUrls() {
        return urls;
    }

    public void setUrls(Url urls) {
        this.urls = urls;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
