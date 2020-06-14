package com.example.and_final_project.API;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DrinkTest {

    private Drink drink;
    List<String> ingr;
    @Before
    public void setUp() throws Exception {
        ingr = new ArrayList<>();
        ingr.add("Vodka");
        ingr.add("Orange juice");

        drink = new Drink("Screwdriver", "Alcoholic", "Mix the ingredients, rink and have fun", ingr);

    }

    @Test
    public void getStrDrink() {
        String drinkName = drink.getStrDrink();
        assertEquals(drinkName, "Screwdriver");
    }

    @Test
    public void getStrCategory() {
        String drinkCategory = drink.getStrCategory();
        assertEquals(drinkCategory, "Alcoholic");
    }

    @Test
    public void getStrInstructions() {
        String drinkInstructions = drink.getStrInstructions();
        assertEquals(drinkInstructions, "Mix the ingredients, rink and have fun");
    }

    @Test
    public void getIngredients() {
        List<String> drinkIngr = drink.getIngredients();
        assertArrayEquals(drinkIngr.toArray(), ingr.toArray());
    }

    @Test
    public void getIngrAt() {
        String firstIngr = drink.getIngrAt(0);
        String secondIngr = drink.getIngrAt(1);

        assertEquals(firstIngr, "Vodka");
        assertEquals(secondIngr, "Orange juice");
    }
}