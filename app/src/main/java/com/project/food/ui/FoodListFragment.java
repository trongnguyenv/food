package com.project.food.ui;

import static com.project.food.utility.UserInterfaceHelpers.hideProgressDialog;
import static com.project.food.utility.UserInterfaceHelpers.showFailureFeedback;
import static com.project.food.utility.UserInterfaceHelpers.showNoContentFound;
import static com.project.food.utility.UserInterfaceHelpers.showFoods;
import static com.project.food.utility.UserInterfaceHelpers.showUnsuccessfulFeedback;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.project.food.FoodDetailsActivity;
import com.project.food.R;
import com.project.food.adapter.FoodListAdapter;
import com.project.food.client.EdamamClient;
import com.project.food.databinding.FragmentFoodListBinding;
import com.project.food.interfaces.EdamamApi;
import com.project.food.interfaces.ItemOnClickListener;
import com.project.food.models.FoodResponse;
import com.project.food.models.Hint;
import com.project.food.models.Settings;
import com.project.food.utility.Constants;

import org.parceler.Parcels;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodListFragment extends Fragment implements ItemOnClickListener {
    public static final String TAG = FoodListFragment.class.getSimpleName();
    private FragmentFoodListBinding binding;
    private String foodCategory;
    private Settings userSettings;
    private FoodListAdapter adapter;

    public FoodListFragment() {
        // Required empty public constructor
    }

    public static FoodListFragment newInstance(String category, Settings userSettings) {
        FoodListFragment fragment = new FoodListFragment();
        Bundle args = new Bundle();
        args.putString(Constants.EXTRA_CATEGORIES, category);
        args.putParcelable(Constants.EXTRA_USER_SETTINGS, Parcels.wrap(userSettings));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            foodCategory = getArguments().getString(Constants.EXTRA_CATEGORIES);
            userSettings = Parcels.unwrap(getArguments().getParcelable(Constants.EXTRA_USER_SETTINGS));
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        binding = FragmentFoodListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set action bar title to passed meal type
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        Objects.requireNonNull(actionBar).setTitle(foodCategory);

        EdamamApi client = EdamamClient.getClient();
        Call<FoodResponse> call = client.getFoods(Constants.EDAMAM_API_ID, Constants.EDAMAM_API_KEY, "", foodCategory);
        loadFoods(call);
    }


    private void loadFoods(Call<FoodResponse> call){
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(@NonNull Call<FoodResponse> call, @NonNull Response<FoodResponse> response) {
                hideProgressDialog(binding.progressBar, binding.progressMessage);

                if(response.isSuccessful()){
                    assert response.body() != null;
                    adapter = new FoodListAdapter(getContext(), response.body().getHints(), FoodListFragment.this);

                    setLayoutManager();

                    binding.foodList.setAdapter(adapter);

                    if(adapter.getItemCount() > 0){
                        showFoods(binding.foodList);
                    } else {
                        showNoContentFound(binding.errorText, getString(R.string.no_foods_found));
                    }
                } else {
                    showUnsuccessfulFeedback(binding.errorText, requireContext());
                }
            }

            @Override
            public void onFailure(@NonNull Call<FoodResponse> call, @NonNull Throwable t) {
                hideProgressDialog(binding.progressBar, binding.progressMessage);
                showFailureFeedback(binding.errorText, requireContext());
                Log.e(TAG, "Error: ", t);
            }
        });
    }

    private void setLayoutManager(){
        // Set layout manager based on orientation
        if(binding.getRoot().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.foodList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {
            binding.foodList.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }


    @Override
    public void onClick(Hint hint, boolean isSaved) {
        Intent intent = new Intent(getContext(), FoodDetailsActivity.class);
        // convert hint class into json string put extra
        String data = new Gson().toJson(hint);
        intent.putExtra(Constants.EXTRA_HINT, data);
        intent.putExtra(Constants.EXTRA_SAVED, isSaved);
        Log.d(TAG, "Hint: " + hint);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
