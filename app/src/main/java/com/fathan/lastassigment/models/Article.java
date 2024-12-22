package com.fathan.lastassigment.models;

public class Article {
    private String title;
    private String overview;
    private int imageId;

    public Article(String title, String overview, int imageId) {
        this.title = title;
        this.overview = overview;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public int getImageId() {
        return imageId;
    }
}
