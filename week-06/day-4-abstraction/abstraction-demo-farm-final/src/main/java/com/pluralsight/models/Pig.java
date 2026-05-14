package com.pluralsight.models;


public class Pig extends FarmAnimal
{
    public Pig()
    {
        super("Pig", "oink!");
    }

    @Override
    public void eat()
    {
        System.out.println(getName() + " slurps slop");
    }
}
