package com.example.panger77.app.config.data;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PostgresConfig {
//    @Bean
//    public DataSource getDataSource() throws BeanCreationException {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.postgresql.Driver");
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
//        dataSourceBuilder.username("postgres");
//        dataSourceBuilder.password("postgres");
//        return dataSourceBuilder.build();
//    }
    @Bean
    public DataSource getDataSource() throws BeanCreationException {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://ec2-52-30-67-143.eu-west-1.compute.amazonaws.com/dmt5imce6dlrn");
        dataSourceBuilder.username("zlhkerasqtnjlo");
        dataSourceBuilder.password("d4dc87edaf1ac8d01e362614bfc762036c833971a34284b536dd5410da9f7fc5");
        return dataSourceBuilder.build();
    }

}