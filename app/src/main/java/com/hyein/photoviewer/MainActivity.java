package com.hyein.photoviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Photo> photos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = findViewById(R.id.basicListView);

//        photos.add(new Photo("test1"));
//        photos.add(new Photo("test2"));
//
//        BasicAdapter basicAdapter = new BasicAdapter(getApplicationContext(),R.layout.cell_basic,photos);
//        listView.setAdapter(basicAdapter);


        HttpClient httpClient = new HttpClient();
        httpClient.getImage(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                photos = new Gson().fromJson(response.body().getAsJsonArray("photos"),
                        new TypeToken<List<Photo>>() {}.getType());
//                Log.e("RESPONSE", "response??? "+ photos);
                BasicAdapter basicAdapter = new BasicAdapter(getApplicationContext(),R.layout.cell_basic,photos);
                listView.setAdapter(basicAdapter);

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }
}
