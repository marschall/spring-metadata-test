package com.github.marschall.springmetadatatest;

public abstract class AbstractDAO {
  
  private final Object jdbcTemplate;

  protected AbstractDAO(Object jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

}
