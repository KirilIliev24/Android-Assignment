package com.example.and_final_project.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.and_final_project.API.Drink;
import com.example.and_final_project.API.DrinkRepository;

public class DrinkViewModel extends AndroidViewModel {

    private DrinkRepository repository;
    private MutableLiveData<Drink> randomDrink;

    public DrinkViewModel(@NonNull Application application) {
        super(application);
        repository = new DrinkRepository();
        //randomDrink = new MutableLiveData<>();
        randomDrink = repository.getDrink();
    }

    public LiveData<Drink> getRecipe()
    {
        return randomDrink;
    }

    public void clickForDrink()
    {
        repository.getRandomDrink();
    }
}
