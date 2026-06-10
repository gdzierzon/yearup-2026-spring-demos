package com.pluralsight.views;

public class HomeView extends ViewBase<String>
{
    @Override
    public void display(String model)
    {
        System.out.println();
        System.out.println("1) search for city by id");
        System.out.println("2) search for city by country");
        System.out.println("3) search for city by state");
        System.out.print("Enter an option: ");
        var choice = Integer.parseInt(scanner.nextLine());

        switch (choice)
        {
            case 1:
            case 2:
            case 3:
                input = "cities";
                break;
        }
    }
}
