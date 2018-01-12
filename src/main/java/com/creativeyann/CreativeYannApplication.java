package com.creativeyann;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CreativeYannApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreativeYannApplication.class, args);
	}
}
