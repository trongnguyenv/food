package com.project.food.models;

public class FoodFavorite {
    private int id;
    private String data;

    public FoodFavorite(String data, int id) {
        this.data = data;
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
