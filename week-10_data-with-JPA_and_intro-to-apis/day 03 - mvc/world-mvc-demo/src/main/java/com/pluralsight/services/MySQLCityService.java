package com.pluralsight.services;

import com.pluralsight.models.City;
import com.pluralsight.repository.CitiesDao;

import java.util.List;

public class MySQLCityService implements CityService
{
    CitiesDao cityDao;

    public MySQLCityService(CitiesDao citiesDao)
    {
        this.cityDao = citiesDao;
    }

    @Override
    public City findById(int id)
    {
        return null;
    }

    @Override
    public List<City> searchByCountry(String country)
    {
        // user input validation

        var result = cityDao.getCitiesByCountry(country);

        return result;//.stream().limit(20).toList();
    }

    @Override
    public List<City> searchByState(String sate)
    {
        return List.of();
    }
}
