package com.hsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hsp"})
public class HspApplication {

	public static void main(String[] args) {
		SpringApplication.run(HspApplication.class, args);
	}

}
