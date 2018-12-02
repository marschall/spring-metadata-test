package com.github.marschall.springmetadatatest.generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import javax.annotation.Generated;

import com.github.marschall.springmetadatatest.AbstractDAO;

@Repository
@Generated("com.github.marschall.springmetadatatest.DAOGenerator")
public final class Generated333DAO extends AbstractDAO {

  @Autowired
  public Generated333DAO(JdbcOperations jdbcTemplate) {
    super(jdbcTemplate);
  }

}

