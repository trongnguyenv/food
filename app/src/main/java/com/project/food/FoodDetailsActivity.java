package com.project.food;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.project.food.databinding.ActivityFoodDetailsBinding;
import com.project.food.ui.FoodDetailsFragment;
import com.project.food.utility.Constants;
import com.project.food.utility.DatabaseHelper;

public class FoodDetailsActivity extends AppCompatActivity {
    public static final String TAG = FoodDetailsActivity.class.getSimpleName();
    private ActivityFoodDetailsBinding binding;
    private String hint;
    private boolean foodStatus;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // on below line we are initializing our db class.
        db = new DatabaseHelper(this);

        // Retrieve intent extras
        hint = getIntent().getStringExtra(Constants.EXTRA_HINT);
        foodStatus = getIntent().getBooleanExtra(Constants.EXTRA_SAVED, false);

        inflateFragment();
    }

    // Inflate RecipeDetailsFragment with extras
    private void inflateFragment(){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container, FoodDetailsFragment.newInstance(hint, foodStatus))
                .commit();
    }
}
