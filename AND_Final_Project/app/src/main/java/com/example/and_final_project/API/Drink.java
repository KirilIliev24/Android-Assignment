package com.example.and_final_project.API;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private String strDrink;
    private String strCategory;
    private String strInstructions;
    private List<String> ingredients;

    public Drink(String strDrink, String strCategory, String strInstructions, List<String> ingredients) {
        this.strDrink = strDrink;
        this.strCategory = strCategory;
        this.strInstructions = strInstructions;
        this.ingredients = ingredients;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getIngrAt(int i)
    {
        return ingredients.get(i);
    }

}
