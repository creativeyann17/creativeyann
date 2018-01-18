package com.creativeyann.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.creativeyann.config.EnvConfig;
import com.creativeyann.model.Message;
import com.creativeyann.service.MessageService;

@Controller
public class MainController {
	
	private static final long POST_MESSAGE_ANTI_SPAM = 5 * 60 * 1000;
	
	@Autowired
    private MessageSource i18n;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private EnvConfig envConfig;
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${lastUpdate}")
	private String lastUpdate;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("currentPage", "index");
		model.addAttribute("lastUpdate", lastUpdate);
		return "index";
	}
	
	@GetMapping("/resume")
	public String resume(Model model) {
		model.addAttribute("currentPage", "resume");
		return "resume";
	}
	
	@GetMapping("/articles")
	public String articles(Model model) {
		model.addAttribute("currentPage", "articles");
		return "articles";
	}
	
	@GetMapping("/contact")
	public String contact(Model model, Message messageForm) {
		model.addAttribute("currentPage", "contact");
		model.addAttribute("messageForm", messageForm);
		return "contact";
	}
	
	@PostMapping("/messageForm")
	public String messageForm(Model model, @Valid @ModelAttribute("messageForm") Message messageForm, BindingResult bindingResult, HttpServletRequest request) {
		model.addAttribute("currentPage", "contact");
		
		boolean antiSpam = false;
		Long lastMessage = (Long)request.getSession().getAttribute("lastMessage");
		if(!envConfig.isActiveProfile("dev") && lastMessage != null) {
			antiSpam = (System.currentTimeMillis() - lastMessage) < POST_MESSAGE_ANTI_SPAM;
		}
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", i18n.getMessage("contact.error",null,LocaleContextHolder.getLocale()));
		}else if(antiSpam) {
			model.addAttribute("antispam", i18n.getMessage("contact.antispam",null,LocaleContextHolder.getLocale()));
		} else {
			messageService.save(messageForm);
			request.getSession().setAttribute("lastMessage", System.currentTimeMillis());
			model.addAttribute("messageForm", new Message());
			model.addAttribute("success", i18n.getMessage("contact.success",null,LocaleContextHolder.getLocale()));
		}
		
		return "contact";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("currentPage", "login");
		return "login";
	}

}
