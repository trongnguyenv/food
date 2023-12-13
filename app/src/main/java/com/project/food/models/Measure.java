package com.project.food.models;

import com.google.firebase.components.Qualified;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Measure {
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("weight")
    @Expose
    private float weight;
    @SerializedName("qualified")
    @Expose
    private ArrayList<Qualified> qualified;

    public Measure() {
        this.uri = "";
        this.label = "";
        this.weight = 0;
        this.qualified = new ArrayList<>();
    }
    public Measure(String uri, String label, float weight) {
        this.uri = uri;
        this.label = label;
        this.weight = weight;
        this.qualified = new ArrayList<>();
    }
    public Measure(String uri, String label, float weight, ArrayList<Qualified> qualified) {
        this.uri = uri;
        this.label = label;
        this.weight = weight;
        this.qualified = qualified;
    }
    public Measure(Measure measure) {
        this.uri = measure.uri;
        this.label = measure.label;
        this.weight = measure.weight;
        this.qualified = measure.qualified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Measure)) {
            return false;
        } else {
            Measure measure = (Measure) o;
            return weight == measure.weight && uri.equals(measure.uri) && label.equals(measure.label) && qualified.equals(measure.qualified);
        }
    }

    @Override
    public String toString() {
        String string = "{" +
                "\"uri\":\"" + uri + "\"," +
                "\"label\":\"" + label + "\"," +
                "\"weight\":" + weight + ",";

        if (qualified != null && qualified.size() > 0) {
            string += "\"qualified\":" + qualified + ",";
        }

        string = string.substring(0, string.length() - 1);
        string += "}";

        return string;
    }

    public String getUri() { return uri; }
    public String getLabel() { return label; }
    public float getWeight() { return weight; }
    public ArrayList<Qualified> getQualified() { return qualified; }

    public void setUri(String uri) { this.uri = uri; }
    public void setLabel(String label) { this.label = label; }
    public void setWeight(float weight) { this.weight = weight; }
    public void setQualified(ArrayList<Qualified> qualified) { this.qualified = qualified; }
}
