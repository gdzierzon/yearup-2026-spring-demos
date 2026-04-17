package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class Exercises
{
    static void main() throws InterruptedException
    {
        // uncomment each exercise as you complete it

        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
        exercise8();
        exercise9();
        exercise10();
        exercise11();
        exercise12();
        exercise13();
        exercise14();
        exercise15();


    }

    // ******************
    // Reading loop logic
    // ******************

    static void exercise1()
    {
        System.out.println();
        System.out.println("1) What does this loop do?");
        // in under 20 words describe the purpose of this loop (in your own words)
        System.out.println("Prints all numbers from 1 to 10");

        for (int i = 0; i < 10; i++)
        {
            System.out.print(i + 1); // since we start at 0 we print (0+1), (1+1), etc
            System.out.print(" ");
        }
        System.out.println();

    }

    static void exercise2()
    {
        System.out.println();
        System.out.println("2) This loop does not print the number 10, how can you fix it?");

        System.out.println("Added = so to i <= 10 so that 10 is included in the list");

        // fix the problem
        for (int i = 1; i <= 10; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    static void exercise3()
    {
        System.out.println();
        System.out.println("3) What does this loop do?");
        // in under 20 words describe the purpose of this loop (in your own words)
        System.out.println("prints all numbers from 10 to 1");

        for (int i = 10; i > 0; i--)
        {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    static void exercise4()
    {
        System.out.println();
        System.out.println("4) What does this loop do?");
        // in under 20 words describe the purpose of this loop (in your own words)
        System.out.println("Prints every other number from 0 to 20, starting at 0");

        for (int i = 0; i <= 20; i+= 2)
        {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    static void exercise5()
    {
        System.out.println();
        System.out.println("5) What does this loop do?");
        // in under 20 words describe the purpose of this loop (in your own words)
        System.out.println("Prints all even numbers between 0 and 20");

        for (int i = 0; i <= 20; i++)
        {
            if(i % 2 == 0)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }

    static void exercise6()
    {
        System.out.println();
        System.out.println("6) What does this loop do?");
        // in under 20 words describe the purpose of this loop (in your own words)
        System.out.println("Prints the first odd number and then exits the loop");

        int[] numbers = {2, 4, 24, 13, 28, 4, 21 };

        for (int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] % 2 == 1)
            {
                System.out.println(numbers[i]);
                break; // exits the loop
            }
        }

    }

    static void exercise7()
    {
        System.out.println();
        System.out.println("7) What does this loop do?");
        // in under 20 words describe the purpose of this loop (in your own words)
        System.out.println("Skips all even numbers in the loop - and only prints the odd numbers");

        int[] numbers = {2, 4, 24, 13, 28, 4, 21 };

        for (int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] % 2 == 0)
            {
                continue;
            }
            System.out.println(numbers[i]);
        }

    }

    // ******************
    // Writing loop logic
    // ******************

    static void exercise8() throws InterruptedException
    {
        System.out.println();
        System.out.println("8) This is an infinite loop, how can you fix it?");

        System.out.println("Added user input (inside the loop) to see if they want to keep looping.");

        Scanner userInput = new Scanner(System.in);
        String goAgain = "y";

        // fix the problem
        while (goAgain.equalsIgnoreCase("y"))
        {
            Thread.sleep(500); // this just simulates a long running process so we are not looping a million times a second
            System.out.println("I'm still working");

            // added user prompt here
            System.out.print("Do you want to keep going? (y/n) ");
            goAgain = userInput.nextLine().trim();
        }

    }


    static void exercise9()
    {
        System.out.println();
        System.out.println("9) Write a loop that prints all numbers form 1 to 50");

        // write your loop here
        for (int i = 1; i <= 50; i++)
        {
            System.out.println(i);
        }

    }


    static void exercise10()
    {
        System.out.println();
        System.out.println("10) Write a loop that prints all EVEN numbers form 1 to 50");

        // write your loop here
//        // option 1
//        for (int i = 1; i <= 50; i++)
//        {
//            if(i % 2 == 0) System.out.println(i);
//        }

        // option 2
        for (int i = 2; i <= 50; i+= 2)
        {
            System.out.println(i);
        }

    }

    static void exercise11()
    {
        System.out.println();
        System.out.println("11) Write a loop that prints all numbers form 1 to 50 that are multiples of 5");
        System.out.println("   for example 5, 10, 15 ...");

        // write your loop here
//        // option 1
//        for (int i = 1; i <= 50; i++)
//        {
//            if(i % 5 == 0) System.out.println(i);
//        }

        // option
        for (int i = 5; i <= 50; i+= 5)
        {
            System.out.println(i);
        }

    }

    static void exercise12()
    {
        System.out.println();
        System.out.println("12) Write a loop that searches for the number that the user input. Display whether or not the number was found in the array.");

        int[] numbers = {
                523, 87, 914, 302, 741, 65, 198, 876, 412, 999,
                134, 567, 289, 710, 455, 23, 808, 376, 690, 512,
                940, 61, 777, 284, 659, 118, 903, 447, 732, 256,
                81, 995, 368, 542, 219, 684, 130, 860, 471, 39,
                775, 608, 294, 921, 156, 703, 488, 267, 845, 320
        };

        Scanner userInput = new Scanner(System.in);
        int searchValue;
        boolean wasFound = false;

        System.out.print("Enter a number between 1 and 1000: ");
        searchValue = Integer.parseInt(userInput.nextLine());

        // write your loop here
        for (int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] == searchValue)
            {
                wasFound = true;
                break; // no need to keep looping because we found the number
            }
        }


        // output
        String message = wasFound
                ? " was found"
                : " was not found";

        System.out.println(searchValue + message);

    }


    static void exercise13()
    {
        System.out.println();
        System.out.println("13) Write a loop that counts how many even numbers there are in the array. Display the count of even numbers");

        int[] numbers = {
                523, 87, 914, 302, 741, 65, 198, 876, 412, 999,
                134, 567, 289, 710, 455, 23, 808, 376, 690, 512,
                940, 61, 777, 284, 659, 118, 903, 447, 732, 256,
                81, 995, 368, 542, 219, 684, 130, 860, 471, 39,
                775, 608, 294, 921, 156, 703, 488, 267, 845, 320
        };

        // write your logic here
        int evenCount = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] % 2 == 0) evenCount++;
        }

        System.out.printf("There are %d even numbers in the array. \n", evenCount);

    }


    static void exercise14()
    {
        System.out.println();
        System.out.println("14) Print all numbers in this array (in order from highest to lowest)");

        // HINT: sort the array using the Arrays class' Arrays.sort() method
        //       then print the array elements in reverse order

        int[] numbers = {
                142, 789, 305, 912, 67,
                458, 230, 999, 376, 821,
                54, 690, 273, 845, 118,
                962, 401, 736, 589, 214
        };


        // write your logic here
        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >= 0 ; i--)
        {
            System.out.print(numbers[i]);
            System.out.print(" ");
        }
        System.out.println();

    }



    static void exercise15()
    {
        System.out.println();
        System.out.println("15) Write a loop that prompts the user to make a choice");
        System.out.println("    Print the option that the user selected.");
        System.out.println("    Keep looping until the user chooses to exit.");

        Scanner userInput = new Scanner(System.in);
        int selectedOption;

        do
        {

            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("   1) Search for a metal by name");
            System.out.println("   2) Search for metal by melt temperature");
            System.out.println("   3) Print all metals");
            System.out.println("   4) Exit");
            System.out.print("Enter your selection: ");
            selectedOption = Integer.parseInt(userInput.nextLine());

            switch (selectedOption)
            {
                case 1:
                    // metal name
                    System.out.println();
                    System.out.println("Search by metal name...");
                    System.out.println();
                    break;
                case 2:
                    // melt temp
                    System.out.println();
                    System.out.println("Search by metal melt temp...");
                    System.out.println();
                    break;
                case 3:
                    // print all
                    System.out.println();
                    System.out.println("Print all metals...");
                    System.out.println();
                    break;
                case 4:
                    // exit
                    System.out.println();
                    System.out.println("Goodbye");
                    System.out.println();
                    break;
                default:
                    // they made an invalid choice
                    System.out.println();
                    System.out.println("Please select a valid option");
                    System.out.println();
                    break;
            }

        }while (selectedOption != 4);

    }
}
