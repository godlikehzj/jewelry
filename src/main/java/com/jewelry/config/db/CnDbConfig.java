package com.jewelry.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "cnEntityManagerFactory", transactionManagerRef = "cnTransactionManager", basePackages = { "com.jewelry.dao.cn" })
public class CnDbConfig {
    @Bean
    @Primary
    @Qualifier("cnDataSource")
    @ConfigurationProperties(prefix = "jewelry.cn.datasource")
    public DataSource cnDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Qualifier("cnDataSource")
    private DataSource dataSource;

    @Bean
    @Primary
    @Qualifier("cnTransactionManager")
    PlatformTransactionManager cnTransactionManager() {
        return new JpaTransactionManager(cnEntityManagerFactory().getObject());
    }

    @Bean
    @Primary
    @Qualifier("cnEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean cnEntityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.jewelry.bean.jpa.cn");

        return factoryBean;
    }
}
