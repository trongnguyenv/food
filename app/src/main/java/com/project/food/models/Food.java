package com.project.food.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Objects;

@Parcel
public class Food {
    private String foodId;
    private String label;
    private String knownAs;
    private Nutrients nutrients;
    private String category;
    private String categoryLabel;
    private String image;

    private String brand;
    private String foodContentsLabel;
    private ArrayList<ServingSize> servingSizes;
    private float servingsPerContainer;
    private boolean isSaved;

    public Food() { }

    public Food(String foodId, String label, String knownAs, Nutrients nutrients, String category, String categoryLabel, String image, String brand, String foodContentsLabel, ArrayList<ServingSize> servingSizes, float servingsPerContainer) {
        this.foodId = foodId;
        this.label = label;
        this.knownAs = knownAs;
        this.nutrients = nutrients;
        this.category = category;
        this.categoryLabel = categoryLabel;
        this.image = image;
        this.brand = brand;
        this.foodContentsLabel = foodContentsLabel;
        this.servingSizes = servingSizes;
        this.servingsPerContainer = servingsPerContainer;
        this.isSaved = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Food)) {
            return false;
        } else {
            Food food = (Food) o;
            return Objects.equals(foodId, food.foodId)
                    && Objects.equals(label, food.label)
                    && Objects.equals(knownAs, food.knownAs)
                    && Objects.equals(nutrients, food.nutrients)
                    && Objects.equals(category, food.category)
                    && Objects.equals(categoryLabel, food.categoryLabel)
                    && Objects.equals(image, food.image);
        }
    }

    @Override
    public String toString() {
        String string = "{";

        if (foodId != null) {
            string += "\"foodId\":\"" + foodId + "\",";
        }
        if (label != null) {
            string += "\"label\":\"" + label + "\",";
        }
        if (knownAs != null) {
            string += "\"knownAs\":\"" + knownAs + "\",";
        }
        if (nutrients != null) {
            string += "\"nutrients\":" + nutrients + ",";
        }
        if (category != null) {
            string += "\"category\":\"" + category + "\",";
        }
        if (categoryLabel != null) {
            string += "\"categoryLabel\":\"" + categoryLabel + "\",";
        }
        if (image != null) {
            string += "\"image\":\"" + image + "\",";
        }

        if (string.length() > 1) {
            string = string.substring(0, string.length() - 1);
        }

        string += "}";

        return string;
    }
    public String getFoodId() { return foodId; }
    public String getLabel() { return label; }
    public String getKnownAs() { return knownAs; }
    public Nutrients getNutrients() { return nutrients; }
    public String getCategory() { return category; }
    public String getCategoryLabel() { return categoryLabel; }
    public String getImage() { return image; }
    public void setFoodId(String foodID) { this.foodId = foodID; }
    public void setLabel(String label) { this.label = label; }
    public void setKnownAs(String knownAs) { this.knownAs = knownAs; }
    public void setNutrients(Nutrients nutrients) { this.nutrients = nutrients; }
    public void setCategory(String category) { this.category = category; }
    public void setCategoryLabel(String categoryLabel) { this.categoryLabel = categoryLabel; }
    public void setImage(String image) { this.image = image; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getFoodContentsLabel() { return foodContentsLabel; }
    public void setFoodContentsLabel(String foodContentsLabel) { this.foodContentsLabel = foodContentsLabel; }
    public ArrayList<ServingSize> getServingSizes() { return servingSizes; }
    public void setServingSizes(ArrayList<ServingSize> servingSizes) { this.servingSizes = servingSizes; }
    public float getServingsPerContainer() { return servingsPerContainer; }
    public void setServingsPerContainer(float servingsPerContainer) { this.servingsPerContainer = servingsPerContainer; }
    public boolean getIsSaved() {
        return isSaved;
    }
}
