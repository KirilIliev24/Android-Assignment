package com.example.and_final_project.API;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.and_final_project.data.DataBase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkRepository {

    private DrinkApi drinkApi;
    private MutableLiveData<Drink> randomDrink;


    public DrinkRepository()
    {
        drinkApi = ServiceGenerator.getDrinkApi();
        randomDrink = new MutableLiveData<>();
    }

    public void getRandomDrink()
    {
        Call<DrinkResponse> call = drinkApi.getRandomDrink();
        call.enqueue(new Callback<DrinkResponse>() {

            @Override
            public void onResponse(Call<DrinkResponse> call, Response<DrinkResponse> response) {
                if(response.code() == 200)
                {
                    randomDrink.postValue(response.body().getDrink());
                    Log.i("Something if is ok", response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<DrinkResponse> call, Throwable t) {
                Log.i("Retrofit", "Error in the repository over heeeeeeeeeeeeeeeeeeere");
            }
        });
    }

    public MutableLiveData<Drink> getDrink()
    {
        return randomDrink;
    }

}
