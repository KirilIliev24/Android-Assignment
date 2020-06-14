package com.example.and_final_project.API;

import androidx.room.Query;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

//https://www.thecocktaildb.com/api/json/v1/1/random.php
public interface DrinkApi {
    @GET("api/json/v1/1/random.php")
    Call<DrinkResponse> getRandomDrink();

}
