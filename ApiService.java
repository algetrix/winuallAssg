package com.example.Assignment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ApiService {
        @GET("data/2.5/forecast?")//getting data from api
        Call<WeatherModel> getCurrentWeatherData(@Query("q") String city, @Query("APPID") String apiKey,
                                                 @Query("units") String unit);

    }

