package com.lti.spring_mvc.services;

import org.springframework.stereotype.Service;

@Service //(value="greetingService")
public class GreetingService implements IGreetingService{
	
	public GreetingService() {
		System.out.println("DI created " + this.hashCode());
	}
	
	@Override
	public String greet(String name) {
		return "Hello from Spring, Noob " + name;
	}
	

}
