package com.hyein.photoviewer;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nolgong-hyein on 2018. 1. 14..
 */

public class Photo {
    @SerializedName("date_taken")
    String date;
    String title;

    String url;
    int width;
    int height;

    public Photo(){

    }

    public Photo(String title){
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "photo title is "+getTitle();
    }
}
