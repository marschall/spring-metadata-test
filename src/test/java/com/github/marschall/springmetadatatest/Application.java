package com.github.marschall.springmetadatatest;

import org.springframework.context.ConfigurableApplicationContext;

import com.github.marschall.springmetadatatest.generated.Generated123DAO;

final class Application implements AutoCloseable {
  
  private final ConfigurableApplicationContext applicationContext;

  Application(ConfigurableApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }
  
  void run() {
    this.applicationContext.getBean(Generated123DAO.class);
  }

  @Override
  public void close() {
    this.applicationContext.close();
  }
  
}
