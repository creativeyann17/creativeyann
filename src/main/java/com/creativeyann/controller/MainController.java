package com.creativeyann.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("currentPage", "index");
		return "index";
	}
	
	@GetMapping("/resume")
	public String resume(Model model) {
		model.addAttribute("currentPage", "resume");
		return "resume";
	}
	
	@GetMapping("/projects")
	public String projects(Model model) {
		model.addAttribute("currentPage", "projects");
		return "projects";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("currentPage", "contact");
		return "contact";
	}

}
