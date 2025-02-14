package com.fatima.metro_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
//@EnableWebMvc
public class MetroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetroServiceApplication.class, args);
	}

}
