package com.project.food.ui;

import static com.project.food.utility.Constants.EXTRA_HINT;
import static com.project.food.utility.UserInterfaceHelpers.hideProgressDialog;
import static com.project.food.utility.UserInterfaceHelpers.showFoodDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.project.food.R;
import com.project.food.adapter.MeasureListAdapter;
import com.project.food.databinding.FragmentFoodDetailsBinding;
import com.project.food.models.Hint;

import java.util.Locale;
import java.util.Objects;

public class FoodDetailsFragment extends Fragment {
    public static final String TAG = FoodDetailsFragment.class.getSimpleName();
    private FragmentFoodDetailsBinding binding;
    private String hint;
    private boolean foodStatus;
    private static final String ARG_HINT = "hint";
    private static final String ARG_FOOD_STATUS = "food_status";

    public FoodDetailsFragment() {
        // Required empty public constructor
    }

    public static FoodDetailsFragment newInstance(String hint, boolean foodStatus) {
        FoodDetailsFragment fragment = new FoodDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_HINT, hint);
        args.putBoolean(ARG_FOOD_STATUS, foodStatus);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            hint = getArguments().getString(EXTRA_HINT);
            foodStatus = getArguments().getBoolean(ARG_FOOD_STATUS);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadFood(hint);
    }

    private void setUpSaveButton(Hint hint) {
        if (foodStatus){
            binding.btnSave.setVisibility(View.GONE);
        } else {
            binding.btnSave.setOnClickListener(view -> saveFood(hint));
        }
    }

    // Load recipe details
    private void loadFood(String data){
        // convert json to hint class
        Hint hint = new Gson().fromJson(data, Hint.class);
        hideProgressDialog(binding.progressBar, binding.progressMessage);
        setFoodDetails(hint);
        showFoodDetails(binding.foodImage, binding.detailsBottomSheetGroup);
        setUpSaveButton(hint);
    }

    private void setFoodDetails(Hint hint){
        // Setup action bar title
        ActionBar actionBar = Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar());
        actionBar.setTitle(hint.getFood().getLabel());

        Glide.with(requireContext()).asBitmap().load(hint.getFood().getImage()).placeholder(R.drawable.brunch_dining).into(binding.foodImage);
        binding.foodLabel.setText(hint.getFood().getLabel());
        binding.foodSource.setText(hint.getFood().getLabel());

        // Set calories and serving quantity
        binding.caloriesQuantity.setText(String.format(Locale.ENGLISH, "%.2f", hint.getFood().getNutrients().getENERC_KCAL()));
        binding.yieldQuantity.setText(String.format(Locale.ENGLISH, "%.2f", hint.getFood().getNutrients().getPROCNT()));

        //Set measure list
        binding.ingredientList.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.ingredientList.setAdapter(new MeasureListAdapter(requireContext(), hint.getMeasures(), hint.getFood().getImage()));
    }

    private void saveFood(Hint hint) {
    }
}
