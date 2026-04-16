package com.pluralsight;


import java.util.Scanner;

public class Main
{
    static void main()
    {
        // Person - 1st one = the datatype to store in memory
        Person person = getNewPerson();

        person.work();
        person.work();
        person.work();
        person.work();

        person.sleep(2);

        System.out.printf("%s has %d %% energy",
                person.getName(),
                person.getEnergy()
                );



//
//        Person person2 = new Person();
//        person2.setName("Laura");
//        person2.setAge(24);
//
//        Person[] family = new Person[2];
//        family[0] = person;
//        family[1] = person2;


    }

    public static Person getNewPerson()
    {
        Scanner userInput = new Scanner(System.in);


        System.out.print("Enter your name: ");
        String name = userInput.nextLine().trim();

        System.out.print("Enter your age: ");
        int age = userInput.nextInt();
        userInput.nextLine();

        Person person;
        person = new Person(name, age);

        person = new Person();
        person.setName(name);
        person.setAge(age);

        return person;
    }
}
