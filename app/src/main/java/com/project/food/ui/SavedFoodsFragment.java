package com.project.food.ui;

import static com.project.food.utility.UserInterfaceHelpers.hideProgressDialog;
import static com.project.food.utility.UserInterfaceHelpers.showFoods;
import static com.project.food.utility.UserInterfaceHelpers.showNoContentFound;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.project.food.FoodDetailsActivity;
import com.project.food.R;
import com.project.food.adapter.FoodListAdapter;
import com.project.food.databinding.FragmentSavedFoodBinding;
import com.project.food.interfaces.ItemOnClickListener;
import com.project.food.models.FoodFavorite;
import com.project.food.models.Hint;
import com.project.food.utility.Constants;
import com.project.food.utility.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class SavedFoodsFragment extends Fragment implements ItemOnClickListener {
    public static final String TAG = SavedFoodsFragment.class.getSimpleName();
    private FragmentSavedFoodBinding binding;
    private ItemTouchHelper itemTouchHelper;
    private DatabaseHelper db;
    private List<FoodFavorite> dataList;
    private FoodListAdapter adapter;

    public SavedFoodsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSavedFoodBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DatabaseHelper(getActivity());
        setUpData();
        hideProgressDialog(binding.progressBar, binding.progressMessage);
        showFoods(binding.starredFoodList);
    }

    private void setUpData(){
        dataList = db.readFoodFavorite();
        // convert json to hint class
        ArrayList<Hint> hints = new ArrayList<Hint>();
        for (int i=0, l=dataList.size(); i<l; i++){
            Hint hint = new Gson().fromJson(dataList.get(i).getData(), Hint.class);
            hints.add(hint);
        }
        setLayoutManager();
        if(hints.size() < 0){
            showNoContentFound(binding.errorText, getString(R.string.no_saved_recipes));
        }
        adapter = new FoodListAdapter(getContext(), hints, this);
        binding.errorText.setVisibility(View.GONE);
        binding.starredFoodList.setAdapter(adapter);
    }

    private void setLayoutManager(){
        // Set layout manager based on orientation
        if(binding.getRoot().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.starredFoodList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {
            binding.starredFoodList.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.onViewCreated(null, null);
    }

    @Override
    public void onClick(Hint hint, boolean isSaved) {
        Intent intent = new Intent(getContext(), FoodDetailsActivity.class);
        String data = new Gson().toJson(hint);
        intent.putExtra(Constants.EXTRA_HINT, data);
        intent.putExtra(Constants.EXTRA_SAVED, isSaved);
        startActivity(intent);
    }
}
