package com.github.marschall.springmetadatatest;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import org.h2.jdbcx.JdbcDataSource;

@Configuration
public class JdbcConfiguration {
  
  @Bean
  public DataSource dataSource() {
    JdbcDataSource jdbcDataSource = new JdbcDataSource();
    jdbcDataSource.setUrl("jdbc:h2:mem:test");
    return jdbcDataSource;
  }
  
  @Bean
  public JdbcOperations jdbcOperations() {
    return new JdbcTemplate(this.dataSource());
  }

}
