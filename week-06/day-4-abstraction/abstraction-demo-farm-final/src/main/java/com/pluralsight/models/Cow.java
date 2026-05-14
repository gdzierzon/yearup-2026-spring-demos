package com.pluralsight.models;

public class Cow extends FarmAnimal
{

    boolean isEating = false;

    public Cow()
    {
        super("Cow", "moo!");
    }

    public boolean isEating()
    {
        return isEating;
    }

    public void setEating(boolean eating)
    {
        isEating = eating;
    }

    @Override
    public String getSound()
    {
        if(isEating())
        {
            return "mmmf";
        }

        return super.getSound();
    }

    @Override
    public void eat()
    {
        System.out.println(getName() + " chews cud");
        isEating = true;
    }
}
