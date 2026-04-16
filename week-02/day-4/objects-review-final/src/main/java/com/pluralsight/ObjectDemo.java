package com.pluralsight;

public class ObjectDemo
{
    static void main()
    {
        Hotel hotel = new Hotel();
        hotel.setName("Hilton");

        System.out.println(hotel.getName());

        System.out.println();

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        System.out.println("Welcome " + person.getFullName());
    }
}
