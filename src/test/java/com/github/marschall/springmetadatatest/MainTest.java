package com.github.marschall.springmetadatatest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;

class MainTest {

  @Test
  void getComponentScanApplicationContext() {
    try (ConfigurableApplicationContext applicationContext = Main.getComponentScanApplicationContext();
         Application application = new Application(applicationContext)) {
      application.run();
    }
  }

  @Test
  void getConfigurationApplicationContext() {
    try (ConfigurableApplicationContext applicationContext = Main.getConfigurationApplicationContext();
        Application application = new Application(applicationContext)) {
      application.run();
    }
  }

  @Test
  void getSupplierApplicationContext() {
    try (ConfigurableApplicationContext applicationContext = Main.getSupplierApplicationContext();
        Application application = new Application(applicationContext)) {
      application.run();
    }
  }

}
