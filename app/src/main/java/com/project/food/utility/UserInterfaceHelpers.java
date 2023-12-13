package com.project.food.utility;

import static android.view.View.*;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputLayout;

import com.project.food.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserInterfaceHelpers {
    // Retrieve selected chips and their corresponding labels
    public static List<String> getSelectedChips(ChipGroup chipGroup){
        List<Integer> selectedChips = chipGroup.getCheckedChipIds();
        ArrayList<String> selectedOptions = new ArrayList<>();

        for(int selectedChip: selectedChips){
            Chip chip = chipGroup.findViewById(selectedChip);
            // Transform string to match allowed API query parameter values
            String transformed = transformString(chip.getText().toString());
            selectedOptions.add(transformed);
        }

        return selectedOptions;
    }

    private static String transformString(String selection){
        // Transform to an array
        String[] stringArray = selection.toLowerCase().split(" ");
        // Join array to string with hyphen
        return TextUtils.join("-", stringArray);
    }

    public static void clearFormInput(TextInputLayout textInputLayout){
        Objects.requireNonNull(textInputLayout.getEditText()).setText("");
    }

    public static void clearFormInput(ChipGroup chipGroup){
        chipGroup.clearCheck();
    }

    public static void hideProgressDialog(ProgressBar progressBar, TextView textView){
        progressBar.setVisibility(GONE);
        textView.setVisibility(GONE);
    }

    public static void showProgressDialog(ProgressBar progressBar, TextView textView) {
        progressBar.setVisibility(VISIBLE);
        textView.setVisibility(VISIBLE);
    }

    public static void showFoods(RecyclerView recyclerView){
        recyclerView.setVisibility(VISIBLE);
    }

    public static void showFoodDetails(ImageView imageView, Group group){
        imageView.setVisibility(VISIBLE);
        group.setVisibility(VISIBLE);
    }

    public static void showUnsuccessfulFeedback(TextView textView, Context context){
        textView.setText(context.getString(R.string.unsuccessful_feedback));
        textView.setVisibility(VISIBLE);
    }

    public static void showFailureFeedback(TextView textView, Context context){
        textView.setText(context.getString(R.string.failure_feedback));
        textView.setVisibility(VISIBLE);
    }

    public static void showNoContentFound(TextView textView, String message){
        textView.setText(message);
        textView.setVisibility(VISIBLE);
    }
}
