package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main
{
    // display a list of city names
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 1. open the connection to the database
        String connectionString = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "P@ssw0rd";

        try(Connection connection = DriverManager.getConnection(connectionString, username, password ))
        {

            // 2. execute a query and loop through all cites
            String sql = """
                SELECT Id
                    , Name
                    , CountryCode
                    , District
                    , Population
                FROM city;
                """;

            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            while (row.next())
            {
                int id = row.getInt("Id");
                String city = row.getString("Name");
                String country = row.getString("CountryCode");
                String state = row.getString("District");
                int population = row.getInt("Population");

                System.out.printf("%4d: %-20s %3s %-15s %d  \n", id, city, country, state, population);
            }


            // 3. the connection automatically closes when we exit the try block
        }
        catch(Exception e)
        {}


    }
}