package com.pluralsight;

public class Metal
{

    private String name;
    private String symbol;
    private int atomicNumber;

    private int meltingPointF;
    private int boilingPointF;
    private String color;


    // Default constructor
    public Metal() {
    }

    // Full constructor
    public Metal(String name, String symbol, int atomicNumber,
                 int meltingPointF, int boilingPointF, String color) {

        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.meltingPointF = meltingPointF;
        this.boilingPointF = boilingPointF;
        this.color = color;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public int getMeltingPointF() {
        return meltingPointF;
    }

    public void setMeltingPointF(int meltingPointF) {
        this.meltingPointF = meltingPointF;
    }

    public int getBoilingPointF() {
        return boilingPointF;
    }

    public void setBoilingPointF(int boilingPointF) {
        this.boilingPointF = boilingPointF;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
