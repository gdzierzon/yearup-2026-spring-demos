package com.pluralsight.views;

import com.pluralsight.models.AppRequest;

public class HomeView extends ViewBase<String>
{
    public HomeView(AppRequest request)
    {
        super(request);
    }

    @Override
    public void display(String model)
    {
        System.out.println();
        System.out.println("Cities");
        System.out.println("----------------------------");
        System.out.println("1) search for city by id");
        System.out.println("2) search for city by country");
        System.out.println("3) search for city by state");
        System.out.println("----------------------------");
        System.out.println("0) exit");
        System.out.println("----------------------------");

        System.out.print("Enter an option: ");
        var choice = Integer.parseInt(scanner.nextLine());

        switch (choice)
        {
            case 1:
                request.setController("cities");
                request.setAction("search id");
                break;
            case 2:
                request.setController("cities");
                request.setAction("search country");
                break;
            case 3:
                request.setController("cities");
                request.setAction("search state");
                break;
            case 0:
                request.setAction("exit");
        }
    }
}
