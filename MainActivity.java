package com.example.Assignment;

import android.content.Context;
import android.content.Intent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public final static String BaseUrl = "http://api.openweathermap.org/";
    public final static String AppId = "2fd1f1825f7902ce70a37d9f6ab5c0b0";

    EditText cityEdit;

    ApiService apiService;


    /*ArrayList<Entry> tempMumbai;
    ArrayList<Entry> tempAhemadabad;
    ArrayList<String> dateMum;
    Button minBtn, maxBtn;
    NewDatabase newDatabase;
    DecimalFormat decimalFormat;*/
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();//hiding title bar
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        if (AppId.equals("")) {
            Toast.makeText(this, "put your API key inside MainActivity class in a valiable named AppId", Toast.LENGTH_LONG).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 4000);
            return;
        }

        cityEdit = findViewById(R.id.cityEdit);//edit text to enter name of city
        sendBtn = findViewById(R.id.sendBtn);//Button to call api in other activity


       /* decimalFormat = new DecimalFormat(".##");
        newDatabase = NewDatabase.getInstance(this);

        tempMumbai = new ArrayList<Entry>();
        tempAhemadabad = new ArrayList<Entry>();
        dateMum = new ArrayList<>();


        minBtn = findViewById(R.id.minTempBtn);
        maxBtn = findViewById(R.id.maxTempBtn);*/


        /*maxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("temp", "max");
                startActivity(intent);
            }
        });
        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("temp", "min");
                startActivity(intent);
            }
        });*/


        sendBtn.setOnClickListener(new View.OnClickListener() {//listener for send button
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String city = cityEdit.getText().toString();







                if (city.isEmpty()) {//checking if editText is empty or not
                    Toast.makeText(MainActivity.this, "enter city name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);//Intent used to launch next detail activity
                    intent.putExtra("city", city);
                    startActivity(intent);

                }










     /*   new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },10000);*/

            }
        });


    }
}
