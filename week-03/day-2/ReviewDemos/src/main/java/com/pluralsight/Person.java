package com.pluralsight;

public class Person
{
    private static int counter = 0;

    private String name;
    private int age;

    public Person()
    {
        counter++;
    }

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

    public static int getPersonCount()
    {
        return counter;
    }
}
