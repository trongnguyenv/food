package com.project.food.models;

import org.parceler.Parcel;

@Parcel
public class Nutrients {
    private Double CHOCDF;
    private Double ENERC_KCAL;
    private Double FAT;
    private Double FIBTG;
    private Double PROCNT;

    public Nutrients() {
    }

    public Nutrients(Double CHOCDF, Double ENERC_KCAL, Double FAT, Double FIBTG, Double PROCNT) {
        this.CHOCDF = CHOCDF;
        this.ENERC_KCAL = ENERC_KCAL;
        this.FAT = FAT;
        this.FIBTG = FIBTG;
        this.PROCNT = PROCNT;
    }

    public Double getCHOCDF() {
        return CHOCDF;
    }

    public void setCHOCDF(Double CHOCDF) {
        this.CHOCDF = CHOCDF;
    }

    public Double getENERC_KCAL() {
        return ENERC_KCAL;
    }

    public void setENERC_KCAL(Double ENERC_KCAL) {
        this.ENERC_KCAL = ENERC_KCAL;
    }

    public Double getFAT() {
        return FAT;
    }

    public void setFAT(Double FAT) {
        this.FAT = FAT;
    }

    public Double getFIBTG() {
        return FIBTG;
    }

    public void setFIBTG(Double FIBTG) {
        this.FIBTG = FIBTG;
    }

    public Double getPROCNT() {
        return PROCNT;
    }

    public void setPROCNT(Double PROCNT) {
        this.PROCNT = PROCNT;
    }
}
