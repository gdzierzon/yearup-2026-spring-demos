package com.pluralsight.services;

import com.pluralsight.models.City;

import java.util.List;

public interface CityService
{
    List<City> searchByCountry(String country);
}
