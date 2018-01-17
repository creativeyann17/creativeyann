package com.creativeyann;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CreativeYannApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(CreativeYannApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

	}

}
