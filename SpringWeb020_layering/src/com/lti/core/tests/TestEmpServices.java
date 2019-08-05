package com.lti.core.tests;

import java.util.ArrayList;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.core.exception.EmpException;
import com.lti.core.model.Employee;
import com.lti.core.services.EmpService;

public class TestEmpServices {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		try {
			EmpService service= ctx.getBean(EmpService.class);//getBean() using type.u can use alias name also
			ArrayList<Employee> empList=service.getEmpList();
			
			empList.forEach(rec->System.out.println(rec));
			((ConfigurableApplicationContext) ctx).close();
		} catch (BeansException e) {
		
			e.printStackTrace();
		} catch (EmpException e) {

			e.printStackTrace();
		}
	}

}
