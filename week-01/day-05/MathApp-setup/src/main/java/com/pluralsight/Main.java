package com.pluralsight;


import java.util.Scanner;

public class Main
{
    static void main()
    {
        // declare variables
        Scanner scanner = new Scanner(System.in);
        // create other variables


        // display home screen
        System.out.println("Welcome to Gregor's Math App");

        System.out.print("Enter the first number: ");
        // get input from the user using scanner.nextLine() or scanner.nextDouble()
        System.out.print("Enter the second number: ");
        // get input from the user using scanner.nextLine() or scanner.nextDouble()

        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1) Add");
        System.out.println("2) Subtract");
        System.out.println("3) Multiply");
        System.out.println("4) Divide");
        System.out.print("Enter your selection: ");
        // get the user select option
        int selection;

        if(selection == 1) {

        }else if(selection == 2){

        }else if(selection == 3) {

        } else if(selection == 4) {

        } else {
            System.out.println("you made a BAD choice");
        }

    }
}
