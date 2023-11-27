package com.project.food.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.project.food.databinding.ItemSavedRecipeListBinding;
import com.project.food.interfaces.ItemOnClickListener;
import com.project.food.models.Recipe;
import com.project.food.utility.gestures.AppItemTouchHelper;
import com.project.food.utility.gestures.OnTouchScreenDragListener;
import com.project.food.viewholder.FirebaseRecipeViewHolder;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseRecipeListAdapter extends FirebaseRecyclerAdapter<Recipe, FirebaseRecipeViewHolder> implements AppItemTouchHelper {
    public static final String TAG = FirebaseRecipeListAdapter.class.getSimpleName();
    private final DatabaseReference databaseReference;
    private final OnTouchScreenDragListener dragListener;
    private final Context context;
    private final ChildEventListener childEventListener;
    private final ArrayList<Recipe> recipes = new ArrayList<>();
    private final ItemOnClickListener itemOnClickListener;

    public FirebaseRecipeListAdapter(@NonNull FirebaseRecyclerOptions<Recipe> options, DatabaseReference databaseReference, OnTouchScreenDragListener dragListener, Context context, ItemOnClickListener itemOnClickListener) {
        super(options);
        this.databaseReference = databaseReference;
        this.dragListener = dragListener;
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;

        this.childEventListener = databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                recipes.add(snapshot.getValue(Recipe.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    // TO FIND A BETTER SOLUTION
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onBindViewHolder(@NonNull FirebaseRecipeViewHolder holder, int position, @NonNull Recipe recipe) {
        holder.bindRecipe(recipe);

        // Add TouchListener to listen for drag events when user touches drag icon
        holder.binding.iconDrag.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN){
                dragListener.onDrag(holder);
            }
            return true;
        });

        holder.binding.getRoot().setOnClickListener(view -> {
            String uri = recipe.getUri();
            // Set isSaved property to determine 'Save' button display in RecipeDetailsFragment
            recipe.setIsSaved(true);
            // Extract recipe ID from recipe's URI
            String recipeId = uri.substring(uri.indexOf("#") + 1);
            itemOnClickListener.onClick(recipeId, recipe.getIsSaved());
            Log.d(TAG, "Saved status: " + recipe.getIsSaved());
        });
    }

    @NonNull
    @Override
    public FirebaseRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FirebaseRecipeViewHolder(ItemSavedRecipeListBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public boolean onItemMoved(int startPosition, int endPosition) {
        Collections.swap(recipes, startPosition, endPosition);
        notifyItemMoved(startPosition, endPosition);
        setFirebaseIndex();
        return true;
    }

    @Override
    public void onItemSwiped(int position) {
        recipes.remove(position);
        getRef(position).removeValue();
    }

    private void setFirebaseIndex(){
        for (Recipe recipe: recipes){
            int index = recipes.indexOf(recipe);
            DatabaseReference reference = getRef(index);
            recipe.setIndex(Integer.toString(index));
            reference.setValue(recipe);
        }
    }

    @Override
    public void stopListening() {
        super.stopListening();
        this.databaseReference.removeEventListener(childEventListener);
    }
}
