package com.creativeyann.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.creativeyann.service.MessageService;

@Controller
public class AdminController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("messages",messageService.findAll());
		return "admin";
	}

}
