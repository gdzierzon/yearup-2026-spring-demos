package com.pluralsight;

public class ForLoops
{
    static void main()
    {
        String[] names = {
                "Liam",
                "Olivia",
                "Noah",
                "Emma",
                "Elijah",
                "Ava",
                "Lucas",
                "Sophia",
                "Mason",
                "Isabella"
        };

//        int i = 0;
//        while(i < names.length)
//        {
//            System.out.println(names[i]);
//
//            i++;
//        }

        System.out.println("Print all names in order");
        System.out.println("------------------------");
        // prints all names in order
        for(int j = 0; j < names.length; j++)
        {
            System.out.println(names[j]);
        }
        System.out.println();


        System.out.println("Print every other name - skip first");
        System.out.println("-------------------------------------");
        // prints every other name names in order
        // starting with the 2nd name (int j = 1) - skip the first name
        for(int j = 1; j < names.length; j+= 2)
        {
            System.out.println(names[j]);
        }
        System.out.println();

        System.out.println("Print all names in reverse order");
        System.out.println("--------------------------------");
        // prints all names in reverse order
        // start with last element (names.length - 1)
        // decrements by 1 j--
        for(int j = names.length - 1; j >= 0; j--)
        {
            System.out.println(names[j]);
        }

    }
}
