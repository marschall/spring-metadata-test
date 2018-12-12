package com.github.marschall.springmetadatatest;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.marschall.springmetadatatest.configuration.ComponentScanConfiguration;
import com.github.marschall.springmetadatatest.configuration.GeneratedConfiguration;
import com.github.marschall.springmetadatatest.configuration.GeneratedInitializerWithBeanDefinition;
import com.github.marschall.springmetadatatest.configuration.GeneratedInitializerWithSupplier;
import com.github.marschall.springmetadatatest.configuration.JdbcConfiguration;

public class Main {

  static final String registration_mode_component_scan = "component-scan";
  static final String registration_mode_configuration = "configuration";
  static final String registration_mode_bean_defition = "bean-definition";
  static final String registration_mode_supplier = "supplier";

  static final String execution_mode_wait = "wait";
  static final String execution_mode_exit = "exit";

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.err.println("usage registration-mode execution-mode");
    }
    String registrationMode = args[0];
    String executionMode = args[1];

    Application application;
    switch (registrationMode) {
      case registration_mode_component_scan:
      case registration_mode_configuration:
      case registration_mode_bean_defition:
      case registration_mode_supplier:
        application = createApplication(registrationMode);
        break;
      default:
        throw new IllegalArgumentException("unknown registration mode: " + registrationMode);
    }

    try {
      application.run();
      
      switch (executionMode) {
      case execution_mode_wait:
        System.in.read();
      case execution_mode_exit:
        // nothing
        break;
      default:
        throw new IllegalArgumentException("unknown execution mode: " + executionMode);
      }
    } finally {
      application.close();
    }

  }
  
  private static Application createApplication(String registrationMode) {

    ConfigurableApplicationContext applicationContext;
    switch (registrationMode) {
      case registration_mode_component_scan:
        applicationContext = getComponentScanApplicationContext();
        break;
      case registration_mode_configuration:
        applicationContext = getConfigurationApplicationContext();
        break;
      case registration_mode_bean_defition:
        applicationContext = getBeanDefinitionApplicationContext();
        break;
      case registration_mode_supplier:
        applicationContext = getSupplierApplicationContext();
        break;
      default:
        throw new IllegalArgumentException("unknown registration mode: " + registrationMode);
    }
    return new Application(applicationContext);
  }

  static ConfigurableApplicationContext getComponentScanApplicationContext() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    applicationContext.register(JdbcConfiguration.class, ComponentScanConfiguration.class);
    applicationContext.refresh();
    return applicationContext;
  }
  
  static ConfigurableApplicationContext getConfigurationApplicationContext() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    applicationContext.register(JdbcConfiguration.class, GeneratedConfiguration.class);
    applicationContext.refresh();
    return applicationContext;
  }

  static ConfigurableApplicationContext getSupplierApplicationContext() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    applicationContext.register(JdbcConfiguration.class);
    GeneratedInitializerWithSupplier initializer = new GeneratedInitializerWithSupplier();
    initializer.initialize(applicationContext);
    applicationContext.refresh();
    return applicationContext;
  }

  private static ConfigurableApplicationContext getBeanDefinitionApplicationContext() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    applicationContext.register(JdbcConfiguration.class);
    GeneratedInitializerWithBeanDefinition initializer = new GeneratedInitializerWithBeanDefinition();
    initializer.initialize(applicationContext);
    applicationContext.refresh();
    return applicationContext;
  }

}
