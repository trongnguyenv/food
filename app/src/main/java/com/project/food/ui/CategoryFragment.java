package com.project.food.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.project.food.R;
import com.project.food.adapter.CategoryAdapter;
import com.project.food.databinding.FragmentCategoryBinding;
import com.project.food.models.Settings;
import com.project.food.utility.Constants;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryFragment extends Fragment {
    public static final String TAG = CategoryFragment.class.getSimpleName();
    private FragmentCategoryBinding binding;
    private Settings userSettings;
    private final List<Integer> categoryImages = new ArrayList<>(Arrays.asList(R.drawable.breakfast, R.drawable.lunch, R.drawable.brunch, R.drawable.snack));

    public CategoryFragment() {
    }

    public static CategoryFragment newInstance(Settings userSettings) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.EXTRA_USER_SETTINGS, Parcels.wrap(userSettings));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        userSettings = Parcels.unwrap(getArguments().getParcelable(Constants.EXTRA_USER_SETTINGS));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        updateTextViewContent();
        initializeRecyclerView();
    }

    private void updateTextViewContent(){
        if(userSettings != null){
            binding.welcomeText.setText(getString(R.string.welcome, userSettings.getName()));
        }
    }

    private void initializeRecyclerView(){
        // Set layout manager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), getResources().getInteger(R.integer.grid_columns));
        binding.categoryGrid.setLayoutManager(gridLayoutManager);
        // Set adapter
        CategoryAdapter adapter = new CategoryAdapter(getContext(), categoryImages, new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.categories))), userSettings);
        binding.categoryGrid.setAdapter(adapter);
        Log.d(TAG, "Category count: " + adapter.getItemCount());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
