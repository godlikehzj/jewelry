package com.jewelry.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "enEntityManagerFactory", transactionManagerRef = "enTransactionManager", basePackages = { "com.jewelry.dao.en" })
public class EnDbConfig {
    @Bean
    @Qualifier("enDataSource")
    @ConfigurationProperties(prefix = "jewelry.en.datasource")
    public DataSource enDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Qualifier("enDataSource")
    private DataSource dataSource;

    @Bean
    @Qualifier("enTransactionManager")
    PlatformTransactionManager enTransactionManager() {
        return new JpaTransactionManager(enEntityManagerFactory().getObject());
    }

    @Bean
    @Qualifier("enEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean enEntityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.jewelry.bean.jpa.en");

        return factoryBean;
    }
}
