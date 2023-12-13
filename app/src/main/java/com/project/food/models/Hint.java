package com.project.food.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Objects;

@Parcel
public class Hint {
    @SerializedName("food")
    @Expose
    private Food food;

    @SerializedName("measures")
    @Expose
    private ArrayList<Measure> measures;

    public Hint() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Hint)) {
            return false;
        } else {
            Hint hint = (Hint) o;
            return Objects.equals(food, hint.food) && Objects.equals(measures, hint.measures);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"food\":" + food + "," +
                "\"measures\":" + measures +
                "}";
    }

    public Hint(Food food, ArrayList<Measure> measures) {
        this.food = food;
        this.measures = measures;
    }

    public Food getFood() {
        return food;
    }
    public ArrayList<Measure> getMeasures() { return measures; }
    public void setFood(Food food) {
        this.food = food;
    }
    public void setMeasures(ArrayList<Measure> measures) { this.measures = measures; }
}
