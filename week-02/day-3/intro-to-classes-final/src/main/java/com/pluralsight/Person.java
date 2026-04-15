package com.pluralsight;

public class Person
{
    // instance variables
    // each person has their own Name and Age
    private String name = "";
    private int age = 0;

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
}
