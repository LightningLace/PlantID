package com.alacey.plantid;

/**
 * Created by Ariah on 10/6/2015.
 */
public class Plant {
    private int id;
    private String commonName;
    private String sciName;
    private String family;
    private String symmetry;
    private int numParts;
    private String leafShape;
    private String leafPattern;
    private String color;
    private String season;
    private int region;


    public Plant(){}

    public Plant(int id, String commonName, String sciName, String family, String symmetry,
                 int numParts, String leafShape, String leafPattern, String color,
                 String season, int region) {
        super();
        this.commonName = commonName;
        this.sciName = sciName;
        this.family = family;
        this.symmetry = symmetry;
        this.numParts = numParts;
        this.leafShape = leafShape;
        this.leafPattern = leafPattern;
        this.color = color;
        this.season = season;
        this.region = region;
    }

    /*
     *   ~~~METHODS~~~
     */
    @Override
    public String toString() {
        return "Plant [id=" + id + ", commonName=" + commonName + ", sciName=" + sciName
                + ", family=" + family + ", symmetry=" + symmetry + "numParts=" + numParts
                + ", leafShape=" + leafShape + ", leafPattern=" + leafPattern + ", color="
                + color + ", season=" + season + ", region=" + region + "]";
    }

    //Getters
    public int getId() {
        return this.id;
    }
    public String getCommonName() {
        return this.commonName;
    }
    public String getSciName() {
        return this.sciName;
    }
    public String getFamily() {
        return this.family;
    }
    public String getSymmetry() {
        return this.symmetry;
    }
    public int getNumParts() {
        return this.numParts;
    }
    public String getLeafShape() {
        return this.leafShape;
    }
    public String getLeafPattern() {
        return this.leafPattern;
    }
    public String getColor() {
        return this.color;
    }
    public String getSeason() {
        return this.season;
    }
    public int getRegion() {
        return this.region;
    }

    //Setters

    public void setId(int newId) {
        this.id = newId;
    }
    public void setCommonName(String newCommonName) {
        this.commonName = newCommonName;
    }
    public void setSciName(String newSciName) {
        this.sciName = newSciName;
    }
    public void setFamily(String newFamily) {
        this.family = newFamily;
    }
    public void setSymmetry(String newSymmetry) {
        this.symmetry = newSymmetry;
    }
    public void setNumParts(int newNumParts) {
        this.numParts = newNumParts;
    }
    public void setLeafShape(String newLeafShape) {
        this.leafShape = newLeafShape;
    }
    public void setLeafPattern(String newLeafPattern) {
        this.leafPattern = newLeafPattern;
    }
    public void setColor(String newColor) {
        this.color = newColor;
    }
    public void setSeason(String newSeason) {
        this.season = newSeason;
    }
    public void setRegion(int newRegion) {
        this.region = newRegion;
    }



}
