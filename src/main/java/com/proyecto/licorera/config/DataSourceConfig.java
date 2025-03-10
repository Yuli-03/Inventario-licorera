package com.proyecto.licorera.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "dsInventarioLicorera")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSourceOne(){ return DataSourceBuilder.create().build();}

    @Primary
    @Bean(name = "JdbcTemplateInventarioLicorera")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("dsInventarioLicorera") DataSource ds){
        return new NamedParameterJdbcTemplate(ds);
    }

}
