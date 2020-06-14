package com.example.and_final_project.API;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DrinkResponse {

    private ArrayList<Drinks> drinks;

    public Drink getDrink()
    {
        ArrayList<String> finalArray = new ArrayList<>();

        if(drinks.get(0).strIngredient1 != null)
        {
            String ingredient = drinks.get(0).strIngredient1;
            if(drinks.get(0).strMeasure1 != null)
            {
                ingredient += ": ";
                ingredient += drinks.get(0).strMeasure1;
            }
            finalArray.add(ingredient);
        }
        if(drinks.get(0).strIngredient2 != null)
        {
            String ingredient = drinks.get(0).strIngredient2;
            if(drinks.get(0).strMeasure2 != null)
            {
                ingredient += ": ";
                ingredient += drinks.get(0).strMeasure2;
            }
            finalArray.add(ingredient);
        }
        if(drinks.get(0).strIngredient3 != null)
        {
            String ingredient = drinks.get(0).strIngredient3;
            if(drinks.get(0).strMeasure3 != null)
            {
                ingredient += ": ";
                ingredient += drinks.get(0).strMeasure3;
            }
            finalArray.add(ingredient);
        }
        if(drinks.get(0).strIngredient4 != null)
        {
            String ingredient = drinks.get(0).strIngredient4;
            if(drinks.get(0).strMeasure4 != null)
            {
                ingredient += ": ";
                ingredient += drinks.get(0).strMeasure4;
            }
            finalArray.add(ingredient);
        }
        if(drinks.get(0).strIngredient5 != null)
        {
            String ingredient = drinks.get(0).strIngredient5;
            if(drinks.get(0).strMeasure5 != null)
            {
                ingredient += ": ";
                ingredient += drinks.get(0).strMeasure5;
            }
            finalArray.add(ingredient);
        }
        if(drinks.get(0).strIngredient6 != null)
        {
            String ingredient = drinks.get(0).strIngredient6;
            if(drinks.get(0).strMeasure6 != null)
            {
                ingredient += ": ";
                ingredient += drinks.get(0).strMeasure6;
            }
            finalArray.add(ingredient);
        }
        if(drinks.get(0).strIngredient7 != null)
        {
            String ingredient = drinks.get(0).strIngredient7;
            if(drinks.get(0).strMeasure7 != null)
            {
                ingredient += ": ";
                ingredient += drinks.get(0).strMeasure7;
            }
            finalArray.add(ingredient);
        }
        if(drinks.get(0).strIngredient8 != null)
        {
            String ingredient = drinks.get(0).strIngredient8;
            if(drinks.get(0).strMeasure8 != null)
            {
                ingredient += ": ";
                ingredient += drinks.get(0).strMeasure8;
            }
            finalArray.add(ingredient);
        }

        return new Drink(drinks.get(0).strDrink, drinks.get(0).strCategory, drinks.get(0).strInstructions, finalArray);
    }

   private class Drinks
   {
       private String strDrink;
       private String strCategory;
       private String strInstructions;

       private String strIngredient1;
       private String strIngredient2;
       private String strIngredient3;
       private String strIngredient4;
       private String strIngredient5;
       private String strIngredient6;
       private String strIngredient7;
       private String strIngredient8;

       private String strMeasure1;
       private String strMeasure2;
       private String strMeasure3;
       private String strMeasure4;
       private String strMeasure5;
       private String strMeasure6;
       private String strMeasure7;
       private String strMeasure8;
   }
}
