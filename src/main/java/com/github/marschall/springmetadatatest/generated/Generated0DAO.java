package com.github.marschall.springmetadatatest.generated;

import jakarta.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.github.marschall.springmetadatatest.AbstractDAO;

@Repository
@Generated("me")
public final class Generated0DAO extends AbstractDAO {

  @Autowired
  public Generated0DAO(JdbcOperations jdbcTemplate) {
    super(jdbcTemplate);
  }

}
