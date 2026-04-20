package com.pluralsight;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Demos
{
    static void main() throws InterruptedException
    {

        int[] numbers = {14,72,93,34,51};

        for (int i = 0; i < numbers.length; i++)
        {
            int number = numbers[i];
            System.out.println(number);
        }

        System.out.println();
        //foreach(int number in numbers)
        for(int number : numbers)
        {
            System.out.println(number);
        }

        System.out.println();
        LocalTime startTime = LocalTime.now();
        long numberOfSeconds = 0;

        int counter = 0;
        while(numberOfSeconds < 3)
        {
            counter++;
            System.out.println("While loop is working");
            Thread.sleep(200);

            LocalTime endTime = LocalTime.now();
            Duration duration = Duration.between(startTime, endTime);
            numberOfSeconds = duration.getSeconds();
        }
        System.out.println("It looped " + counter + " times");


        Scanner userInput = new Scanner(System.in);
        String keepGoing;
        do{
            System.out.println("looping");

            System.out.print(" Do you want to go again? ");
            keepGoing = userInput.nextLine().trim();

        }while(keepGoing.equalsIgnoreCase("y"));




        int[] prices = { 5, 3, 18, 4 };
        prices[2] = 1;

        for(int index = 0; index < prices.length; index++)
        {
            int price = prices[index];
            System.out.print(price + " ");
        }

    }
}
