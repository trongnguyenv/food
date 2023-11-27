
package com.project.food.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Images {

    @SerializedName("THUMBNAIL")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("SMALL")
    @Expose
    private Small small;
    @SerializedName("REGULAR")
    @Expose
    private Regular regular;
    @SerializedName("LARGE")
    @Expose
    private Large large;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Images() {
    }

    /**
     * 
     * @param small
     * @param thumbnail
     * @param large
     * @param regular
     */
    public Images(Thumbnail thumbnail, Small small, Regular regular, Large large) {
        super();
        this.thumbnail = thumbnail;
        this.small = small;
        this.regular = regular;
        this.large = large;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Regular getRegular() {
        return regular;
    }

    public void setRegular(Regular regular) {
        this.regular = regular;
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

}
