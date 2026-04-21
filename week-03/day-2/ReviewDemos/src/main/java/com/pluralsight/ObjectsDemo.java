package com.pluralsight;

public class ObjectsDemo
{
    // static void main is the ENTRY POINT into the application
    static void main()
    {
        Person ariel = new Person();
        Person abeer = new Person();

        ariel.setName("Ariel");
        ariel.setAge(25);

        System.out.println(Person.getPersonCount());


        displayHomeScreen();
    }

    public static void displayHomeScreen()
    {

    }
}
