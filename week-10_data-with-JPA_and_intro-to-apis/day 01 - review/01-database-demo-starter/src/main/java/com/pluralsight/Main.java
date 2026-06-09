package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        String username = "root";
        String password = "P@ssw0rd";

        try
        {
            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection;
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world",
                    username,
                    password);

            // 2. execute a statement
            String sql = """
                    SELECT Id
                        , Name
                        , CountryCode
                    FROM city;
                    """;
            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            // 2 a. - read the results
            while(row.next())
            {
                int id = row.getInt("Id");
                String name = row.getString("Name");
                String country = row.getString("CountryCode");

                System.out.printf("%3d  %-30s %s\n", id, name, country);
            }


            // 3. close the connection
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}