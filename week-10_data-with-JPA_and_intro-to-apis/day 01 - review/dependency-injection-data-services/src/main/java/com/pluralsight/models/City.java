package com.pluralsight.models;

// Java Bean = DTO (Data Transfer Object)
public class City
{
    private int id;
    private String name;
    private String country;
    private String state;
    private int population;

    public City(int id, String name, String country, String state, int population)
    {
        this.id = id;
        this.name = name;
        this.country = country;
        this.state = state;
        this.population = population;
    }

    public City()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }
}
