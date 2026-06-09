package com.pluralsight.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration
{
    private final DataSource dataSource;

    @Bean
    public DataSource dataSource()
    {
        return this.dataSource;
    }

    @Autowired
    public DatabaseConfiguration(@Value("${db.connectionString}") String url,
                                 @Value("${db.username}") String username,
                                 @Value("${db.password}") String password)
    {
        dataSource = new BasicDataSource()
        {{
            setUrl(url);
            setUsername(username);
            setPassword(password);
        }};
    }
}
