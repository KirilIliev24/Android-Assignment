package com.example.and_final_project.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.and_final_project.API.Drink;
import com.example.and_final_project.R;
import com.example.and_final_project.ViewModels.DrinkViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrinkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinkFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private DrinkViewModel drinkViewModel;

    public DrinkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinkFragment newInstance(String param1, String param2) {
        DrinkFragment fragment = new DrinkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drink_fragment_layout, container, false);

        final TextView drinkName = view.findViewById(R.id.drinkName);
        final TextView drinkType = view.findViewById(R.id.drinkType);
        final TextView drinkRecipe = view.findViewById(R.id.drinkRecipe);
        final TextView drinkIngredients = view.findViewById(R.id.drinkIngredients);

        drinkRecipe.setMovementMethod(new ScrollingMovementMethod());
        drinkIngredients.setMovementMethod(new ScrollingMovementMethod());

        drinkViewModel = ViewModelProviders.of(this).get(DrinkViewModel.class);
        drinkViewModel.getRecipe().observe(this, new Observer<Drink>() {
            @Override
            public void onChanged(Drink drink) {
                drinkName.setText("Drink name: " + drink.getStrDrink());
                drinkType.setText("Drink type: " + drink.getStrCategory());
                drinkRecipe.setText(drink.getStrInstructions());
                drinkIngredients.setText("");
                for(int i = 0; i < drink.getIngredients().size(); i++)
                {
                    drinkIngredients.append(drink.getIngrAt(i) + "\n");
                }
            }
        });

        Button drinkButton = view.findViewById(R.id.buttonForDrink);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drinkViewModel.clickForDrink();
            }
        });
        return view;
    }
}
