package com.pluralsight.models;

public class MetalSummary
{
    private String name;
    private String symbol;
    private int atomicNumber;
    private String color;

    public MetalSummary()
    {
    }

    public MetalSummary(String name, String symbol, int atomicNumber, String color)
    {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
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

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
}
