package com.example.retrofitjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitjava.R;
import com.example.retrofitjava.adapter.RecyclerViewAdapter;
import com.example.retrofitjava.model.CryptoModel;
import com.example.retrofitjava.service.CryptoAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<CryptoModel> cyrptoModels;
    private String BASE_URL = "https://raw.githubusercontent.com/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        loadData();
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void loadData(){
        final CryptoAPI cryptoAPI = retrofit.create(CryptoAPI.class);


//        Call<List<CryptoModel>> call = cryptoAPI.getData ();
//
//        call.enqueue(new Callback<List<CryptoModel>>() {
//            @Override
//            public void onResponse(Call<List<CryptoModel>> call, Response<List<CryptoModel>> response) {
//                if (response.isSuccessful()){
//                    List<CryptoModel> responseList = response.body();
//                    cyrptoModels = new ArrayList<>(responseList);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                    recyclerViewAdapter = new RecyclerViewAdapter(cyrptoModels);
//                    recyclerView.setAdapter(recyclerViewAdapter);
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<CryptoModel>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }
}