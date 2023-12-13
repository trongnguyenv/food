package com.project.food.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.food.databinding.ItemSearchListBinding;

import java.util.List;

public class SeachListAdapter extends RecyclerView.Adapter<SeachListAdapter.SeachListViewHolder>{
    public static final String TAG = SeachListAdapter.class.getSimpleName();
    private final Context context;
    private final List<String> results;

    public SeachListAdapter(Context context, List<String> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public SeachListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SeachListViewHolder(ItemSearchListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SeachListViewHolder holder, int position) {
        String result = results.get(position).toString();
        holder.bindRecipe(result);
        holder.binding.getRoot().setOnClickListener(view -> {
            Log.d(TAG, "result: " + result);
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class SeachListViewHolder extends RecyclerView.ViewHolder {
        private final ItemSearchListBinding binding;
        private final Context context;

        public SeachListViewHolder(ItemSearchListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = binding.getRoot().getContext();
        }

        private void bindRecipe(String result) {
            binding.resultLabel.setText(result);
        }
    }
}
