package com.hyein.photoviewer;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nolgong-hyein on 2018. 1. 14..
 */

public interface HttpService {
    //http://demo2587971.mockable.io/images

    @GET("/images")
    Call<JsonObject> getImages();
}
