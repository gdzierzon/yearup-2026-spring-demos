package com.pluralsight.models;

public abstract class FarmAnimal
{
    private String name;
    private String sound;

    public FarmAnimal(String name, String sound)
    {
        this.name = name;
        this.sound = sound;
    }

    public String getName()
    {
        return name;
    }

    public String getSound()
    {
        return sound;
    }

    public abstract void eat();

}
