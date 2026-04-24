package com.pluralsight;

public class Metal
{
    private String name;
    private String symbol;
    private int atomicNumber;
    private int meltingTemperature;
    private int boilingTemperature;
    private String color;

    public Metal(String name, String symbol, int atomicNumber, int meltingTemperature, int boilingTemperature, String color)
    {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.meltingTemperature = meltingTemperature;
        this.boilingTemperature = boilingTemperature;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public int getAtomicNumber()
    {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber)
    {
        this.atomicNumber = atomicNumber;
    }

    public int getMeltingTemperature()
    {
        return meltingTemperature;
    }

    public void setMeltingTemperature(int meltingTemperature)
    {
        this.meltingTemperature = meltingTemperature;
    }

    public int getBoilingTemperature()
    {
        return boilingTemperature;
    }

    public void setBoilingTemperature(int boilingTemperature)
    {
        this.boilingTemperature = boilingTemperature;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
}
