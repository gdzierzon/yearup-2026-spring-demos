package com.pluralsight;

public class Car
{

    // private variables
    private String make;
    private String model;
    private int speed = 0;

    // constructors
    public Car(String make, String model)
    {
        this.make = make;
        this.model = model;
    }

    // public properties
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

    public int getSpeed()
    {
        return speed;
    }

    // methods
    public void accelerate(int changeInSpeed)
    {
        // rev the engine, peel the tires
        this.speed += changeInSpeed;
        if(this.speed > 150) this.speed = 150;
    }

    public void brake(int changeInSpeed)
    {
        // code to burn off som brake pad
        this.speed -= changeInSpeed;
        if(speed < 0) speed = 0;
    }
}
