package com.pluralsight.controllers;

import com.pluralsight.models.City;
import com.pluralsight.models.ControllerResponse;
import com.pluralsight.services.CityService;
import com.pluralsight.views.CityListView;

import java.util.List;

public class CitiesController
{
    CityService cityService;

    public CitiesController(CityService cityService)
    {
        this.cityService = cityService;
    }

    public ControllerResponse<List<City>>  searchByCountry(String country)
    {

        List<City> cities = cityService.searchByCountry(country);
        var response = new ControllerResponse(new CityListView(), cities);

        return response;

    }

    public ControllerResponse<List<City>> searchByState(String state)
    {
        List<City> cities = cityService.searchByState(state);

        var response = new ControllerResponse(new CityListView(), cities);

        return response;

    }

    public City searchById(int id)
    {
        City city = cityService.findById(id);
        return city;
    }
}
