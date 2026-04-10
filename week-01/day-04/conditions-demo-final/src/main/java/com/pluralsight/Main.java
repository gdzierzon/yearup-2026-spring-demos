package com.pluralsight;

import java.util.Scanner;

public class Main
{
    // constants for days of the week so that I don't have magic numbers
    private static final int SUNDAY = 0;
    private static final int MONDAY = 1;
    private static final int TUESDAY = 2;
    private static final int WEDNESDAY = 3;
    private static final int THURSDAY = 4;
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;

    static void main()
    {
        // write an app to decide where I am eating based on the day of the week
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("*************** LUNCH TIME ****************");
        System.out.println();

        System.out.print("""
                What day is it today?
                ---------------------
                Sunday.............0
                Monday.............1
                Tuesday............2
                Wednesday..........3
                Thursday...........4
                Friday.............5
                Saturday...........6
                ---------------------
                """);
        System.out.print("Enter the day number: ");
        int selectedDay = scanner.nextInt();
        scanner.nextLine(); // clear the input stream

        System.out.println("Do you have any money? (y/n) ");
        String hasMoney = scanner.nextLine();

        System.out.println("Where will you eat?");
        System.out.println("--------------------");

        if (selectedDay == MONDAY)
        {
            System.out.println("Eat at Arby's");
        }
        else if(selectedDay == TUESDAY && hasMoney.equalsIgnoreCase("y"))
        {
            System.out.println("Costa Vida BABY!");
        }
        else if(selectedDay == WEDNESDAY)
        {
            System.out.println("Papa Johns");
        }
        else if(selectedDay == THURSDAY || selectedDay == FRIDAY)
        {
            System.out.println("Applebees");
        }
        else
        {
            System.out.println("Some good old home cookin'");
        }

    }
}
