package com.spring.SpringMavenDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // (represents spring configuration)
@ComponentScan(basePackages = {"bean","com.spring.SpringMavenDemo"})
public class AppConfig {

}
