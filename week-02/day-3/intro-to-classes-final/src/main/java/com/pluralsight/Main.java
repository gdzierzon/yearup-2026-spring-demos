package com.pluralsight;


public class Main
{
    static void main()
    {
        // Person - 1st one = the datatype to store in memory


        Person person;
        person = new Person();
        person.setName("Joe");
        person.setAge(25);

        Person person2 = new Person();
        person2.setName("Laura");
        person2.setAge(24);

        Person[] family = new Person[2];
        family[0] = person;
        family[1] = person2;


    }
}
