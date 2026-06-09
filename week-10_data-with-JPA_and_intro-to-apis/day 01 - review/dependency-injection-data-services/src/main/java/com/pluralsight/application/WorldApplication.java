package com.pluralsight.application;

import com.pluralsight.models.City;
import com.pluralsight.services.CityService;

import java.util.List;
import java.util.Scanner;

public class WorldApplication
{
    Scanner in = new Scanner(System.in);

    CityService cityService;

    // Dependency Injection means that SOMEONE ELSE will provide the object that does the work
    // Constructor Injection
    public WorldApplication( CityService cityService)
    {
        this.cityService = cityService;
    }

    public void run()
    {
        System.out.println();
        System.out.println("1) search by id");
        System.out.println("2) search by country");
        System.out.println("3) search by state");
        System.out.print("Enter an option: ");
        int choice = Integer.parseInt(in.nextLine());

        switch (choice)
        {
            case 1:
                searchById();
                break;
            case 2:
                searchByCountry();
                break;
            case 3:
                searchByState();
                break;
            default:
                System.out.println("Bad choice");
        }
    }

    private void searchByCountry()
    {
        System.out.print("Enter a country: ");
        String country = in.nextLine();

        List<City> cities = cityService.searchByCountry(country);

        System.out.println();
        cities.forEach(city -> displayCity(city));
    }

    private void searchByState()
    {
        System.out.print("Enter a state name: ");
        String state = in.nextLine();

        List<City> cities = cityService.searchByState(state);

        System.out.println();
        cities.forEach(city -> displayCity(city));
    }

    private void searchById()
    {
        System.out.print("Enter the city Id: ");
        int id = Integer.parseInt(in.nextLine());

        City city = cityService.findById(id);

        System.out.println();
        displayCity(city);
    }



    private void displayCity(City city)
    {
        System.out.printf("%3d  %-30s %s\n", city.getId(), city.getName(), city.getCountry());
    }
}
