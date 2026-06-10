package com.pluralsight.repository;

import com.pluralsight.models.City;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvCitiesDao implements CitiesDao
{
    private String filePath;

    public CsvCitiesDao(String filePath)
    {
        this.filePath = filePath;
    }

    @Override
    public City getCityById(int id)
    {
        return null;
    }

    @Override
    public List<City> getCitiesByCountry(String country)
    {
        List<City> cities = new ArrayList<>();

        try(FileInputStream stream = new FileInputStream(filePath);
            Scanner scanner = new Scanner(stream)
        )
        {
            // skip header
            scanner.nextLine();

            while (scanner.hasNext())
            {
                var line = scanner.nextLine();
                var parts = line.split("\\|");
                var id = Integer.parseInt(parts[0]);
                var name = parts[1];
                var countryCode = parts[2];
                var district = parts[3];
                var population = Integer.parseInt(parts[4]);

                if(countryCode.equalsIgnoreCase(country))
                {
                    var city = new City(id, name, countryCode, district, population);
                    cities.add(city);
                }
            }
        }
        catch (IOException e)
        {
            // swallow exception
        }

        return cities;
    }

    @Override
    public List<City> getCitiesByState(String state)
    {
        return List.of();
    }
}
