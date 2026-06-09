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
        searchByCountry();
    }

    private void searchByCountry()
    {
        System.out.print("Enter a country: ");
        String country = in.nextLine();

        List<City> cities = cityService.searchByCountry(country);

        System.out.println();
        cities.forEach(city -> displayCity(city));
    }

    private void displayCity(City city)
    {
        System.out.printf("%3d  %-30s %s\n", city.getId(), city.getName(), city.getCountry());
    }
}
