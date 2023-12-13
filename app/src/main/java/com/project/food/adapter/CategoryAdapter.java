package com.project.food.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.food.FoodListActivity;
import com.project.food.databinding.ItemCategoryBinding;
import com.project.food.models.Settings;
import com.project.food.utility.Constants;

import org.parceler.Parcels;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private final Context context;
    private final List<Integer> categoriesImages;
    private final List<String> categoriesLabels;
    private final Settings userSettings;
    public CategoryAdapter(Context context, List<Integer> categoriesImages, List<String> categoriesLabels, Settings userSettings) {
        this.context = context;
        this.categoriesImages = categoriesImages;
        this.categoriesLabels = categoriesLabels;
        this.userSettings = userSettings;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bindFood(categoriesLabels.get(position), categoriesImages.get(position));
        holder.binding.getRoot().setOnClickListener(view -> {
            Intent intent = new Intent(context, FoodListActivity.class);
            intent.putExtra(Constants.EXTRA_CATEGORIES, categoriesLabels.get(position));
            intent.putExtra(Constants.EXTRA_USER_SETTINGS, Parcels.wrap(userSettings));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categoriesLabels.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final ItemCategoryBinding binding;
        private final Context context;

        public CategoryViewHolder(ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            context = binding.getRoot().getContext();
        }

        private void bindFood(String mealTypeLabel, int mealTypeImage){
            Glide.with(context).asDrawable().load(mealTypeImage).into(binding.mealTypeImageView);
            binding.mealTypeLabel.setText(mealTypeLabel);
        }
    }
}
