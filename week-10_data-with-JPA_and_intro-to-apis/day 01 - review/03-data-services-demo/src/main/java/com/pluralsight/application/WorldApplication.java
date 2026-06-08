package com.pluralsight.application;

import com.pluralsight.models.City;
import com.pluralsight.services.CitiesDao;
import com.pluralsight.services.MySqlCitiesDao;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class WorldApplication
{
    Scanner in = new Scanner(System.in);

    DataSource dataSource;
    CitiesDao citiesDao;

    public WorldApplication()
    {
        this.dataSource = buildDataSource();
        citiesDao = new MySqlCitiesDao(this.dataSource);
    }

    private DataSource buildDataSource()
    {
        try (FileInputStream stream = new FileInputStream("src/main/resources/config.properties"))
        {
            // first get the variables from the properties file
            Properties properties = new Properties();
            properties.load(stream);

            String connectionString = properties.getProperty("db.connectionString");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            // build a BasicDataSource object
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(connectionString);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            return dataSource;

        }
        catch (IOException e)
        {
        }

        return null;
    }

    public void run()
    {
//        findCityById();
        searchByCountry();
    }

    private void findCityById()
    {
        System.out.print("Enter a city id: ");
        int cityId = Integer.parseInt(in.nextLine());

        City city = citiesDao.getCityById(cityId);
        displayCity(city);
    }

    private void searchByCountry()
    {
        System.out.print("Enter a country: ");
        String country = in.nextLine();

        List<City> cities = citiesDao.getCitiesByCountry(country);

        System.out.println();
        cities.forEach(city -> displayCity(city));
    }

    private void displayCity(City city)
    {
        System.out.printf("%3d  %-30s %s\n", city.getId(), city.getName(), city.getCountry());
    }
}
