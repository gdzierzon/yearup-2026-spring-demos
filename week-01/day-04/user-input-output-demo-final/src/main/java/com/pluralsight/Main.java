package com.pluralsight;


import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    static void main()
    {
        // System.out - stream that allows us to display something to the screen
        // System.in - stream of data that comes from user input into our system
        Scanner input = new Scanner(System.in);
        String userInput;
        String productName;
        double price;
        int quantity;

        System.out.print("Enter a product name: ");
        productName = input.nextLine(); // read everything up to and including \n
        System.out.println("You entered " + productName);

        System.out.print("What is the price? ");
        userInput = input.nextLine();
        price = Double.parseDouble(userInput);

//        price = input.nextDouble();
//        input.nextLine(); // clear the stream

        System.out.print("How many do you want? ");
        quantity = input.nextInt();
        input.nextLine(); // clear the stream

        System.out.print("What is your favorite sport? ");
        String sport = input.nextLine();

        System.out.println("Sport: " + sport );




//
        System.out.printf("You ordered %d %s at the cost of $ %.2f each. \n", quantity, productName, price);
//        System.out.print(String.format("%s costs $ %f \n", productName, price));

    }
}
