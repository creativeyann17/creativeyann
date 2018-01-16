package com.creativeyann.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("currentPage", "login");
		return "login";
	}

}
