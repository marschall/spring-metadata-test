package com.github.marschall.springmetadatatest.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.github.marschall.springmetadatatest.generated")
public class ComponentScanConfiguration {

}
