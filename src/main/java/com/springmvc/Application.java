package com.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//import org.springframework.boot.web.support.SpringBootServletInitializer;



//@ComponentScan(basePackages={"com.springmvc.controller",
//		"com.springmvc.dao",
//		"com.springmvc.model",
//		"com.springmvc.persistence",
//		"com.springmvc.service"})

//@Configuration
@EnableEurekaClient
@SpringBootApplication
//@ImportResource("classpath:rest-services-config.xml")
public class Application   {
	
	 public static void main(String[] args) throws Exception  {
		 System.out.println("Start App");
		 SpringApplication.run("classpath:/rest-services-config.xml", args);
	 }

}
