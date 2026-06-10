package com.pluralsight.controllers;

import com.pluralsight.models.AppRequest;
import com.pluralsight.models.City;
import com.pluralsight.models.ControllerResponse;
import com.pluralsight.services.CityService;
import com.pluralsight.views.CityGetCountryInputView;
import com.pluralsight.views.CityListView;

import java.util.List;

public class CitiesController
{
    CityService cityService;

    public CitiesController(CityService cityService)
    {
        this.cityService = cityService;
    }

    // first pass at searching
    public ControllerResponse<String>  searchByCountry()
    {
        var request = new AppRequest("cities", "display country");

        var response = new ControllerResponse(new CityGetCountryInputView(request), "");

        return response;

    }

    // second pass - after the user specified a country
    public ControllerResponse<List<City>>  searchByCountry(String country)
    {
        var request = new AppRequest("","");

        List<City> cities = cityService.searchByCountry(country);
        var response = new ControllerResponse(new CityListView(request), cities);

        return response;

    }

    public ControllerResponse<List<City>> searchByState(String state)
    {
        var request = new AppRequest("","");
        List<City> cities = cityService.searchByState(state);

        var response = new ControllerResponse(new CityListView(request), cities);

        return response;

    }

    public City searchById(int id)
    {
        City city = cityService.findById(id);
        return city;
    }
}
