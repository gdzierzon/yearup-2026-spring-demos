package com.pluralsight.application;

import com.pluralsight.controllers.CitiesController;
import com.pluralsight.controllers.HomeController;
import com.pluralsight.models.AppRequest;

import java.util.Scanner;

public class WorldApplication
{
    Scanner in = new Scanner(System.in);

    HomeController homeController;
    CitiesController citiesController;

    private AppRequest request;


    // Dependency Injection means that SOMEONE ELSE will provide the object that does the work
    // Constructor Injection
    public WorldApplication(HomeController homeController, CitiesController citiesController)
    {
        this.homeController = homeController;
        this.citiesController = citiesController;

        request = new AppRequest("","");
    }

    public void run()
    {
        while(!request.getAction().equals("exit"))
        {
            switch (request.getController())
            {
                case "": // home controller
                    showHomePage();
                    break;
                case "cities": // cities controller
                    routeCities();
                    break;
            }
        }
    }

    private void routeCities()
    {
        switch(request.getAction())
        {
            case "search id":
                showCitySearchId();
                break;
            case "search country":
                showCitySearchCountry();
                break;
            case "display country":
                showCityDisplayCountry();
                break;
            case "search state":
                showCitySearchState();
                break;
        }
    }


    private void showCitySearchId()
    {
    }

    private void showCitySearchCountry()
    {
        var response = citiesController.searchByCountry();
        response.getView().display(response.getModel());

        this.request = response.getView().getRequest();
    }

    private void showCityDisplayCountry()
    {
        var country = request.getInputParameters().getFirst();
        var response = citiesController.searchByCountry(country);
        response.getView().display(response.getModel());

        this.request = response.getView().getRequest();
    }

    private void showCitySearchState()
    {
    }

    private void showHomePage()
    {
        var response = homeController.getHomePage();
        response.getView().display(response.getModel());

        this.request = response.getView().getRequest();
    }

    private void citiesSearchByState()
    {
    }
}
