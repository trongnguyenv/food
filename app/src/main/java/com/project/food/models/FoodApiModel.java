package com.project.food.models;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class FoodApiModel {
    private List<Hint> hints;
    private String searchText;

    public FoodApiModel() {
    }

    public FoodApiModel(List<Hint> hints, String searchText) {
        this.hints = hints;
        this.searchText = searchText;
    }
}
