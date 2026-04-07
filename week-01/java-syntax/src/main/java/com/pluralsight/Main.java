package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static void main()
    {
        // single line comments

        /*
        multi Line
        comments
         */

        byte age; // creates a 32 bit memory block
        age = 21; // stores the value 21 in that block

        age *= 2;
        System.out.println(age);

        float price; // creates 32 bit memory block that holds a decimal value
        price = 12.5f; // 12.5 is treated as a double, but the f suffix makes it a float


    }

    /**
     *
     * @param name
     */
    public static void displayName(String name)
    {

    }
}
