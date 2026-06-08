package com.pluralsight.services;

import com.pluralsight.models.City;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
public class MySqlCitiesDao implements CitiesDao
{
    private DataSource dataSource;

    // Dependency Injection
    // this class is dependent on a datasource
    //      BUT it does NOT know what that datasource is
    // we need to INJECT (or provide) a data source so that it
    //      can do it's work
    public MySqlCitiesDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public City getCityById(int id)
    {
        // 1 - connection to database
        try(Connection connection = dataSource.getConnection())
        {
            // 2 - execute statement (SELECT)
            String sql = """
                SELECT id
                    , name
                    , countryCode AS country
                    , district AS state
                    , population
                FROM city
                WHERE id = ?;
            """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet row = statement.executeQuery();

            if(row.next())
            {
                int cityId = row.getInt("id");
                String name = row.getString("name");
                String country = row.getString("country");
                String state = row.getString("state");
                int population = row.getInt("population");

                City city = new City(cityId, name, country, state, population);
                return city;
            }

            // 3 - close connection
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        // if we get here then no city was found
        return new City();
    }

    @Override
    public List<City> getCitiesByCountry(String country)
    {
        // build an empty list of cities
        List<City> cities = new ArrayList<>();

        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    SELECT id
                        , name
                        , countryCode AS country
                        , district AS state
                        , population
                    FROM city
                    WHERE countryCode = ?;
                    """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, country);

            // execute the statement
            ResultSet row = statement.executeQuery();

            // loop through all rows
            // and add cities to the list
            while(row.next())
            {
                int cityId = row.getInt("id");
                String name = row.getString("name");
                country = row.getString("country");
                String state = row.getString("state");
                int population = row.getInt("population");

                // create new city for each row
                City city = new City(cityId, name, country, state, population);
                cities.add(city);
            }

        }
        catch (SQLException e)
        {
            // log the exception
        }

        return cities;
    }

    @Override
    public List<City> getCitiesByState(String state)
    {
        return List.of();
    }
}
