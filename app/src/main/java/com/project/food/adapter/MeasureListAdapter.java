package com.project.food.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.food.R;
import com.project.food.databinding.ItemIngredientListBinding;
import com.project.food.models.Measure;

import java.util.List;
import java.util.Locale;

public class MeasureListAdapter extends RecyclerView.Adapter<MeasureListAdapter.MeasureListViewHolder>{
    private final Context context;
    private final List<Measure> measures;
    private String image;

    public MeasureListAdapter(Context context, List<Measure> measures, String image) {
        this.context = context;
        this.measures = measures;
        this.image = image;
    }

    @NonNull
    @Override
    public MeasureListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeasureListViewHolder(ItemIngredientListBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeasureListViewHolder holder, int position) {
        holder.bindIngredient(measures.get(position), image);
    }

    @Override
    public int getItemCount() {
        return measures.size();
    }

    public static class MeasureListViewHolder extends RecyclerView.ViewHolder {
        private final ItemIngredientListBinding binding;
        private final Context context;

        public MeasureListViewHolder(ItemIngredientListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = binding.getRoot().getContext();
        }

        private void bindIngredient(Measure measure, String image) {
            Glide.with(context).asBitmap().load(image).placeholder(R.drawable.brunch_dining).into(binding.ingredientImageView);
            binding.ingredientLabel.setText(measure.getLabel());
            binding.ingredientQuantity.setText(String.format(Locale.ENGLISH, "%.2f", measure.getWeight()));
        }
    }
}
