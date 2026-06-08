package com.pluralsight.services;

import com.pluralsight.models.City;

import java.util.List;

public interface CitiesDao
{
    City getCityById(int id);
    List<City> getCitiesByCountry(String country);
    List<City> getCitiesByState(String state);
}
