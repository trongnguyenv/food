package com.project.food.models;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Settings {
    private String name;
    private List<String> healths;
    private List<String> preferences;

    public Settings() {
    }

    public Settings(String name, List<String> diets, List<String> preferences) {
        this.name = name;
        this.healths = diets;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHealths() {
        return healths;
    }

    public void setHealths(List<String> healths) {
        this.healths = healths;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }
}
