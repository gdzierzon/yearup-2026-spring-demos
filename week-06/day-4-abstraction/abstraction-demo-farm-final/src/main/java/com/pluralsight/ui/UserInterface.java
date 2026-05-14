package com.pluralsight.ui;

import com.pluralsight.models.FarmAnimal;

import java.util.Scanner;

public class UserInterface
{
    Scanner input = new Scanner(System.in);



    public void sayHello()
    {
        System.out.println();
        System.out.println("Hello Kids!");
        System.out.println("I'm Old MacDonald...");
        System.out.println("Welcome to my farm!");
        System.out.println();
    }

    public int getHomeScreenChoice()
    {
        while(true)
        {
            System.out.println();
            System.out.println();
            System.out.println("What do you want to do next? ");
            System.out.println("1) Sing the song");
            System.out.println("2) Feed the Animals");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");
            String userInput = input.nextLine().trim();

            System.out.println();
            System.out.println();

            try
            {
                return Integer.parseInt(userInput);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please select a valid option");
            }
        }
    }


    public void singSongIntro()
    {
        System.out.println();
        System.out.println("Okay... Here we go");
        System.out.println();
        System.out.println("Bump dee, Bump dee");
        System.out.println("Bump dee, Bump dee");
        System.out.println();
    }


    public void singVerse(FarmAnimal animal) throws InterruptedException
    {
        String name = animal.getName();
        String sound = animal.getSound();

        System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
        System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
        System.out.println("With a " + sound + " " + sound + " here");
        System.out.println("And a " + sound + " " + sound + " there");
        System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
        System.out.println();

        Thread.sleep(500);
    }

    public void sayGoodbye()
    {
        System.out.println();
        System.out.println("Thanks for Stopping by!");
        System.out.println("Come back soon!");
        System.out.println();
    }
}
