package com.pluralsight.models;

public class Sheep extends FarmAnimal
{
    public Sheep()
    {
        super("Sheep", "baa!");
    }

    @Override
    public void eat()
    {
        System.out.println(getName() + " chews grass and weeds");
    }
}
