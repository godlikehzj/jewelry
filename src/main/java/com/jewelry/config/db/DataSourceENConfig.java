package com.jewelry.config.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by godlikehzj on 2017/12/26.
 */
@Configuration
public class DataSourceENConfig {
    @Bean(name = "secondaryDS") @Qualifier("secondaryDS")
    @Primary
    @ConfigurationProperties(prefix="jewelry.en.datasource")
    public DataSource enDataSource(){
        return DataSourceBuilder.create().build();
    }
}
