package com.project.food.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.food.R;
import com.project.food.databinding.ItemFoodListBinding;
import com.project.food.interfaces.ItemOnClickListener;
import com.project.food.models.Food;
import com.project.food.models.Hint;

import java.util.List;
import java.util.Locale;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder>{
    public static final String TAG = FoodListAdapter.class.getSimpleName();
    private final Context context;
    private final List<Hint> hints;
    private final ItemOnClickListener listener;

    public FoodListAdapter(Context context, List<Hint> hints, ItemOnClickListener listener) {
        this.context = context;
        this.hints = hints;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodListViewHolder(ItemFoodListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListViewHolder holder, int position) {
        Food food = hints.get(position).getFood();
        holder.bindFood(food);
        holder.binding.getRoot().setOnClickListener(view -> {
            listener.onClick(hints.get(position), food.getIsSaved());
            Log.d(TAG, "Saved status: " + food.getIsSaved());
        });
    }

    @Override
    public int getItemCount() {
        return hints.size();
    }
    public static class FoodListViewHolder extends RecyclerView.ViewHolder {
        private final ItemFoodListBinding binding;
        private final Context context;

        public FoodListViewHolder(ItemFoodListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = binding.getRoot().getContext();
        }

        private void bindFood(Food food) {
            Glide.with(context).asBitmap().load(food.getImage()).placeholder(R.drawable.brunch_dining).into(binding.recipeImageView);
            binding.foodLabel.setText(food.getLabel());
            binding.calorie.setText("Calorie: " + String.format(Locale.ENGLISH, "%.2f", food.getNutrients().getENERC_KCAL()));
            binding.protein.setText("Protein: " + String.format(Locale.ENGLISH, "%.2f", food.getNutrients().getPROCNT()));
            binding.carbohydrate.setText("Carbohydrate: " + String.format(Locale.ENGLISH, "%.2f", food.getNutrients().getCHOCDF()));
            binding.fat.setText("Fat: " + String.format(Locale.ENGLISH, "%.2f", food.getNutrients().getFAT()));
        }
    }
}
