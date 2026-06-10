package com.pluralsight.application;

import com.pluralsight.controllers.CitiesController;
import com.pluralsight.controllers.HomeController;
import com.pluralsight.models.City;
import com.pluralsight.services.CityService;
import com.pluralsight.views.UserInputView;

import java.util.List;
import java.util.Scanner;

public class WorldApplication
{
    Scanner in = new Scanner(System.in);

    HomeController homeController;
    CitiesController citiesController;


    // Dependency Injection means that SOMEONE ELSE will provide the object that does the work
    // Constructor Injection

    public WorldApplication(HomeController homeController, CitiesController citiesController)
    {
        this.homeController = homeController;
        this.citiesController = citiesController;
    }

    public void run()
    {

        String url = "";

        while(!url.equals("exit"))
        {

            if (url.equalsIgnoreCase(""))
            {
                showHomePage();
            }

//            switch (url)
//            {
//                case 1:
//                    searchForCityById();
//                    break;
//                case 2:
//                    searchForCityByCountry();
//                    break;
//                case 3:
//                    searchForCityByState();
//                    break;
//                default:
//                    System.out.println("Bad choice");
//            }
        }
    }

    private void showHomePage()
    {
        var response = homeController.getHomePage();
        response.getView().display(response.getModel());
    }

    private void searchForCityById()
    {
        System.out.print("Enter a city ID: ");
        int id = Integer.parseInt(in.nextLine());


        var city = citiesController.searchById(id);

        displayCity(city);

    }

    private void searchForCityByCountry()
    {
        String country = UserInputView.promptForString("Enter a country: ");

        var response = citiesController.searchByCountry(country);

        var view = response.getView();
        view.display(response.getModel());

    }

//
//    private void searchForCityByState()
//    {
//        System.out.print("Enter a state: ");
//        String state = in.nextLine();
//
//        var cities = citiesController.searchByState(state);
//
//        for (var city: cities)
//            displayCity(city);
//
//    }


    private void displayCity(City city)
    {
        System.out.printf("%3d  %-30s %s\n", city.getId(), city.getName(), city.getCountry());
    }
}
