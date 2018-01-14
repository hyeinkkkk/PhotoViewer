package com.hyein.photoviewer;

import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nolgong-hyein on 2018. 1. 14..
 */

public class HttpClient {
    static String API_BASE_URL = "http://demo2587971.mockable.io";

    OkHttpClient.Builder client = new OkHttpClient.Builder();

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.client(client.build()).build();

    HttpService service = retrofit.create(HttpService.class);

    public void getImage(Callback<JsonObject> callback){
        Call<JsonObject> call = service.getImages();
        call.enqueue(callback);
    }
}
