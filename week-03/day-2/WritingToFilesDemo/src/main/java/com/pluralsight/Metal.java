package com.pluralsight;

import java.util.regex.Pattern;

public class Metal
{
    private String name;
    private String symbol;
    private int atomicNumber;
    private double meltingPoint;
    private double boilingPoint;
    private String color;

    public Metal()
    {
    }

    public Metal(String name, String symbol, int atomicNumber, double meltingPoint, double boilingPoint, String color)
    {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.color = color;
    }

    public Metal(String line)
    {
        String[] parts = line.split(Pattern.quote("|"));

        String name = parts[0];
        String symbol = parts[1];
        int atomicNumber = Integer.parseInt(parts[2]);
        double meltingPoint = Double.parseDouble(parts[3]);
        double boilingPoint = Double.parseDouble(parts[4]);
        String color = parts[5];

        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
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

    public double getMeltingPoint()
    {
        return meltingPoint;
    }

    public void setMeltingPoint(double meltingPoint)
    {
        this.meltingPoint = meltingPoint;
    }

    public double getBoilingPoint()
    {
        return boilingPoint;
    }

    public void setBoilingPoint(double boilingPoint)
    {
        this.boilingPoint = boilingPoint;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public double getLiquidRange()
    {
        return boilingPoint - meltingPoint;
    }

    public double getPouringTemp()
    {
        return meltingPoint + getLiquidRange()/2;
    }
}
