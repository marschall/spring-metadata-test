package com.github.marschall.springmetadatatest;

import org.springframework.jdbc.core.JdbcOperations;

public abstract class AbstractDAO {
  
  private final JdbcOperations jdbcTemplate;

  protected AbstractDAO(JdbcOperations jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

}
