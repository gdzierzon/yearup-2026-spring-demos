package com.pluralsight;

import com.pluralsight.application.WorldApplication;
import com.pluralsight.repository.CitiesDao;
import com.pluralsight.repository.CsvCitiesDao;
import com.pluralsight.repository.MySqlCitiesDao;
import com.pluralsight.services.CityService;
import com.pluralsight.services.MySQLCityService;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main
{
    private static DataSource dataSource;
    private static String citiesFile;
    private static String daoSource;

    public static void main(String[] args)
    {
        configureProperties();

        CitiesDao dao = daoSource.equals("csv")
                ? new CsvCitiesDao(citiesFile)
                : new MySqlCitiesDao(dataSource);

        CityService service = new MySQLCityService(dao);


        WorldApplication app = new WorldApplication(service);
        app.run();

    }


    private static void configureProperties()
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

            Main.dataSource = dataSource;

            // configure the file path
            Main.citiesFile = properties.getProperty("csv.cities");

            // configures the source
            Main.daoSource = properties.getProperty("dao.source");

        }
        catch (IOException e)
        {
        }

    }
}