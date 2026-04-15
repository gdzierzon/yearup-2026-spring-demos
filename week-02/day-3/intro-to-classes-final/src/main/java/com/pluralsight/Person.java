package com.pluralsight;

public class Person
{
    // instance variables
    // each person has their own Name and Age
    private String name = "";
    private int age = 0;
    private int energy = 100;

    // constructors
    public Person()
    {
        name = "";
        age = 0;
        energy = 100;
    }

    public Person(String name, int age)
    {
        // any setup logic that we want to run
        // before the object can be used
        this.name = name;
        this.age = age;
        energy = 100;
    }


    // getters and setters
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public int getEnergy() {
        return energy;
    }

    // public methods
    public void work()
    {
        energy -= 10;
        if(energy < 0) energy = 0;
    }

    public void sleep(int hours)
    {
        energy += (hours * 10);
        if(energy > 100) energy = 100;
    }
}
