package com.github.marschall.springmetadatatest.generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import jakarta.annotation.Generated;

import com.github.marschall.springmetadatatest.AbstractDAO;

@Repository
@Generated("com.github.marschall.springmetadatatest.DAOGenerator")
public final class Generated365DAO extends AbstractDAO {

  @Autowired
  public Generated365DAO(JdbcOperations jdbcTemplate) {
    super(jdbcTemplate);
  }

}

