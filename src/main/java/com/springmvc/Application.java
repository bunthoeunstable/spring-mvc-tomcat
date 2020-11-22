package com.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


//@ImportResource("META-INF/spring-mvc-servlet.xml")
//@ComponentScan(basePackages={"com.springmvc.controller",
//		"com.springmvc.dao",
//		"com.springmvc.model",
//		"com.springmvc.persistence",
//		"com.springmvc.service"})
//@EnableEurekaClient
//@Configuration
//@EnableAutoConfiguration
@SpringBootApplication
public class Application {
	
	 public static void main(String[] args) {
	 	SpringApplication.run("classpath:/WEB-INF/rest-services-config.xml", args);
	 }

}
