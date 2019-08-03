package com.lti.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="") //not mandatory
public class DefaultController {
	
	@RequestMapping(value="/")
	public String showIndexPage(Model model) {
		model.addAttribute("title","Welcome to my Spring MVC page");
		return "index";
	}
}
