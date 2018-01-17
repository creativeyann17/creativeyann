package com.creativeyann.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/admin/msgActions")
	public String msgActions(Model model, @RequestParam(name="remove",required=false) String remove) {
		if(!StringUtils.isEmpty(remove)) {
			List<Long> ids = Arrays.asList(remove.split(",")).stream().map(Long::valueOf).collect(Collectors.toList());
			messageService.deleteAll(ids);
		}
		
		return "redirect:/admin";
		
	}

}
