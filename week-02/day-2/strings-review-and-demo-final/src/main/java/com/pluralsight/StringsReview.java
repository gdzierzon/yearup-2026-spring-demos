package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StringsReview
{
    static void main()
    {
        parseDates();
    }

    static void stringSplitReview()
    {
        String code = "CLTH-KIDS-RED-LRG-1299";
        String value;
        /*
        Step 1
        value = CLTH
        code = KIDS-RED-LRG-1299

        Step 2
        value = KIDS
        code = RED-LRG-1299

        Step 3
        value = RED
        code = LRG-1299

        Step 4
        value = LRG
        code = 1299
         */

    }

    static void stringReview()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String fullName = userInput.nextLine().strip();
        System.out.println("--" + fullName + "-- : length: " + fullName.length());

    }

    static void parseNumbers()
    {
        String userInput = "35.5";
        int age = (int)Double.parseDouble(userInput);
        System.out.println(age);


    }

    static void parseDates()
    {
        Scanner userInput = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        System.out.print("Enter a date: ");
        String dateInput = userInput.nextLine().strip();
        LocalDate theDate = LocalDate.parse(dateInput, formatter);
        System.out.println(theDate);


    }
}
