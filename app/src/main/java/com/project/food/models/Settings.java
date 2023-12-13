package com.project.food.models;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Settings {
    private String name;
    private List<String> diets;
    private List<String> preferences;

    public Settings() {
    }

    public Settings(String name, List<String> diets, List<String> preferences) {
        this.name = name;
        this.diets = diets;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDiets() {
        return diets;
    }

    public void setDiets(List<String> diets) {
        this.diets = diets;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }
}
