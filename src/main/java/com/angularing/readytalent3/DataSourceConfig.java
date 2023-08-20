package com.angularing.readytalent3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${DB_URL:}")
    private String databaseURL;

    @Value("${DB_USER:}")
    private String databaseUser;

    @Value("${DB_PASSWORD:}")
    private String databasePassword;

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        //Default to H2 in memory database
        if (databaseURL == ""){
            dataSourceBuilder.url("jdbc:h2:mem:test");
            return dataSourceBuilder.build();
        }

        dataSourceBuilder.url(databaseURL);
        dataSourceBuilder.username(databaseUser);
        dataSourceBuilder.password(databasePassword);

        return dataSourceBuilder.build();
    }
}
