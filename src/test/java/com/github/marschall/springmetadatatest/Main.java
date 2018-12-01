package com.github.marschall.springmetadatatest;

import java.io.IOException;

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

    switch (registrationMode) {
      case registration_mode_component_scan:
        break;
      case registration_mode_configuration:
        break;
      case registration_mode_bean_defition:
        break;
      case registration_mode_supplier:
        break;
      default:
        throw new IllegalArgumentException("unknown registration mode: " + registrationMode);
    }

    switch (executionMode) {
      case execution_mode_wait:
        System.in.read();
      case execution_mode_exit:
        // nothing
        break;
      default:
        throw new IllegalArgumentException("unknown execution mode: " + executionMode);
    }

  }

}
