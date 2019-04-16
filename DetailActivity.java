package com.example.Assignment;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.Assignment.MainActivity.AppId;

public class DetailActivity extends AppCompatActivity {
    NewDatabase newDatabase;
    ApiService apiService;
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();//to hide title bar
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_detail);

        newDatabase = NewDatabase.getInstance(this);



        apiService = BuilderClass.getClient().create(ApiService.class);
        recyclerView = findViewById(R.id.recyclerView);


        Intent intent = getIntent();
        if (intent.hasExtra("city")){
            final String rcvData = intent.getStringExtra("city");//getting name of city from main activity


            final Call<WeatherModel> call = apiService.getCurrentWeatherData(rcvData,AppId,"metric");//Creating object of Call to get responses

            call.enqueue(new Callback<WeatherModel>() {//Adding object to request queue
                @Override
                public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {//getting responses
                    final WeatherModel body = response.body();
                    if (response.isSuccessful()) {
                        List<com.example.Assignment.List> weatherModels = response.body().getList();//storing responses in object of List

                        if (weatherModels.isEmpty()){
                            Toast.makeText(DetailActivity.this, "no result found", Toast.LENGTH_SHORT).show();
                        }else {

                            adapter = new Adapter(DetailActivity.this, weatherModels,rcvData);//creating adapter to populate recycler view
                            recyclerView.setLayoutManager(new LinearLayoutManager(DetailActivity.this));
                            recyclerView.setAdapter(adapter);
                        }
                    }else {
                        Toast.makeText(DetailActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                    }



                }

                @Override
                public void onFailure(Call<WeatherModel> call, Throwable t) {// if call fails
                    Log.d("error",t.getMessage());

                    Toast.makeText(DetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });


        }



}

}
