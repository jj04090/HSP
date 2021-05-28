package com.hsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hsp"})
@EnableScheduling
public class HspApplication {

	public static void main(String[] args) {
		SpringApplication.run(HspApplication.class, args);
	}

}