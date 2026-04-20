package com.pluralsight;

public class Metal
{
    private static final int SAFE_UPPER_MELTING_TEMP = 2100;

    private String name;
    private String symbol;
    private int atomicNumber;

    private int meltingPointF;
    private int boilingPointF;

    private String color;
    private double density;
    private String category;
    private String stateAtRoomTemp;

    private boolean isToxic;
    private boolean isMagnetic;

    private Integer pouringTempF; // Integer allows null (for N/A like Mercury)
    private double costPerPound;
    private String commonUses;

    // Default constructor
    public Metal() {
    }

    // Full constructor
    public Metal(String name, String symbol, int atomicNumber,
                 int meltingPointF, int boilingPointF, String color,
                 double density, String category, String stateAtRoomTemp,
                 boolean isToxic, boolean isMagnetic,
                 Integer pouringTempF, double costPerPound,
                 String commonUses) {

        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.meltingPointF = meltingPointF;
        this.boilingPointF = boilingPointF;
        this.color = color;
        this.density = density;
        this.category = category;
        this.stateAtRoomTemp = stateAtRoomTemp;
        this.isToxic = isToxic;
        this.isMagnetic = isMagnetic;
        this.pouringTempF = pouringTempF;
        this.costPerPound = costPerPound;
        this.commonUses = commonUses;
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

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStateAtRoomTemp() {
        return stateAtRoomTemp;
    }

    public void setStateAtRoomTemp(String stateAtRoomTemp) {
        this.stateAtRoomTemp = stateAtRoomTemp;
    }

    public boolean isToxic() {
        return isToxic;
    }

    public void setToxic(boolean toxic) {
        isToxic = toxic;
    }

    public boolean isMagnetic() {
        return isMagnetic;
    }

    public void setMagnetic(boolean magnetic) {
        isMagnetic = magnetic;
    }

    public Integer getPouringTempF() {
        return pouringTempF;
    }

    public void setPouringTempF(Integer pouringTempF) {
        this.pouringTempF = pouringTempF;
    }

    public double getCostPerPound() {
        return costPerPound;
    }

    public void setCostPerPound(double costPerPound) {
        this.costPerPound = costPerPound;
    }

    public String getCommonUses() {
        return commonUses;
    }

    public void setCommonUses(String commonUses) {
        this.commonUses = commonUses;
    }


    // derived getters
    public int getLiquidStateRange()
    {
        return boilingPointF - meltingPointF;
    }

    public boolean isSafeToMelt()
    {
        boolean isTempSafe = SAFE_UPPER_MELTING_TEMP >= pouringTempF;

        return isTempSafe && !isToxic;
    }

    public String toString()
    {
        return String.format("%s - $s (%d)\nMelts at %d °", name, symbol, atomicNumber, meltingPointF);
    }
}
