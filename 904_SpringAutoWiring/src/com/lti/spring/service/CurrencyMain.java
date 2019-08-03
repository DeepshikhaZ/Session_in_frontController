package com.lti.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CurrencyMain {

	public static void main(String[] args) {
		// get spring container using applicationContext
		//1. get xml file location.
		String configLocation="beans.xml";
		ApplicationContext diContainer  =new ClassPathXmlApplicationContext(configLocation);
		//2.
		ICrrencyService currencyService=(ICrrencyService)diContainer.getBean("currencyService");
		//3 call the business method
		System.out.println(currencyService.dollarToRupee(37));
		//System.out.println();
		
	}

}
