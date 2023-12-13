package com.project.food;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.food.adapter.FoodListAdapter;
import com.project.food.databinding.ActivityFoodListBinding;
import com.project.food.models.Settings;
import com.project.food.ui.FoodListFragment;
import com.project.food.utility.Constants;

import org.parceler.Parcels;

public class FoodListActivity extends AppCompatActivity {
    public static final String TAG = FoodListActivity.class.getSimpleName();
    private ActivityFoodListBinding binding;
    private FoodListAdapter adapter;
    private String category;
    private Settings userSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        category = getIntent().getStringExtra(Constants.EXTRA_CATEGORIES);
        userSettings = Parcels.unwrap(getIntent().getParcelableExtra(Constants.EXTRA_USER_SETTINGS));

        inflateFragment();
    }

    private void inflateFragment(){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container, FoodListFragment.newInstance(category, userSettings))
                .commit();
    }
}
