package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static void main()
    {

        absoluteValue();



    }

    public static void squareRootAndStaticDemo()
    {

        String name = new String("test");
        // String.length(); is not possible because length() is not static
        int wordlength = name.length();

        // this is useless code - because all functions are static
        // so there is NOTHING I can do with the myMath variable
        // everything must go through the Math keyword
        Math myMath ;

        double  square = 5.0;
        // Math.sqrt() is static so we MUST use Math. to access the function
        float squareRoot = (float)Math.sqrt(square);
        System.out.println(squareRoot);
    }

    public static void displayName()
    {
        // declare variables
        Scanner userInput = new Scanner(System.in);
        String name;

        // do the work
        System.out.print("What is your name? ");
        name = userInput.nextLine();

        // display output
        System.out.printf("Hello %s!", name);
    }

    public static void absoluteValue()
    {
        // declare variables
        Scanner input = new Scanner(System.in);
        int originalNumber, absoluteValue;

        // get user input
        System.out.print("Enter a whole number (positive or negative): ");
        originalNumber = input.nextInt();

        // calculate the absolute value

        // using the Math.abs function
        absoluteValue = Math.abs(originalNumber);

        // using an if statement
        if(originalNumber < 0)
        {
            absoluteValue = -originalNumber;
        }
        else {
            absoluteValue = originalNumber;
        }

        // same thing using a ternary operator ?:
        absoluteValue = (originalNumber < 0)
                        ? -originalNumber
                        : originalNumber;

        // display the absolute value
        System.out.printf("The absolute value of %d is %d.\n", originalNumber, absoluteValue);
    }
}
