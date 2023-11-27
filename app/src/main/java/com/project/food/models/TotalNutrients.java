
package com.project.food.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class TotalNutrients {

    @SerializedName("ENERC_KCAL")
    @Expose
    private EnercKcal enercKcal;
    @SerializedName("FAT")
    @Expose
    private Fat fat;
    @SerializedName("FASAT")
    @Expose
    private Fasat fasat;
    @SerializedName("FATRN")
    @Expose
    private Fatrn fatrn;
    @SerializedName("FAMS")
    @Expose
    private Fams fams;
    @SerializedName("FAPU")
    @Expose
    private Fapu fapu;
    @SerializedName("CHOCDF")
    @Expose
    private Chocdf chocdf;
    @SerializedName("CHOCDF.net")
    @Expose
    private CHOCDFNet cHOCDFNet;
    @SerializedName("FIBTG")
    @Expose
    private Fibtg fibtg;
    @SerializedName("SUGAR")
    @Expose
    private Sugar sugar;
    @SerializedName("SUGAR.added")
    @Expose
    private SUGARAdded sUGARAdded;
    @SerializedName("PROCNT")
    @Expose
    private Procnt procnt;
    @SerializedName("CHOLE")
    @Expose
    private Chole chole;
    @SerializedName("NA")
    @Expose
    private Na na;
    @SerializedName("CA")
    @Expose
    private Ca ca;
    @SerializedName("MG")
    @Expose
    private Mg mg;
    @SerializedName("K")
    @Expose
    private K k;
    @SerializedName("FE")
    @Expose
    private Fe fe;
    @SerializedName("ZN")
    @Expose
    private Zn zn;
    @SerializedName("P")
    @Expose
    private P p;
    @SerializedName("VITA_RAE")
    @Expose
    private VitaRae vitaRae;
    @SerializedName("VITC")
    @Expose
    private Vitc vitc;
    @SerializedName("THIA")
    @Expose
    private Thia thia;
    @SerializedName("RIBF")
    @Expose
    private Ribf ribf;
    @SerializedName("NIA")
    @Expose
    private Nia nia;
    @SerializedName("VITB6A")
    @Expose
    private Vitb6a vitb6a;
    @SerializedName("FOLDFE")
    @Expose
    private Foldfe foldfe;
    @SerializedName("FOLFD")
    @Expose
    private Folfd folfd;
    @SerializedName("FOLAC")
    @Expose
    private Folac folac;
    @SerializedName("VITB12")
    @Expose
    private Vitb12 vitb12;
    @SerializedName("VITD")
    @Expose
    private Vitd vitd;
    @SerializedName("TOCPHA")
    @Expose
    private Tocpha tocpha;
    @SerializedName("VITK1")
    @Expose
    private Vitk1 vitk1;
    @SerializedName("Sugar.alcohol")
    @Expose
    private SugarAlcohol sugarAlcohol;
    @SerializedName("WATER")
    @Expose
    private Water water;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TotalNutrients() {
    }

    /**
     * 
     * @param fasat
     * @param sugarAlcohol
     * @param enercKcal
     * @param procnt
     * @param chole
     * @param nia
     * @param cHOCDFNet
     * @param vitaRae
     * @param fams
     * @param ribf
     * @param folfd
     * @param vitd
     * @param vitc
     * @param vitb6a
     * @param fat
     * @param mg
     * @param vitb12
     * @param tocpha
     * @param foldfe
     * @param fatrn
     * @param ca
     * @param sUGARAdded
     * @param chocdf
     * @param k
     * @param water
     * @param fapu
     * @param p
     * @param na
     * @param zn
     * @param folac
     * @param vitk1
     * @param thia
     * @param fibtg
     * @param sugar
     * @param fe
     */
    public TotalNutrients(EnercKcal enercKcal, Fat fat, Fasat fasat, Fatrn fatrn, Fams fams, Fapu fapu, Chocdf chocdf, CHOCDFNet cHOCDFNet, Fibtg fibtg, Sugar sugar, SUGARAdded sUGARAdded, Procnt procnt, Chole chole, Na na, Ca ca, Mg mg, K k, Fe fe, Zn zn, P p, VitaRae vitaRae, Vitc vitc, Thia thia, Ribf ribf, Nia nia, Vitb6a vitb6a, Foldfe foldfe, Folfd folfd, Folac folac, Vitb12 vitb12, Vitd vitd, Tocpha tocpha, Vitk1 vitk1, SugarAlcohol sugarAlcohol, Water water) {
        super();
        this.enercKcal = enercKcal;
        this.fat = fat;
        this.fasat = fasat;
        this.fatrn = fatrn;
        this.fams = fams;
        this.fapu = fapu;
        this.chocdf = chocdf;
        this.cHOCDFNet = cHOCDFNet;
        this.fibtg = fibtg;
        this.sugar = sugar;
        this.sUGARAdded = sUGARAdded;
        this.procnt = procnt;
        this.chole = chole;
        this.na = na;
        this.ca = ca;
        this.mg = mg;
        this.k = k;
        this.fe = fe;
        this.zn = zn;
        this.p = p;
        this.vitaRae = vitaRae;
        this.vitc = vitc;
        this.thia = thia;
        this.ribf = ribf;
        this.nia = nia;
        this.vitb6a = vitb6a;
        this.foldfe = foldfe;
        this.folfd = folfd;
        this.folac = folac;
        this.vitb12 = vitb12;
        this.vitd = vitd;
        this.tocpha = tocpha;
        this.vitk1 = vitk1;
        this.sugarAlcohol = sugarAlcohol;
        this.water = water;
    }

    public EnercKcal getEnercKcal() {
        return enercKcal;
    }

    public void setEnercKcal(EnercKcal enercKcal) {
        this.enercKcal = enercKcal;
    }

    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }

    public Fasat getFasat() {
        return fasat;
    }

    public void setFasat(Fasat fasat) {
        this.fasat = fasat;
    }

    public Fatrn getFatrn() {
        return fatrn;
    }

    public void setFatrn(Fatrn fatrn) {
        this.fatrn = fatrn;
    }

    public Fams getFams() {
        return fams;
    }

    public void setFams(Fams fams) {
        this.fams = fams;
    }

    public Fapu getFapu() {
        return fapu;
    }

    public void setFapu(Fapu fapu) {
        this.fapu = fapu;
    }

    public Chocdf getChocdf() {
        return chocdf;
    }

    public void setChocdf(Chocdf chocdf) {
        this.chocdf = chocdf;
    }

    public CHOCDFNet getCHOCDFNet() {
        return cHOCDFNet;
    }

    public void setCHOCDFNet(CHOCDFNet cHOCDFNet) {
        this.cHOCDFNet = cHOCDFNet;
    }

    public Fibtg getFibtg() {
        return fibtg;
    }

    public void setFibtg(Fibtg fibtg) {
        this.fibtg = fibtg;
    }

    public Sugar getSugar() {
        return sugar;
    }

    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }

    public SUGARAdded getSUGARAdded() {
        return sUGARAdded;
    }

    public void setSUGARAdded(SUGARAdded sUGARAdded) {
        this.sUGARAdded = sUGARAdded;
    }

    public Procnt getProcnt() {
        return procnt;
    }

    public void setProcnt(Procnt procnt) {
        this.procnt = procnt;
    }

    public Chole getChole() {
        return chole;
    }

    public void setChole(Chole chole) {
        this.chole = chole;
    }

    public Na getNa() {
        return na;
    }

    public void setNa(Na na) {
        this.na = na;
    }

    public Ca getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    public Mg getMg() {
        return mg;
    }

    public void setMg(Mg mg) {
        this.mg = mg;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public Fe getFe() {
        return fe;
    }

    public void setFe(Fe fe) {
        this.fe = fe;
    }

    public Zn getZn() {
        return zn;
    }

    public void setZn(Zn zn) {
        this.zn = zn;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }

    public VitaRae getVitaRae() {
        return vitaRae;
    }

    public void setVitaRae(VitaRae vitaRae) {
        this.vitaRae = vitaRae;
    }

    public Vitc getVitc() {
        return vitc;
    }

    public void setVitc(Vitc vitc) {
        this.vitc = vitc;
    }

    public Thia getThia() {
        return thia;
    }

    public void setThia(Thia thia) {
        this.thia = thia;
    }

    public Ribf getRibf() {
        return ribf;
    }

    public void setRibf(Ribf ribf) {
        this.ribf = ribf;
    }

    public Nia getNia() {
        return nia;
    }

    public void setNia(Nia nia) {
        this.nia = nia;
    }

    public Vitb6a getVitb6a() {
        return vitb6a;
    }

    public void setVitb6a(Vitb6a vitb6a) {
        this.vitb6a = vitb6a;
    }

    public Foldfe getFoldfe() {
        return foldfe;
    }

    public void setFoldfe(Foldfe foldfe) {
        this.foldfe = foldfe;
    }

    public Folfd getFolfd() {
        return folfd;
    }

    public void setFolfd(Folfd folfd) {
        this.folfd = folfd;
    }

    public Folac getFolac() {
        return folac;
    }

    public void setFolac(Folac folac) {
        this.folac = folac;
    }

    public Vitb12 getVitb12() {
        return vitb12;
    }

    public void setVitb12(Vitb12 vitb12) {
        this.vitb12 = vitb12;
    }

    public Vitd getVitd() {
        return vitd;
    }

    public void setVitd(Vitd vitd) {
        this.vitd = vitd;
    }

    public Tocpha getTocpha() {
        return tocpha;
    }

    public void setTocpha(Tocpha tocpha) {
        this.tocpha = tocpha;
    }

    public Vitk1 getVitk1() {
        return vitk1;
    }

    public void setVitk1(Vitk1 vitk1) {
        this.vitk1 = vitk1;
    }

    public SugarAlcohol getSugarAlcohol() {
        return sugarAlcohol;
    }

    public void setSugarAlcohol(SugarAlcohol sugarAlcohol) {
        this.sugarAlcohol = sugarAlcohol;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

}
