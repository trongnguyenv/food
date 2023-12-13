package com.project.food.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class FoodResponse {
    @SerializedName("hints")
    @Expose
    private ArrayList<Hint> hints = null;
    private String text;
    private ArrayList<Parsed> parsed;
    private Link _links;
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof FoodResponse)) {
            return false;
        } else {
            FoodResponse that = (FoodResponse) o;
            return text.equals(that.text) && parsed.equals(that.parsed) && hints.equals(that.hints) && _links.equals(that._links);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"text\":\"" + text + "\"," +
                "\"parsed\":" + parsed + "," +
                "\"hints\":" + hints + "," +
                "\"_links\":" + _links +
                "}";
    }

    public String getText() { return text; }
    public ArrayList<Parsed> getParsed() { return parsed; }
    public ArrayList<Hint> getHints() { return hints; }
    public Link get_links() { return _links; }
    public void setText(String text) { this.text = text; }
    public void setParsed(ArrayList<Parsed> parsed) { this.parsed = parsed; }
    public void setHints(ArrayList<Hint> hints) { this.hints = hints; }
    public void set_links(Link _links) { this._links = _links; }
}
