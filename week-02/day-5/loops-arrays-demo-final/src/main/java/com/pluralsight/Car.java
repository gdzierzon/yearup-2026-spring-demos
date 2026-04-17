package com.pluralsight;


/*
Create a Car class with the following information

variables:
make
model
miles (this is the odometer reading)
color

constructors:
create a parameterless constructor
create a constructor that accepts all parameters

getters/setters:
all variables should have getters and/or setters
miles should be READONLY (no setter)

methods:
add a method with the following signature
    public void drive(int miles)
    -- this method should increase the odometer reading

 */
public class Car
{
    // private variables here
    private String make;
    private String model;
    private int miles;
    private String color;


    // constructors here

    public Car()
    {
        make = "";
        model = "";
        miles = 0;
        color = "";
    }

    public Car(String make, String model, int miles, String color)
    {
        this.make = make;
        this.model = model;
        this.miles = miles;
        this.color = color;
    }


    // getters and setters here

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getMiles()
    {
        return miles;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }


    // public methods here
    public void drive(int miles)
    {
        this.miles += miles;
    }


}
