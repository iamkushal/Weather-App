package com.example.kushal.current_weather;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface weatherInterface {
    @GET("weather")
    Call<model> getWeather(@Query("lat") Double lat, @Query("lon") Double lon, @Query("appid") String appId);

    @GET("forecast")
    Call<model2> get5Weather(@Query("lat") Double lat, @Query("lon") Double lon, @Query("appid") String appId);

}
