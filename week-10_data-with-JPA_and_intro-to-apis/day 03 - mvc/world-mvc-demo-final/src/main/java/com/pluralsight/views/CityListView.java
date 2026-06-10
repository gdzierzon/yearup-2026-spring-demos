package com.pluralsight.views;

import com.pluralsight.models.AppRequest;
import com.pluralsight.models.City;

import java.util.List;

public class CityListView extends ViewBase<List<City>>
{
    public CityListView(AppRequest request)
    {
        super(request);
    }

    @Override
    public void display(List<City> cities)
    {
        for(var city: cities)
        {
            displayCity(city);
        }

    }

    private void displayCity(City city)
    {
        System.out.printf("%3d  %-30s %s\n", city.getId(), city.getName(), city.getCountry());
    }
}
