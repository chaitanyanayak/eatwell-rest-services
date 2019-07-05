package com.eatwell.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Configures the spring datasource bean using DataSourceBuilder
 * Uses the spring.datasource properties from application.properties
 */
@Configuration
public class PersistenceConfiguration {

    //This method will return the spring managed datasource bean
    @Bean
    //Tells DataSourceBuilder that the properties start with spring.datasource prefix in application.properties
    @ConfigurationProperties(prefix = "spring.datasource")
    //Sets this as primary if there are multiple datasources
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
