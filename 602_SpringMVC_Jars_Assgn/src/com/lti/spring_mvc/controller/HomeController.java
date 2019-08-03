package com.lti.spring_mvc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.spring_mvc.model.User;
import com.lti.spring_mvc.services.IGreetingService;

//s-1 annotate controller class with @Controller

@Controller
@RequestMapping(value="/home")
public class HomeController {
	//controller accept the request from ds
	// process the request
	// request model object and viewName to the ds 
	//http://localhost:8082/602_SpringMVC_Jars/home/showHome
	
	@Autowired
	private IGreetingService greetingService;
	
	//  /home/greet
	@RequestMapping(value="/greet")
	public ModelAndView showGreeting() {
		//Create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		//Call service to get data
		String greetMsg = greetingService.greet("Z");
		//Associate data with ModelAndView obj
		mv.addObject("greetMsg", greetMsg);
		//Set the view name
		mv.setViewName("greetPage");
		return mv;
	}

	@RequestMapping(value="/showHome")
	public String showHomePage(Model model, User user)
	{
		model.addAttribute("msg",greetingService.greet("Z"));
		model.addAttribute("today", new Date());
		//User user = new User(101l, "Z", "admin", "admin");
		user.setUserId(99l);
		user.setUsername("Z");
		user.setPassword("admin");
		user.setRole("admin");
		model.addAttribute("user", user);
		String viewName="homePage";
		return viewName;
	}
	
	//---getters and setters---
	public IGreetingService getGreetingService() {
		return greetingService;
	}

	public void setGreetingService(IGreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
}
