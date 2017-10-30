package com.creativeyann;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class CreativeYannApplication {
	
	@RequestMapping("/")
	@ResponseBody
	private String index() {
		return "Work in progress ;)";
	}

	public static void main(String[] args) {
		SpringApplication.run(CreativeYannApplication.class, args);
	}
}
